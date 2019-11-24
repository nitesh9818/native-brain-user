package co.tvisory.api.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter @Getter
@Entity
public class User extends SqlBaseEntity{

    private String firstName;

    private String lastName;

    private String email;

    private String mobileNo;

    @Transient
    private String parentMobileNo;

    private String gender;

    private String dateOfBirth;

    @OneToOne(mappedBy = "user")
    private PersonalInfo personalInfo;

    @ManyToOne
    private Family family;

    @ManyToMany(cascade = {
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(Long version) {
        super(version);
    }
}
