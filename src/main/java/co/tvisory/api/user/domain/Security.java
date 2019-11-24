package co.tvisory.api.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Security extends SqlBaseEntity{

    @OneToOne
    private User user;

    private String username;

    private String password;

    public Security(Long version) {
        super(version);
    }
}
