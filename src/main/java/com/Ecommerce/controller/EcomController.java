package com.Ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.entity.ItemJpaRecord;
import com.Ecommerce.entity.OrderJpaRecord;
import com.Ecommerce.service.EcomService;

@RestController
@RequestMapping("/")
public class EcomController {

	@Autowired
	EcomService ecomService;

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

}
