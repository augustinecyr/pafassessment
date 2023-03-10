package vttp2022.paf.assessment.eshop.models;

// DO NOT CHANGE THIS CLASS
public class LineItem {

	private String item;
	private Integer quantity;

	public LineItem() {
    }

    public LineItem(String item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "LineItem [item=" + item + ", quantity=" + quantity + "]";
	}
	
}
