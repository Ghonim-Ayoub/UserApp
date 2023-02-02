package ma.projects.ws.entities;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@Entity(name="addresses")
public class AddressEntity implements Serializable {

    private static final long serialVersionUID = 8106560824187969451L;

    @Id
    @GeneratedValue
    private long id;

    @Column(length=30, nullable=false)
    private String addressId;

    @Column(length=20, nullable=false)
    private String city;

    @Column(length=20, nullable=false)
    private String country;

    @Column(length=50, nullable=false)
    private String street;

    @Column(length=7, nullable=false)
    private String postal;

    @Column(length=20, nullable=false)
    private String type;

    @ManyToOne
    @JoinColumn(name="users_id")
    private UserEntity user;

}