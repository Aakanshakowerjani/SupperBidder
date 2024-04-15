package service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dto.Auction;
import dto.Bid;
import dto.Buyer;
import repository.AuctionRepo;
import repository.UserRepo;
import service.BuyerService;

public class BuyerServiceImpl implements BuyerService {
	
	List<Buyer> buyerList;
	HashMap<String,Auction> auctionMap;
	HashMap<String, List<Bid>> bidAuctionMap;
	
	public BuyerServiceImpl() {
		// TODO Auto-generated constructor stub
		this.buyerList=UserRepo.getBuyers();
		this.auctionMap=AuctionRepo.getAuctionMap();
		this.bidAuctionMap=AuctionRepo.getAuctionBidMap();
	}

	@Override
	public void addBuyer(String buyerName) {
		// TODO Auto-generated method stub
		buyerList.add(new Buyer(buyerName));
		System.out.println("Buyer added Successfully!!");
	}
	
	boolean validateBuyer(String buyerName) {
		for(Buyer buyer: buyerList) {
			if(buyerName.equals(buyer.getBuyerName())) return true;
		}
		return false;
	}
	
	boolean validateAuction(String auctionName) {
		if(auctionMap.containsKey(auctionName) && auctionMap.get(auctionName).isActive()) return true;
		return false;
	}

	@Override
	public void createBid(String buyerName, String auctionName, int amount) throws Exception {
		// TODO Auto-generated method stub
		if(!validateBuyer(buyerName)) throw new Exception("Buyer Not Found!!");
		if(!validateAuction(auctionName)) throw new Exception("Auction Not Found!!");
		
		if(amount>auctionMap.get(auctionName).getMaxPrice() || amount<auctionMap.get(auctionName).getMinPrice()) 
			throw new Exception("Invalid Amount!!");
		
		List<Bid> bidList;
		if(bidAuctionMap.containsKey(auctionName)) bidList=bidAuctionMap.get(auctionName);
		else bidList=new ArrayList<Bid>();
		
		Bid bid=new Bid(buyerName,auctionName,amount);
		bidList.add(bid);
		
		bidAuctionMap.put(auctionName, bidList);
		
		System.out.println("Bid Created Successfully!!");
		
	}
	
	int getBidPosition(List<Bid> bidList,String buyerName) throws Exception {
		int position=-1;
		for(int ind=0;ind<bidList.size();ind++) {
			if(buyerName.equals(bidList.get(ind).getBuyerName())) {
				position=ind;
				break;
			}
		}
		if(position==-1) throw new Exception("No Bid Present to Update!!");
		return position;
	}

	@Override
	public void updateBid(String buyerName, String auctionName, int amount) throws Exception {
		// TODO Auto-generated method stub
		
		if(!validateBuyer(buyerName)) throw new Exception("Buyer Not Found!!");
		if(!validateAuction(auctionName)) throw new Exception("Auction Not Found!!");
		
		if(!bidAuctionMap.containsKey(auctionName)) throw new Exception("No Bid Present for this auction!!");
		if(amount>auctionMap.get(auctionName).getMaxPrice() || amount<auctionMap.get(auctionName).getMinPrice()) 
			throw new Exception("Invalid Amount!!");
		List<Bid> bidList= bidAuctionMap.get(auctionName);
		
		int bidPosition=getBidPosition(bidList,buyerName);
		bidList.remove(bidPosition);
		bidList.add(new Bid(buyerName,auctionName,amount));
		bidAuctionMap.put(auctionName, bidList);
		
		System.out.println("Bid Updated Successfully!!");
		
	}

	@Override
	public void withdrawBid(String buyerName, String auctionName) throws Exception {
		// TODO Auto-generated method stub
		
		if(!validateBuyer(buyerName)) throw new Exception("Buyer Not Found!!");
		if(!validateAuction(auctionName)) throw new Exception("Auction Not Found!!");
		
		if(!bidAuctionMap.containsKey(auctionName)) throw new Exception("No Bid Present for this auction!!");
		List<Bid> bidList= bidAuctionMap.get(auctionName);
		
		int bidPosition=getBidPosition(bidList,buyerName);
		bidList.remove(bidPosition);
		bidAuctionMap.put(auctionName, bidList);
		
		System.out.println("Bid Withdraw Successful!!");
		
	}

}
