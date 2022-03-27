package com.torres.app.item.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Producto {

	private Long id;
	private String nombre;
	private BigDecimal precio;
	private Date createAt;
	private Integer port;
}
