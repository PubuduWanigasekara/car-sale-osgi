package prescriptionavailabilitypublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class PrescriptionAvailabilityActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {

		System.out.println("Prescription Availability Publisher Start");
		PrescriptionAvailabilityPublish publisherService = new PrescriptionAvailabilityPublishImpl();
		publishServiceRegistration = context.registerService(
				PrescriptionAvailabilityPublish.class.getName(), publisherService, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Prescription Availability Publisher Stop");
		publishServiceRegistration.unregister();
	}

}
