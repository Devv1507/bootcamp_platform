package powerup.bootcamp_platform.domain.model;

import jakarta.validation.constraints.NotBlank;
import powerup.bootcamp_platform.domain.exceptions.EmptyFieldException;
import powerup.bootcamp_platform.domain.util.DomainConstants;
import static java.util.Objects.requireNonNull;

public class Technology {
    private Long id;
    /* this is ok? */
    /*@NotBlank(message = "Name is mandatory")*/
    private String name;
    private String description;
    private String address;

    public Technology(Long id, String name, String description, String address) {
        /*if (description.trim().isEmpty()){
            throw new EmptyFieldException(DomainConstants.Field.DESCRIPTION.toString());
        }*/
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

/*

        if (name.length() > 50) {
            throw new IllegalArgumentException("Technology name cannot exceed 50 characters.");
        }
        if (description.length() > 90) {
            throw new IllegalArgumentException("Technology description cannot exceed 90 characters.");
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Technology technology = (Technology) o;
        return Objects.equals(name, technology.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
 */