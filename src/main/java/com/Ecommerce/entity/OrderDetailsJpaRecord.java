/*
 * Created on 2019-04-16 ( Date ISO 2019-04-16 - Time 01:29:00 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package com.Ecommerce.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Persistent class for "OrderDetails" entity stored in table "order_details"
 * <br>
 * This class is a "record entity" without JPA links <br>
 *
 *
 */
@Entity
@Table(name = "order_details", schema = "public")
// Define named queries here
/*
 * @NamedQueries ( {
 * 
 * @NamedQuery ( name="OrderDetailsJpaRecord.countAll",
 * query="SELECT COUNT(x) FROM OrderDetailsJpaRecord x" ),
 * 
 * @NamedQuery ( name="OrderDetailsJpaRecord.countById",
 * query="SELECT COUNT(x) FROM OrderDetailsJpaRecord x WHERE x.orderDetailId = ?1 "
 * ) } )
 */
public class OrderDetailsJpaRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@Column(name = "order_detail_id", nullable = false)
	private Integer orderDetailId;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "item_id")
	private Integer itemId;

	@Column(name = "item_name", length = 2147483647)
	private String itemName;

	@Column(name = "quantity")
	private Integer quantity;

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public OrderDetailsJpaRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------
	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Integer getOrderDetailId() {
		return this.orderDetailId;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------
	// --- DATABASE MAPPING : item_id ( int4 )
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getItemId() {
		return this.itemId;
	}

	// --- DATABASE MAPPING : item_name ( varchar )
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemName() {
		return this.itemName;
	}

	// --- DATABASE MAPPING : quantity ( int4 )
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(orderDetailId);
		sb.append("]:");
		sb.append(itemId);
		sb.append("|");
		sb.append(itemName);
		sb.append("|");
		sb.append(quantity);
		return sb.toString();
	}

}