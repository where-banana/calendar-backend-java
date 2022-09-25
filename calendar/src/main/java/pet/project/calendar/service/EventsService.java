package pet.project.calendar.service;

import pet.project.calendar.entity.Events;

import java.util.List;

public interface EventsService {
    Events findEventsById(Integer id);

    List<Events> findEventsByTitle(String title);

    List<Events> findEventsByWorkspacesId(Integer id);

    void deleteEventsById(Integer id);

    void deleteEventsByTitle(String title);


}
