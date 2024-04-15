package repository;

import java.util.HashMap;
import java.util.List;

import dto.Auction;
import dto.Bid;

public class AuctionRepo {
	
	// AuctionName - Auction
	static HashMap<String,Auction> auctionMap;
	// AuctionNAme - Bid
	static HashMap<String,List<Bid>> auctionBidMap;
	
	public AuctionRepo(){
		AuctionRepo.auctionMap=new HashMap<String,Auction>();
		AuctionRepo.auctionBidMap=new HashMap<String,List<Bid>>();
	}

	public static HashMap<String, Auction> getAuctionMap() {
		return auctionMap;
	}

	public static HashMap<String, List<Bid>> getAuctionBidMap() {
		return auctionBidMap;
	}
	

}
