package co.tvisory.api.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Security extends SqlBaseEntity{

    @OneToOne(mappedBy = "security", cascade = {CascadeType.ALL})
    private User user;

    private String name;

    private String email;

    private String mobileNo;

    private String password;
    
    private Date lastLogin;

    @ManyToMany(cascade = {
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "security_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Security(Long version) {
        super(version);
    }
}
