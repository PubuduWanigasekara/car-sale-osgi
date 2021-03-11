package prescriptionavailability;

public class PrescriptionAvailabilityImpl implements PrescriptionAvailability{

	@Override
	public String messageService(String message) {
		return "Message by service provider execute " + message;		
	}
}
