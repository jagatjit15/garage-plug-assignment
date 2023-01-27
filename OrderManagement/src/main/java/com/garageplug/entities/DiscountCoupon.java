package com.garageplug.entities;

public class DiscountCoupon {

	private Long OrderId;
	private String discountValue;
	
	
	public DiscountCoupon() {
		super();
	}


	public DiscountCoupon(Long orderId, String discountValue) {
		super();
		OrderId = orderId;
		this.discountValue = discountValue;
	}


	public Long getOrderId() {
		return OrderId;
	}


	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}


	public String getDiscountValue() {
		return discountValue;
	}


	public void setDiscountValue(String discountValue) {
		this.discountValue = discountValue;
	}
	
	
	
	
	
	
}
