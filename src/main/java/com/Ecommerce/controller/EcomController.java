package com.Ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Repo.OderRepository;
import com.Ecommerce.Repo.OrderDetailsRepository;
import com.Ecommerce.entity.ItemJpaRecord;
import com.Ecommerce.entity.OderJpaRecord;
import com.Ecommerce.entity.OrderDetailsJpaRecord;
import com.Ecommerce.entity.OrderInfo;
import com.Ecommerce.service.EcomService;

@RestController
@RequestMapping("/")
public class EcomController {

	@Autowired
	EcomService ecomService;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	@Autowired
	OderRepository orderRepository;
	

	@RequestMapping("/getAllItems")
	public List<ItemJpaRecord> getAllItems() {
		return ecomService.getAllItems();
	}

	@RequestMapping("/getItem/{id}")
	public Optional<ItemJpaRecord> getItems(@PathVariable int id) {
		return ecomService.getItem(id);
	}

	@RequestMapping(value = "/AddItem")
	public String insertItem(@RequestBody ItemJpaRecord ijr) {
		boolean flag = false;
		if (ijr != null) {
			if (ecomService.checkItem(ijr.getItemId())) {
				return "Item is Already Added";
			}
			ItemJpaRecord i = ecomService.insertItems(ijr);

			if (i != null) {
				flag = true;
			}
		}
		if (flag) {
			return "Added Item Successfully";
		} else {
			return "Failed to Add Item";
		}
	}

	@RequestMapping(value = "/UpdateItem")
	public String updateItem(@RequestBody ItemJpaRecord ijr) {
		boolean flag = false;
		if (ijr != null) {
			if (!ecomService.checkItem(ijr.getItemId())) {
				return "No Item exists";
			}
			ItemJpaRecord i = ecomService.insertItems(ijr);
			if (i != null) {
				flag = true;
			}
		}
		if (flag) {
			return "Updated Item Successfully";
		} else {
			return "Failed to Update Item";
		}

	}

	@RequestMapping("/DeleteItem/{id}")
	public String deleteItem(@PathVariable Integer id) {
		if (id != null) {
			ecomService.deleteItems(id);
		}
		return "Deleted Successfully";
	}
	
	
	 @RequestMapping("/OrderItem") 
	 public String orderItem(@RequestBody OrderInfo Oi) { 
		 boolean flag=ecomService.orderItem(Oi); 
		 if(flag)
		 {
			 return "Order successful";
		 }
		 
		 else return "Order un successful";
		 }
	 
	 @RequestMapping("/CancelOrder") 
	 public String CancelOrder(@RequestBody OrderDetailsJpaRecord Oi) { 
		 boolean flag=ecomService.cancelOrder(Oi); 
		 if(flag)
		 {
			 return "Cancel successful";
		 }
		 
		 else return "Cancel un successful";
		 }
	 
	 @RequestMapping("/UpdateOrder") 
	 public String updateOrder(@RequestBody OrderDetailsJpaRecord Oi) { 
		 boolean flag=ecomService.updateOrder(Oi); 
		 if(flag)
		 {
			 return "Update successful";
		 }
		 
		 else return "Update un successful";
		 }
	 

	 

}
