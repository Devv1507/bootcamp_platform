package powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "capability")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CapabilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true, nullable = false, length = 50)
    private String name;
    @Column (nullable = false, length = 90)
    private String description;

    // Relations
    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL) /*(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })*/
    @JoinTable(name = "capability_technology_mapping",
            joinColumns = @JoinColumn(name = "capability_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id", referencedColumnName = "id"))
    /*@JsonIgnore*/
    private Set<TechnologyEntity> technologies = new HashSet<>(); // consider the use of new HashSet<>();

    /*public void assignTechnology(TechnologyEntity technology) {
        technologies.add(technology);
    }*/
}
