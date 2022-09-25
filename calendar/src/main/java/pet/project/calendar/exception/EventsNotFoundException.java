package pet.project.calendar.exception;

public class EventsNotFoundException extends RuntimeException{
    public EventsNotFoundException(String message){
        super(message);
    }
}
