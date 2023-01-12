package pet.project.calendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pet.project.calendar.dto.EventDto;
import pet.project.calendar.entity.Event;
import pet.project.calendar.entity.Note;
import pet.project.calendar.entity.Workspace;
import pet.project.calendar.exception.EventNotFoundException;
import pet.project.calendar.service.EventService;

import java.util.Collection;
import java.util.HashMap;
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
    public ResponseEntity<Map<String, Object>> findEventsById(@PathVariable("id") Integer id){
        try{
            Event event = eventsService.findEventById(id);
            String title = event.getTitle();
            Collection<Note> notes = event.getNotes();

            Map<String, Object> eventMap = new HashMap<>();
            eventMap.put("notes", notes);
            eventMap.put("title", title);

            return new ResponseEntity<>(eventMap, HttpStatus.OK);
        }catch (EventNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/events")
    public ResponseEntity<List<Event>> findAll(){
        try {
            return new ResponseEntity<>(eventsService.findAll(), HttpStatus.OK);
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
    public void updateEvent(@PathVariable Integer id, @RequestBody Map<String, Object> json){
        eventsService.updateEvent(id, (String) json.get("title"), (Integer) json.get("workspaceId"));
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
}
