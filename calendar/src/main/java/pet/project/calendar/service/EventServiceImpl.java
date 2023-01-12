package pet.project.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.project.calendar.dto.EventDto;
import pet.project.calendar.entity.Event;
import pet.project.calendar.entity.Workspace;
import pet.project.calendar.exception.EventNotFoundException;
import pet.project.calendar.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventsRepository;

    @Autowired
    private WorkspaceService workspaceService;

    @Override
    public Event findEventById(Integer id) {
        Optional<Event> ev = eventsRepository.findEventById(id);
        if (ev.isPresent()){
            return ev.get();
        }else {
            throw new EventNotFoundException("Event with id = " + id + " not found.");
        }
    }

    @Override
    public List<Event> findEventsByTitle(String title) {
        return (List<Event>) eventsRepository.findEventsByTitle(title);
    }

    @Override
    public List<Event> findEventsByWorkspacesId(Integer id) {
        return (List<Event>) eventsRepository.findEventsByWorkspacesId(id);
    }

    @Override
    public Event add(EventDto eventDto) {
        String title = eventDto.getTitle();
        Integer workId = eventDto.getWorkspaceId();

        Workspace workspace = workspaceService.findWorkspaceById(workId);
        Event event = new Event(title, workspace);
        eventsRepository.save(event);
        return event;
    }

    @Override
    public void updateEvent(Integer id, String title, Integer workspaceId) {
        eventsRepository.updateEvent(id, title, workspaceId);
    }

    @Override
    public void deleteEventsById(Integer id) {
        eventsRepository.deleteEventsById(id);
    }

    @Override
    public void deleteEventsByTitle(String title) {
        eventsRepository.deleteEventsByTitle(title);
    }

    @Override
    public List<Event> findAll() {
        return (List<Event>) eventsRepository.findAll();
    }
}
