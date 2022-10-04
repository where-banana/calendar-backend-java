package pet.project.calendar.service;

import pet.project.calendar.dto.EventDto;
import pet.project.calendar.entity.Event;

import java.util.List;

public interface EventService {
    Event findEventById(Integer id);

    List<Event> findEventsByTitle(String title);

    List<Event> findEventsByWorkspacesId(Integer id);

    Event add(EventDto eventDto);

    void updateEvent(Integer id, String title);

    void deleteEventsById(Integer id);

    void deleteEventsByTitle(String title);


}
