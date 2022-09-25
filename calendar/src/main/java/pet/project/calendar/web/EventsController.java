package pet.project.calendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pet.project.calendar.entity.Events;
import pet.project.calendar.exception.EventsNotFoundException;
import pet.project.calendar.service.EventsService;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {

    private EventsService eventsService;

    @Autowired
    public void setEventsService(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping("/findEventsById/{id}")
    public ResponseEntity<Events> findEventsById(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity<>(eventsService.findEventsById(id), HttpStatus.OK);
        }catch (EventsNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/findEventsByTitle/{title}")
    public ResponseEntity<List<Events>> findEventsByTitle(@PathVariable("title") String title){
        try{
            List<Events> eventsList = eventsService.findEventsByTitle(title);
            return new ResponseEntity<>(eventsList, HttpStatus.OK);
        }catch (EventsNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/findEventsByWorkspacesId/{id}")
    public ResponseEntity<List<Events>> findEventsByWorkspacesId(@PathVariable("id") Integer id){
        try {
            List<Events> eventsList = eventsService.findEventsByWorkspacesId(id);
            return new ResponseEntity<>(eventsList, HttpStatus.OK);
        }catch (EventsNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/deleteEventsById/{id}")
    public ResponseEntity<Events> deleteEventsById(@PathVariable("id") Integer id){
        try{
            eventsService.deleteEventsById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (EventsNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/deleteEventsByTitle/{title}")
    public ResponseEntity<Events> deleteEventsById(@PathVariable("title") String title){
        try{
            eventsService.deleteEventsByTitle(title);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (EventsNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
