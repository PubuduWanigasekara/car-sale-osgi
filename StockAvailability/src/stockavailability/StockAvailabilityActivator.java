package stockavailability;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import validprescription.ValidPrescription;

public class StockAvailabilityActivator implements BundleActivator {

	ServiceReference serviceReference;

	@Override
	public void start(BundleContext context) throws Exception {

		System.out.println("Start Stock Service");
		serviceReference = context.getServiceReference(ValidPrescription.class
				.getName());
		ValidPrescription servicePublish = (ValidPrescription) context
				.getService(serviceReference);
		System.out.println(servicePublish.messageService("Message from Client"));
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Stock Good Bye !!!");
		context.ungetService(serviceReference);
	}

}
