package com.torres.app.item.model.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.torres.app.item.model.Item;
import com.torres.app.item.model.Producto;
import com.torres.app.item.model.service.ItemService;

@Service("restTemplate")
public class ItemServiceRestTemplateImpl implements ItemService {

	@Autowired
	private RestTemplate clieRestTemplate;
	private final static String urlProducto = "http://localhost:8001/productos";
	
	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList(clieRestTemplate.getForObject(urlProducto, Producto[].class));
		return productos.stream().map(producto -> new Item(producto, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariable = new HashMap<>();
		pathVariable.put("id", id.toString());
		Producto producto = clieRestTemplate.getForObject(urlProducto+"/{id}", Producto.class,pathVariable);
		return new Item(producto, cantidad);
	}

}
