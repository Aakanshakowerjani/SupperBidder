package dto;

public class Bid {

	String buyerName;
	String auctionName;
	int price;
	
	public Bid(String buyerName, String auctionName, int price) {
		// TODO Auto-generated constructor stub
		this.auctionName=auctionName;
		this.buyerName=buyerName;
		this.price=price;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getAuctionName() {
		return auctionName;
	}

	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
