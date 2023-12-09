package management.model;

public class Basket {
	private int id;
	private int idusers;
	private int idproduct;
	private int price;

	
	public Basket (int id, int idusers, int idproduct, int price) {
		super();
		this.id = id;
		this.idusers = idusers;
		this.idproduct = idproduct;
		this.price = price;
	}
	
	
	public Basket(int idusers, int idproduct, int price) {
		super();
		this.idusers = idusers;
		this.idproduct = idproduct;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getIdusers() {
		return idusers;
	}


	public void setIdusers(int idusers) {
		this.idusers = idusers;
	}


	public int getIdproduct() {
		return idproduct;
	}


	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
}
