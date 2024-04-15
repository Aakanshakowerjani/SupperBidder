package service;

import dto.Bid;

public interface BuyerService {
	
	void addBuyer(String buyerName);
	
	void createBid(String buyerName, String auctionName, int amount) throws Exception;
	
	void updateBid(String buyerName, String auctionName, int amount) throws Exception;
	
	void withdrawBid(String buyerName,String auctionName) throws Exception;

}
