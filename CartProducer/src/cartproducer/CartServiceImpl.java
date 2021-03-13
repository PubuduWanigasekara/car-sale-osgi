package cartproducer;
import java.util.Scanner;

import carproducer.CartDetail;

public class CartServiceImpl implements CartServicePublisher {

	@Override
	public String cartMenue(int tot) {
		
		System.out.println("Your total cost is : Rs." +tot);
		
		System.out.print("Do you want to buy? (Y/N): ");
		Scanner buyRes = new Scanner(System.in);
		String buyResponse = buyRes.next();
		return buyResponse;
		
	}

}
