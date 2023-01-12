package pet.project.calendar.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventDto {
    private String title;

    private Integer workspaceId;
}
