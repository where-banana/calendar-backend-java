package pet.project.calendar.exception;

public class CredentialNotFoundException extends RuntimeException{
    public CredentialNotFoundException(String message){
        super(message);
    }
}
