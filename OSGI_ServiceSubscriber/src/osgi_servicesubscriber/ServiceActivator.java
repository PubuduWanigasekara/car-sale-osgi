package osgi_servicesubscriber;

import cartproducer.CartServicePublisher;
import paymentproducer.PaymentServicePublish;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import carproducer.CartDetail;
import carproducer.CarServicePublish;

public class ServiceActivator implements BundleActivator {

	ServiceReference serviceReference, serviceReference2;
	ServiceReference serviceReferencePayment;

	public void start(BundleContext context) throws Exception {

		System.out.println("Start Subscriber Service");
		serviceReference = context.getServiceReference(CarServicePublish.class.getName());
		CarServicePublish carServicePublish = (CarServicePublish) context.getService(serviceReference);

		while(true) {
			CartDetail respons = carServicePublish.displayMenu();
	
			String result = respons.getRespons();

			if ("Y".equalsIgnoreCase(result)) {

				serviceReference2 = context.getServiceReference(CartServicePublisher.class.getName());
				CartServicePublisher cartServicePublisher = (CartServicePublisher) context.getService(serviceReference2);
				String cartRes = cartServicePublisher.cartMenue(respons.getAmount());
	
				if (cartRes.equals("Y") || cartRes.equals("y")) {
					
					serviceReferencePayment = context.getServiceReference(PaymentServicePublish.class.getName());
					PaymentServicePublish paymentServicePublish = (PaymentServicePublish) context
							.getService(serviceReferencePayment);
					boolean isvalid = paymentServicePublish.displayMenuBuy();
	
					System.out.println(isvalid);
					
					if (isvalid == true) {
						System.out.println("Payment Successfully.");
						System.out.println("Good Byee! Come Again..");
						System.out.println();
						System.out.println();
					}
				}
	
			}
			System.out.println("Do you want to quit ? (Y/N)");
			Scanner qtsc = new Scanner(System.in);
			String qt =  qtsc.next();
			if(qt.equalsIgnoreCase("Y")) {
				System.out.println("Have a nice day !");
				//break;
			}		
		}
	}

	public void stop(BundleContext context) throws Exception {

		System.out.println("Stop Subscriber Service, Good Byee!");
		context.ungetService(serviceReference);
	}

}
