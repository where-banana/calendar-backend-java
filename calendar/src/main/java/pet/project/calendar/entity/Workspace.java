package pet.project.calendar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "workspaces")
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User userId;

    @JsonIgnore
    @OneToMany(mappedBy = "workspacesId", cascade = CascadeType.ALL)
    private Collection<Event> events;

    public Workspace() {
    }

    public Workspace(String name, User userId) {
        this.name = name;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Workspaces{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}
