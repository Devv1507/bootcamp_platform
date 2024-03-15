package powerup.bootcamp_platform.domain.model;

import powerup.bootcamp_platform.domain.util.DomainConstants;
import powerup.bootcamp_platform.domain.exceptions.EmptyFieldException;
import static java.util.Objects.requireNonNull;

public class Bootcamp {
    private Long id;
    private String name;
    private Profile profile;
    private User user;
    private String urlMeet;

    public Bootcamp(Long id, String name, Profile profile, Long capacity, User user, String url) {
        if (name.trim().isEmpty()){
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        this.id = id;
        this.name = requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.profile = requireNonNull(profile, DomainConstants.FIELD_PROFILE_NULL_MESSAGE);
        this.user = requireNonNull(user, DomainConstants.FIELD_USER_NULL_MESSAGE);
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUrlMeet() {
        return urlMeet;
    }

    public void setUrl(String urlMeet) {
        this.urlMeet = urlMeet;
    }
}
