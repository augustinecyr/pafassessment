package vttp2022.paf.assessment.eshop.models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

// DO NOT CHANGE THIS CLASS
public class Order {

	private String orderId;
	private String deliveryId;
	private String name;
	private String address;
	private String email;
	private String status;
	private Date orderDate = new Date();
	private List<LineItem> lineItems = new LinkedList<>();

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDeliveryId() {
		return this.deliveryId;
	}

	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setAddress(address);
		customer.setEmail(email);
		return customer;
	}

	public void setCustomer(Customer customer) {
		name = customer.getName();
		address = customer.getAddress();
		email = customer.getEmail();
	}

	public List<LineItem> getLineItems() {
		return this.lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public void addLineItem(LineItem lineItem) {
		this.lineItems.add(lineItem);
	}

	public static Order create(SqlRowSet orderRs, List<Order> orders) {
		Order ord = new Order();
		ord.setOrderId(orderRs.getString("order_id"));
		ord.setDeliveryId(orderRs.getString("delivery_id"));
		ord.setName(orderRs.getString("name"));
		ord.setAddress(orderRs.getString("address"));
		ord.setEmail(orderRs.getString("email"));
		ord.setStatus(orderRs.getString("status"));
		ord.setOrderDate(orderRs.getDate("order_date"));

		return ord;
	}

	public JsonObject toJSON() {

		JsonObjectBuilder builder = Json.createObjectBuilder();

		builder.add("order_id", this.getOrderId());
		builder.add("deliver_id", this.getDeliveryId());
		builder.add("name", this.getName());
		builder.add("address", this.getAddress());
		builder.add("email", this.getEmail());
		builder.add("status", this.getStatus());
		builder.add("order_date", this.getOrderDate().toString());

		return builder.build();
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", deliveryId=" + deliveryId + ", name=" + name + ", address=" + address
				+ ", email=" + email + ", status=" + status + ", orderDate=" + orderDate + ", lineItems=" + lineItems
				+ "]";
	}

}
