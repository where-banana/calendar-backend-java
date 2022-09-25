package pet.project.calendar.exception;

public class CredentialsNotFoundException extends RuntimeException{
    public CredentialsNotFoundException(String message){
        super(message);
    }
}
