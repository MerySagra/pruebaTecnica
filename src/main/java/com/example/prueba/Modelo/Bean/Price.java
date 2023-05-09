package com.example.prueba.Modelo.Bean;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/*
Modelo de entity para la tabla PRICES
 */

@Entity
@Table(name = "PRICES")
public class Price {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BRAND_ID")
	private Long brandId;

	@Column(name = "START_DATE")
	private LocalDateTime startDate;

	@Column(name = "END_DATE")
	private LocalDateTime endDate;

	@Column(name = "PRICE_LIST")
	private Long priceList;

	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "PRIORITY")
	private Integer priority;

	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "CURR")
	private String curr;

	public Price() {
	}

	public Price(Long brandId, LocalDateTime startDate, LocalDateTime endDate,
				 Long priceList, Long productId, Integer priority, BigDecimal price, String curr) {
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}

	//Getters y Setters

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	//toString

	@Override
	public String toString() {
		return "Price{" +
				"brandId=" + brandId +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", priceList=" + priceList +
				", productId=" + productId +
				", priority=" + priority +
				", price=" + price +
				", curr='" + curr + '\'' +
				'}';
	}

	//Equals y HashCode

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Price)) return false;
		Price price1 = (Price) o;
		return Objects.equals(getBrandId(), price1.getBrandId()) && Objects.equals(getStartDate(), price1.getStartDate()) && Objects.equals(getEndDate(), price1.getEndDate()) && Objects.equals(getPriceList(), price1.getPriceList()) && Objects.equals(getProductId(), price1.getProductId()) && Objects.equals(getPriority(), price1.getPriority()) && Objects.equals(getPrice(), price1.getPrice()) && Objects.equals(getCurr(), price1.getCurr());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getBrandId(), getStartDate(), getEndDate(), getPriceList(), getProductId(), getPriority(), getPrice(), getCurr());
	}
}