package buyproducer;

import org.osgi.framework.BundleActivator;
import buyproducer.BuyServicePublish;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {
	ServiceRegistration publishServiceRegistrion;

	public void start(BundleContext context) throws Exception {
		BuyServicePublish buyServicePublish = new BuyServicePublishImpl();
		publishServiceRegistrion = context.registerService(BuyServicePublish.class.getName(), buyServicePublish, null);
		System.out.println("Start Buy Service");
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop Subscriber Service, Good Bye!");
		publishServiceRegistrion.unregister();
		System.out.println("Stop Buy Service");
	}

}
