package com.torres.app.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torres.app.item.model.Item;
import com.torres.app.item.model.service.ItemService;

@RestController
@RequestMapping("items")
public class ItemController {

	@Autowired
	@Qualifier("feignClient")
	private ItemService itemService;

	@GetMapping
	public List<Item> findAll() {
		return itemService.findAll();
	}

	@GetMapping("/{id}/cantidad/{cantidad}")
	public Item findById(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
}
