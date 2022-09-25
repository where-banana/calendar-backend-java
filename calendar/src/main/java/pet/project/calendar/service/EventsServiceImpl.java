package pet.project.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.project.calendar.entity.Events;
import pet.project.calendar.exception.EventsNotFoundException;
import pet.project.calendar.repository.EventsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventsServiceImpl implements EventsService{

    @Autowired
    private EventsRepository eventsRepository;

    @Override
    public Events findEventsById(Integer id) {
        Optional<Events> ev = eventsRepository.findEventsById(id);
        if (ev.isPresent()){
            return ev.get();
        }else {
            throw new EventsNotFoundException("Event with id = " + id + " not found.");
        }
    }

    @Override
    public List<Events> findEventsByTitle(String title) {
        return (List<Events>) eventsRepository.findEventsByTitle(title);
    }

    @Override
    public List<Events> findEventsByWorkspacesId(Integer id) {
        return (List<Events>) eventsRepository.findEventsByWorkspacesId(id);
    }

    @Override
    public void deleteEventsById(Integer id) {
        eventsRepository.deleteEventsById(id);
    }

    @Override
    public void deleteEventsByTitle(String title) {
        eventsRepository.deleteEventsByTitle(title);
    }
}
