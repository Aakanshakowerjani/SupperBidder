package repository;

import java.util.ArrayList;
import java.util.List;

import dto.Buyer;
import dto.Seller;

public class UserRepo {

	static List<Seller> sellers;
	static List<Buyer> buyers;
	
	public UserRepo(){
		this.sellers=new ArrayList<Seller>();
		this.buyers=new ArrayList<Buyer>();
	}

	public static List<Seller> getSellers() {
		return sellers;
	}

	public static List<Buyer> getBuyers() {
		return buyers;
	}
}
