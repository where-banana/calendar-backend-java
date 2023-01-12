package pet.project.calendar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "workspace_id")
    private Workspace workspacesId;


    @OneToMany(mappedBy = "eventId", cascade = CascadeType.ALL)
    private Collection<Note> notes;

    public Event() {
    }

    public Event(String title, Workspace workspacesId) {
        this.title = title;
        this.workspacesId = workspacesId;
    }

    @Override
    public String toString() {
        return "Events{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", workspacesId=" + workspacesId +
                '}';
    }
}
