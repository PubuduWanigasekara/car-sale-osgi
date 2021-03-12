package prescriptionavailabilitypublisher;

public class PrescriptionAvailabilityPublishImpl implements PrescriptionAvailabilityPublish {

	@Override
	public String messageService(String message) {
		return "Message by service provider execute " + message;		
	}
	
	public String getPrescriptiojn() {
		return "Paracetamo";
	}
}
