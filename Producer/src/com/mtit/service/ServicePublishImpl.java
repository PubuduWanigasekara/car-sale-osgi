package com.mtit.service;

import java.util.HashMap;
import java.util.Scanner;
import com.mtit.service.CartDetail;

public class ServicePublishImpl implements ServicePublish {

	@Override
	public CartDetail displayMenu() {

		String con = "Y";
		int amount = 0;

			System.out.println("Publisher start");
			System.out.println("------------Welcome to Punci Car Niwasa------------");
			System.out.println("------------Car List-------------------------------");
			System.out.println("Honda Vezel RS sensing LED 2016             =  1");
			System.out.println("Toyota Land Cruiser Sahara Cygnus 2002      =  2");
			System.out.println("Suzuki Wagon R Stingray 2017                =  3");
			System.out.println("Peugeot 3008 2018                           =  4");
			System.out.println("Mercedes Benz S300 (LWB) W221 2010          =  5");
			System.out.println("Mercedes Benz C200 AMG Premium Plus 2019    =  6");
			System.out.println("------------End Of Car List------------------------");

			String conBuy = "N";
			while (conBuy.equalsIgnoreCase("N")) {

				System.out.print("Enter Car Number :");
				Scanner optionKey = new Scanner(System.in);
				int selector = optionKey.nextInt();

				HashMap priceMap = new HashMap();
				priceMap.put(1, 7200000);
				priceMap.put(2, 11500000);
				priceMap.put(3, 3895000);
				priceMap.put(4, 11000000);
				priceMap.put(5, 13900000);
				priceMap.put(6, 17900000);

				switch (selector) {

				case 1:
					amount = amount + (Integer)priceMap.get(1);
					System.out.println("Car Price : "+ priceMap.get(1));
					break;

				case 2:
					amount = amount + (Integer)priceMap.get(2);
					System.out.println("Car Price : "+ priceMap.get(2));
					break;

				case 3:
					amount = amount + (Integer)priceMap.get(3);
					System.out.println("Car Price : "+ priceMap.get(3));
					break;

				case 4:
					amount = amount + (Integer)priceMap.get(4);
					System.out.println("Car Price : "+ priceMap.get(4));
					break;
				case 5:
					amount = amount + (Integer)priceMap.get(5);
					System.out.println("Car Price : "+ priceMap.get(5));
					break;

				case 6:
					amount = amount + (Integer)priceMap.get(6);
					System.out.println("Car Price : "+ priceMap.get(6));
					break;

				default:
					break;

				}
				
				System.out.print("Do you What to ADD To Cart? : ");
				Scanner contuBUY = new Scanner(System.in);
				conBuy = contuBUY.next();
			}
			
			return new CartDetail(conBuy, amount);
	}
}
