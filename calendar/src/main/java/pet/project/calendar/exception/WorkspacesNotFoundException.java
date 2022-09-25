package pet.project.calendar.exception;

public class WorkspacesNotFoundException extends RuntimeException{
    public WorkspacesNotFoundException(String message){
        super(message);
    }
}
