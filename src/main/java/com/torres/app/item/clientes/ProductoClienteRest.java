package com.torres.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.torres.app.item.model.Producto;

@FeignClient(name = "servicio.productos")
public interface ProductoClienteRest {

	@GetMapping("/productos")
	public List<Producto> findAll();

	@GetMapping("/productos/{id}")
	public Producto findById(@PathVariable Long id);
}
