package service.serviceImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import dto.Auction;
import dto.Bid;
import dto.Seller;
import repository.AuctionRepo;
import repository.UserRepo;
import service.SellerService;

public class SellerServiceImpl implements SellerService {
	
	List<Seller> sellerList;
	HashMap<String,Auction> auctionMap;
	HashMap<String,List<Bid>> bidAuctionMap;
	
	public SellerServiceImpl() {
		// TODO Auto-generated constructor stub
		this.sellerList=UserRepo.getSellers();
		this.auctionMap=AuctionRepo.getAuctionMap();
		this.bidAuctionMap=AuctionRepo.getAuctionBidMap();
	}

	@Override
	public void addSeller(String sellerName) {
		// TODO Auto-generated method stub
		sellerList.add(new Seller(sellerName));
		System.out.println("Seller added Successfully!!");
	}
	
	boolean validateSeller(String sellerName) {
		for(Seller seller: sellerList) {
			if(sellerName.equals(seller.getSellerName())) return true;
		}
		return false;
	}

	@Override
	public void createAuction(String auctionName, int minPrice, int maxPrice, String sellerName) throws Exception{
		// TODO Auto-generated method stub
		if(!validateSeller(sellerName)) 
			throw new Exception("Seller Not Found!!");
		Auction auction=new Auction(auctionName,minPrice,maxPrice,sellerName);
		auctionMap.put(auctionName, auction);
		System.out.println("Auction Created Successfully!!");
	}

	@Override
	public void closeAuction(String auctionName) throws Exception {
		// TODO Auto-generated method stub
		
		if(!auctionMap.containsKey(auctionName)) throw new Exception("No Auction avalaible with this name!!");
		if(!bidAuctionMap.containsKey(auctionName)) System.out.println("No Winner because no bid present!!");
		if(!auctionMap.get(auctionName).isActive()) throw new Exception("Auction is already Closed!!");
		else {
			List<Bid> bidList=bidAuctionMap.get(auctionName);
			/* Fetching highest Bid
			 * Change bid2 -> bid1 and vice versa for fetching lowest bid
			 */
			Collections.sort(bidList,(bid1,bid2)-> bid2.getPrice()-bid1.getPrice());
			int ind=0;
			boolean winner=false;
			while(ind<bidList.size()){
				int currPosition=ind, amount=bidList.get(currPosition).getPrice();
				while(ind<bidList.size() && bidList.get(ind).getPrice()==amount) ind++;
				if(ind==currPosition || currPosition==bidList.size()-1) {
					System.out.println("Winner is "+ bidList.get(currPosition).getBuyerName()+ "with ammount "+ bidList.get(currPosition).getPrice());
					winner=true;
					break;
				}
			}
			if(!winner) System.out.println("No Winner!!");
		}
		
		Auction auction=auctionMap.get(auctionName);
		auction.setActive(false);
		auctionMap.put(auctionName, auction);
		System.out.println("Auction Closed Successfully!!");
	}
	

}
