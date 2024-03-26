package powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    @Column (nullable = false)
    private String technologies; // must be a list
}
