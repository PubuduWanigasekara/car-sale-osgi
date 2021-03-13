package paymentproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import paymentproducer.PaymentServicePublish;


public class PaymentActivator implements BundleActivator {
	ServiceRegistration publishServiceRegistrion;

	public void start(BundleContext context) throws Exception {
		PaymentServicePublish paymentServicePublish = new PaymentServicePublishImpl();
		publishServiceRegistrion = context.registerService(PaymentServicePublish.class.getName(), paymentServicePublish, null);
		System.out.println("Start Buy Service");
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop Subscriber Service, Good Bye!");
		publishServiceRegistrion.unregister();
		System.out.println("Stop Buy Service");
	}

}
