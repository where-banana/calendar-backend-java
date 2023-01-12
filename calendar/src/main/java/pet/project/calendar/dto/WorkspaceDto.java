package pet.project.calendar.dto;

import lombok.*;
import pet.project.calendar.entity.Event;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkspaceDto {
    private String name;
    private Collection<Event> events;
}
