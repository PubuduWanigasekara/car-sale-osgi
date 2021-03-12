package validprescriptionpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ValidPrescriptionActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {

		System.out.println("Prescription Availability Publisher Start");
		ValidPrescriptionPublish publisherService = new ValidPrescriptionPublishImpl();
		publishServiceRegistration = context.registerService(
				ValidPrescriptionPublish.class.getName(), publisherService, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Prescription Availability Publisher Stop");
		publishServiceRegistration.unregister();
	}

}
