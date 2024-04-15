package service;

import dto.Auction;

public interface SellerService {

	void addSeller(String sellerName);
	
	void createAuction(String auctionName,int minPrice,int maxPrice, String sellerName) throws Exception;
	
	void closeAuction(String auctionName) throws Exception;
}
