package pet.project.calendar.exception;

public class WorkspaceNotFoundException extends RuntimeException{
    public WorkspaceNotFoundException(String message){
        super(message);
    }
}
