package powerup.bootcamp_platform.domain.model;

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
