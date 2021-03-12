package prescriptionavailabilitysubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import prescriptionavailabilitypublisher.PrescriptionAvailabilityPublish;


public class PrescriptionAvailabilitySubscriberActivator implements BundleActivator {

	ServiceReference serviceReference;

	@Override
	public void start(BundleContext context) throws Exception {

		System.out.println("Start Subscriber Service");
		serviceReference = context.getServiceReference(PrescriptionAvailabilityPublish.class
				.getName());
		PrescriptionAvailabilityPublish servicePublish = (PrescriptionAvailabilityPublish) context
				.getService(serviceReference);
		//System.out.println(servicePublish.messageService("Message from Client"));
		
//		privte String x = servicePublish.gtPrescription();
//		prescriptionpblishvarifyByDoc(x)
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye !!!");
		context.ungetService(serviceReference);
	}

}
