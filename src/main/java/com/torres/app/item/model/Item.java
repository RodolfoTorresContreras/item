package com.torres.app.item.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

	private Producto producto;
	private Integer cantidad;

	public BigDecimal getTotal() {
		return producto.getPrecio().multiply(new BigDecimal(cantidad));
	}
}
