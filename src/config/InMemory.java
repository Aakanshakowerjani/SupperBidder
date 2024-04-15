package config;

import repository.AuctionRepo;
import repository.UserRepo;

public class InMemory {
	
	AuctionRepo auctionRepo;
	UserRepo userRepo;
	
	public InMemory() {
		// TODO Auto-generated constructor stub
		auctionRepo=new AuctionRepo();
		userRepo=new UserRepo();
	}

}
