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

    @OneToOne
    private User user;

    private String username;

    private String password;
    
    private Date lastLogin;

    public Security(Long version) {
        super(version);
    }
}
