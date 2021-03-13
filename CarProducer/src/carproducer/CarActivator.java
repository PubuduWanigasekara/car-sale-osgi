package carproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class CarActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistrion;

	public void start(BundleContext context) throws Exception {		
		CarServicePublish publisherService = new CarServicePublishImpl();
		publishServiceRegistrion = context.registerService(CarServicePublish.class.getName(), publisherService, null);
		System.out.println("Start Car Service");
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Publisher Stop");
		publishServiceRegistrion.unregister();
		System.out.println("Stop Car Service");
	}

}
