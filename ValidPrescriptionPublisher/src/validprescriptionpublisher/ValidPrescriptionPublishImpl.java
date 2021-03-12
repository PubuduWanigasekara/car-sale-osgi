package validprescriptionpublisher;

public class ValidPrescriptionPublishImpl implements ValidPrescriptionPublish {

	@Override
	public String messageService(String message) {
		return "Message by service provider execute " + message;		
	}
}
