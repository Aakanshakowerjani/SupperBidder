package dto;

public class Auction {
	
	String auctionName;
	String sellerName;
	int maxPrice;
	int minPrice;
	boolean active;
	
	public Auction(String auctionName, int minPrice, int maxPrice, String sellerName) {
		// TODO Auto-generated constructor stub
		this.auctionName=auctionName;
		this.minPrice=minPrice;
		this.maxPrice=maxPrice;
		this.sellerName=sellerName;
		this.active=true;
	}

	public String getAuctionName() {
		return auctionName;
	}

	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
}
