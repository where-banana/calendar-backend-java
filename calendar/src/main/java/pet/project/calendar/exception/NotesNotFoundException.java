package pet.project.calendar.exception;

public class NotesNotFoundException extends RuntimeException{
    public NotesNotFoundException(String message){
        super(message);
    }
}
