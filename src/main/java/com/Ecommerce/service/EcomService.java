package com.Ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Repo.ItemRepository;
import com.Ecommerce.entity.ItemJpaRecord;

@Service
public class EcomService {

	@Autowired
	ItemRepository itemRepository;

	public List<ItemJpaRecord> getAllItems() {
		return itemRepository.findAll();
	}

	public ItemJpaRecord insertItems(ItemJpaRecord ijr) {
		return itemRepository.save(ijr);
	}

	public void deleteItems(int id) {
		itemRepository.deleteById(id);
	}

	public Optional<ItemJpaRecord> getItem(int id) {
		return itemRepository.findById(id);
	}
	
	public boolean checkItem(int id) {
		return itemRepository.existsById(id);
	}

}
