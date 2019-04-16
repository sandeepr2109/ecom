package com.Ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Repo.ItemRepository;
import com.Ecommerce.Repo.OderRepository;
import com.Ecommerce.Repo.OrderDetailsRepository;
import com.Ecommerce.entity.ItemJpaRecord;
import com.Ecommerce.entity.OderJpaRecord;
import com.Ecommerce.entity.OrderDetailsJpaRecord;
import com.Ecommerce.entity.OrderInfo;

@Service
public class EcomService {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	@Autowired
	OderRepository orderRepository;
	
	
	
	
	
	public List<ItemJpaRecord> getAllItems() {
		return itemRepository.findAll();
	}

	public Optional<ItemJpaRecord> getItem(int id) {
		return itemRepository.findById(id);
	}

	public boolean checkItem(int id) {
		return itemRepository.existsById(id);
	}

	public ItemJpaRecord insertItems(ItemJpaRecord ijr) {
		return itemRepository.save(ijr);
	}

	public void deleteItems(int id) {
		itemRepository.deleteById(id);
	}

	
	public void cancelOrder(int id) {
		orderRepository.deleteById(id);
	}
	
	
	 public boolean orderItem(OrderInfo Oi) {
		 boolean data=false;
		 if(Oi !=null) {
			 ItemJpaRecord j=itemRepository.findById(Oi.getItemId()).orElse(null);
				int alloc=j.getQuantity()-j.getAllocated();
				int newalloc=j.getAllocated()+Oi.getQuantity();
				if(Oi.getQuantity()<=alloc) {
	 System.out.println("======================="+orderRepository.count()); 
	 long count=orderRepository.count()+1;
	 Long l=new Long(count);
	 Oi.setOrderId(l.intValue());
	 OderJpaRecord oderJpaRecord=new OderJpaRecord();
	 oderJpaRecord.setEmailId(Oi.getEmailId());			
	 oderJpaRecord.setOrderId(Oi.getOrderId());
	 orderRepository.save(oderJpaRecord);	
	 OrderDetailsJpaRecord orderDetailsJpaRecord= new OrderDetailsJpaRecord();
	 orderDetailsJpaRecord.setOrderDetailId(l.intValue());
	 orderDetailsJpaRecord.setItemId(Oi.getItemId());
	 orderDetailsJpaRecord.setItemName(Oi.getItemName());
	 orderDetailsJpaRecord.setQuantity(Oi.getQuantity());
	 orderDetailsJpaRecord.setAllocated(Oi.getQuantity());		 
	orderDetailsRepository.save(orderDetailsJpaRecord);	
	j.setAllocated(newalloc);
	itemRepository.save(j);
	data=true;}
		 }
		 return data;
	 }
	 
	 public boolean cancelOrder(OrderDetailsJpaRecord Oi)
	 {
		 boolean flag=false;
		 if(Oi!=null)
		 {
			 ItemJpaRecord j=itemRepository.findById(Oi.getItemId()).orElse(null);
			 int t=j.getAllocated()-Oi.getAllocated();
			 j.setAllocated(t);
			 itemRepository.save(j);
			 orderDetailsRepository.deleteById(Oi.getOrderDetailId());
			 orderRepository.deleteById(Oi.getOrderDetailId());
			 flag=true;
		 }
		 return flag;
	 }
	 
	 
	 public boolean updateOrder(OrderDetailsJpaRecord Oi)
	 {
		 boolean flag=false;
		 if(Oi !=null) {
			 ItemJpaRecord j=itemRepository.findById(Oi.getItemId()).orElse(null);
			 OrderDetailsJpaRecord k=orderDetailsRepository.findById(Oi.getItemId()).orElse(null);
				int alloc=j.getQuantity()-j.getAllocated()+k.getAllocated();
				int newalloc=alloc-Oi.getQuantity();
				if(Oi.getQuantity()<=alloc) {	
					 j.setAllocated(newalloc);
					 orderDetailsRepository.save(Oi);
					 itemRepository.save(j);
						
				}
				flag=true;
				}
		 return flag;
	 }

}
