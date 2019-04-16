package com.Ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Repo.ItemRepository;
import com.Ecommerce.Repo.OrderDetailsRepository;
import com.Ecommerce.Repo.OrderInfoRepository;
import com.Ecommerce.Repo.OrderRepository;
import com.Ecommerce.entity.ItemJpaRecord;
import com.Ecommerce.entity.OrderDetailsJpaRecord;
import com.Ecommerce.entity.OrderInfo;
import com.Ecommerce.entity.OrderJpaRecord;

@Service
public class EcomService {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderInfoRepository orderInfoRepository;

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

	public List<OrderInfoRepository> listAllOrders() {
		return orderInfoRepository.findAll();
	}

	public Optional<OrderInfoRepository> getOrder(int id) {
		return orderInfoRepository.findById(id);
	}

	public boolean checkOrder(int id) {
		return orderInfoRepository.existsById(id);
	}
	
	public void cancelOrder(int id) {
		orderRepository.deleteById(id);
	}

}
