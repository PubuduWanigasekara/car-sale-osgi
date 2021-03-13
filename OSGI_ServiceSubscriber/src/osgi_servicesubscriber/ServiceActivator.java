package osgi_servicesubscriber;

import com.mtit.service.CartDetail;

import com.mtit.service.ServicePublish;

import buyproducer.BuyServicePublish;
import cartproducer.CartServicePublisher;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


public class ServiceActivator implements BundleActivator {
	
	ServiceReference serviceReference, serviceReference2;
	ServiceReference serviceReferenceBuy;
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Start Subscriber Service");
		serviceReference = context.getServiceReference(ServicePublish.class.getName());	
		ServicePublish servicePublish = (ServicePublish)context.getService(serviceReference);
		
		CartDetail respons =  servicePublish.displayMenu();
		
		String result = respons.getRespons();
		
			
				if("Y".equalsIgnoreCase(result)) {
					serviceReference2 = context.getServiceReference(CartServicePublisher.class.getName());			
					CartServicePublisher cartServicePublisher = (CartServicePublisher)context.getService(serviceReference2);
					String cartRes = cartServicePublisher.cartMenue(respons.getAmount());
					
					if (cartRes.equals("Y") || cartRes.equals("y")) {
						serviceReferenceBuy = context.getServiceReference(BuyServicePublish.class.getName());
						BuyServicePublish buyServicePublish = (BuyServicePublish)context.getService(serviceReferenceBuy);
						boolean isvalid = buyServicePublish.displayMenuBuy();
						
						System.out.println(isvalid);
						if (isvalid == true) {
							System.out.println("Payment Successfully.....");
							System.out.println("Good Byee! Come Again..");
						}
						
					}else {
					
						servicePublish.displayMenu();
					}
		
				}
				
				while(true) {
					Scanner scn = new Scanner(System.in);
					scn.nextInt();
					
				}
			}
		


	public void stop(BundleContext context) throws Exception {
	
		System.out.println("Stop Subscriber Service, Good Byee...!");
		context.ungetService(serviceReference);
	}

}
