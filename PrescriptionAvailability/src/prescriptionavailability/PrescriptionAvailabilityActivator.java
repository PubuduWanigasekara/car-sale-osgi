package prescriptionavailability;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class PrescriptionAvailabilityActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {

		System.out.println("Prescription Availability Start");
		PrescriptionAvailability publisherService = new PrescriptionAvailabilityImpl();
		publishServiceRegistration = context.registerService(
				PrescriptionAvailability.class.getName(), publisherService, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Prescription Availability Stop");
		publishServiceRegistration.unregister();
	}

}
