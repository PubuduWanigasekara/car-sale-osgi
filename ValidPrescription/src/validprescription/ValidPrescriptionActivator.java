package validprescription;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import prescriptionavailability.PrescriptionAvailability;


public class ValidPrescriptionActivator implements BundleActivator {

	ServiceReference serviceReference;

	@Override
	public void start(BundleContext context) throws Exception {

		System.out.println("Valid Prescription Service");
		serviceReference = context.getServiceReference(PrescriptionAvailability.class
				.getName());
		PrescriptionAvailability servicePublish = (PrescriptionAvailability) context
				.getService(serviceReference);
		System.out.println(servicePublish.messageService("Message from Client"));
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye !!!");
		context.ungetService(serviceReference);
	}

}
