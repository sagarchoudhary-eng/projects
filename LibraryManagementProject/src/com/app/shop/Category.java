package com.app.shop;

public enum Category {
	FICTION,SCIENCE,FINANCE,YOGA,MEDITATION ;
	@Override
	public String toString() {
		return name().toUpperCase();
	}
}
