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
@Table(name = "technology")
@AllArgsConstructor
@NoArgsConstructor // nedded to get a default constructor
@Getter //@HashCode!!!
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class TechnologyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true, nullable = false, length = 50)
    private String name;
    @Column (nullable = false, length = 90)
    private String description;
    // Relations
    @ManyToMany (mappedBy = "technologies", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<CapabilityEntity> capabilities = new HashSet<>();
}
