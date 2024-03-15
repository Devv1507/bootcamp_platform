package powerup.bootcamp_platform.domain.model;

public class Person {
    private Long id;
    private String idType;
    private String name;
    private String surname;
    private String mail;
    private String phone;
    private String address;
    private String password;

    public Person(Long id, String idType, String name, String surname, String mail, String phone, String address, String password) {
        this.id = id;
        this.name = name;
        this.idType = idType;
        this.surname = surname;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
