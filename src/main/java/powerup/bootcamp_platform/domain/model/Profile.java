package powerup.bootcamp_platform.domain.model;

public class Profile {
    private Long id;
    private String name;
    private String description;
    private Technology technology;

    public Profile(Long id, String name, String description, Technology technology) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.technology = technology;
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

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }
}
