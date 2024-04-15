package supperbidder;

import java.util.Scanner;

import config.InMemory;
import service.BuyerService;
import service.SellerService;
import service.serviceImpl.BuyerServiceImpl;
import service.serviceImpl.SellerServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		InMemory inMemory=new InMemory();
		BuyerService buyerService=new BuyerServiceImpl();
		SellerService sellerService=new SellerServiceImpl();
		while(true) {
			try {
				String[] input=sc.nextLine().trim().split(" ");
				switch(input[0]){
					case "ADD_SELLER":{
						sellerService.addSeller(input[1]);
						break;
					}
					case "ADD_BUYER":{
						buyerService.addBuyer(input[1]);
						break;
					}
					case "CREATE_AUCTION":{
						sellerService.createAuction(input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]), input[4]);
						break;
					}
					case "CREATE_BID":{
						buyerService.createBid(input[1], input[2], Integer.parseInt(input[3]));
						break;
					}
					case "UPDATE_BID":{
						buyerService.updateBid(input[1], input[2], Integer.parseInt(input[3]));
						break;
					}
					case "WITHDRAW_BID":{
						buyerService.withdrawBid(input[1], input[2]);
						break;
					}
					case "CLOSE_AUCTION":{
						sellerService.closeAuction(input[1]);
						break;
					}
					default:
						System.out.println("Invalid Command");
				}
			}catch(Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

}
