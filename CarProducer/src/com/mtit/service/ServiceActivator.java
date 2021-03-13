package com.mtit.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistrion;

	public void start(BundleContext context) throws Exception {		
		ServicePublish publisherService = new ServicePublishImpl();
		publishServiceRegistrion = context.registerService(ServicePublish.class.getName(), publisherService, null);
		System.out.println("Start Produce Service");
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Publisher Stop");
		publishServiceRegistrion.unregister();
		System.out.println("Stop Produce Service");
	}

}
