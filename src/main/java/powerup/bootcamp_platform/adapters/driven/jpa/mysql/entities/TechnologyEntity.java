package powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "technology")
@AllArgsConstructor
@NoArgsConstructor // neccessary to get a default constructor
@Getter //@HashCode!!!
@Setter
public class TechnologyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true, nullable = false, length = 50)
    private String name;
    @Column (nullable = false, length = 90)
    private String description;
    private String address;
}
