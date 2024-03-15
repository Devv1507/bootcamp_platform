package powerup.bootcamp_platform.domain.model;

public class User {
    private Long id;
    private Person person;
    private Role role;
    private Bootcamp bootcamp;

    public User(Long id, Person person, Role role, Bootcamp bootcamp) {
        this.id = id;
        this.person = person;
        this.role = role;
        this.bootcamp = bootcamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }
}
