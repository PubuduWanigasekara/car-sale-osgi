package cartproducer;
import java.util.Scanner;
import com.mtit.service.CartDetail;

public class CartServiceImpl implements CartServicePublisher {

	@Override
	public String cartMenue(int tot) {
		
		System.out.println("Your total cost is : " +tot);
		
		System.out.print("Do you want to buy? : ");
		Scanner buyRes = new Scanner(System.in);
		String buyResponse = buyRes.next();
		return buyResponse;
		
	}

}
