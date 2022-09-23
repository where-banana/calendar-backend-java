package pet.project.calendar.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "Events")
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "workspace_id")
    private Workspaces workspacesId;


    @JsonIgnore
    @OneToMany(mappedBy = "eventId", cascade = CascadeType.ALL)
    private Collection<Notes> eventId;

    public Events() {
    }

    public Events(String title, Workspaces workspacesId) {
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
