package validprescription;

public class ValidPrescriptionImpl implements ValidPrescription{
	
	@Override
	public String messageService(String message) {
		return "Message by service provider execute " + message;		
	}

}
