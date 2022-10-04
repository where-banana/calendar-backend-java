package pet.project.calendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pet.project.calendar.dto.EventDto;
import pet.project.calendar.entity.Event;
import pet.project.calendar.exception.EventNotFoundException;
import pet.project.calendar.service.EventService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entity-management")
public class EventController {

    private EventService eventsService;

    @Autowired
    public void setEventsService(EventService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Event> findEventsById(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity<>(eventsService.findEventById(id), HttpStatus.OK);
        }catch (EventNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Deprecated
    @GetMapping("/events/{title}")
    public ResponseEntity<List<Event>> findEventsByTitle(@PathVariable("title") String title){
        try{
            List<Event> eventsList = eventsService.findEventsByTitle(title);
            return new ResponseEntity<>(eventsList, HttpStatus.OK);
        }catch (EventNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Deprecated
    @GetMapping("/events{id}")
    public ResponseEntity<List<Event>> findEventsByWorkspacesId(@PathVariable("id") Integer id){
        try {
            List<Event> eventsList = eventsService.findEventsByWorkspacesId(id);
            return new ResponseEntity<>(eventsList, HttpStatus.OK);
        }catch (EventNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping(path = "/events",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> add(@RequestBody EventDto eventDto){
        Event event = eventsService.add(eventDto);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    @PutMapping("/events/{id}")
    public void updateEvent(@PathVariable Integer id, @RequestBody Map<String, String> json){
        eventsService.updateEvent(id, json.get("title"));
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Event> deleteEventsById(@PathVariable("id") Integer id){
        try{
            eventsService.deleteEventsById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (EventNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Deprecated
    @DeleteMapping("/deleteEventsByTitle/{title}")
    public ResponseEntity<Event> deleteEventsById(@PathVariable("title") String title){
        try{
            eventsService.deleteEventsByTitle(title);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (EventNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
