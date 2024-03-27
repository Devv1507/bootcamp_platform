package powerup.bootcamp_platform.domain.model;

import powerup.bootcamp_platform.domain.util.DomainConstants;
import powerup.bootcamp_platform.domain.exceptions.EmptyFieldException;
import static java.util.Objects.requireNonNull;

public class Bootcamp {
    private Long id;
    private String name;
    private Capability capability;
    private String urlMeet;

    public Bootcamp(Long id, String name, Capability capability, Long capacity, String url) {
        if (name.trim().isEmpty()){
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        this.id = id;
        this.name = requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.capability = requireNonNull(capability, DomainConstants.FIELD_PROFILE_NULL_MESSAGE);
        this.urlMeet = requireNonNull(url, DomainConstants.FIELD_URL_NULL_MESSAGE);
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

    public Capability getProfile() {
        return capability;
    }

    public void setProfile(Capability capability) {
        this.capability = capability;
    }

    public String getUrlMeet() {
        return urlMeet;
    }

    public void setUrl(String urlMeet) {
        this.urlMeet = urlMeet;
    }
}
