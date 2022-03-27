package com.torres.app.item.model.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torres.app.item.clientes.ProductoClienteRest;
import com.torres.app.item.model.Item;
import com.torres.app.item.model.service.ItemService;

@Service("feignClient")
public class ItemServiceFeignImpl implements ItemService {

	@Autowired
	private ProductoClienteRest clieRestTemplate;

	@Override
	public List<Item> findAll() {
		return clieRestTemplate.findAll().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clieRestTemplate.findById(id), cantidad);
	}

}
