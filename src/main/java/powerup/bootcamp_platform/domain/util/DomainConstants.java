package powerup.bootcamp_platform.domain.util;

public final class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public enum Field {
        NAME,
        PROFILE,
        USER,
        URL,
        DESCRIPTION,
        ADDRESS
    }

    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' cannot be null";
    public static final String FIELD_PROFILE_NULL_MESSAGE = "Field 'profile' cannot be null";
    public static final String FIELD_USER_NULL_MESSAGE = "Field 'user' cannot be null";
    public static final String FIELD_URL_NULL_MESSAGE = "Field 'urlMeet' cannot be null";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' cannot be null";
    public static final String FIELD_ADDRESS_NULL_MESSAGE = "Field 'address' cannot be null";

}
