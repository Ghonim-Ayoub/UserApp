package ma.projects.ws.entities;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
@Data
@Entity(name="contacts")
public class ContactEntity implements Serializable {

    private static final long serialVersionUID = 5726502969573108819L;

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Column(length = 30)
    private String contactId;

    @NotBlank
    private String mobile;
    private String skype;

    @OneToOne
    @JoinColumn(name="users_id")
    private UserEntity user;

}