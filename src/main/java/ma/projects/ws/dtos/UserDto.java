package ma.projects.ws.dtos;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = -2624881664878912922L;

    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean admin;
    private String encryptedPassword;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus = false;
    private List<AddressDto> addresses;
    private ContactDto contact;


}
