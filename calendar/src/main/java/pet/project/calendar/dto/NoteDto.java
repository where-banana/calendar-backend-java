package pet.project.calendar.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoteDto {
    private String description;
    private Integer eventId;
}
