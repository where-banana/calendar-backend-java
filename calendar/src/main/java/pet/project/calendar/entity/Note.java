package pet.project.calendar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Column(name = "checked")
    private boolean checked;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id")
    private Event eventId;

    public Note() {
    }

    public Note(String description, Event eventId) {
        this.description = description;
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", checked=" + checked +
                ", eventId=" + eventId +
                '}';
    }
}
