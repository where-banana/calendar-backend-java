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
public class Workspaces {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users userId;

    @JsonIgnore
    @OneToMany(mappedBy = "workspacesId", cascade = CascadeType.ALL)
    private Collection<Events> workspaces;

    public Workspaces() {
    }

    public Workspaces(String name, Users userId) {
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
