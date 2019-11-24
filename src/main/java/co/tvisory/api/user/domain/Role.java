package co.tvisory.api.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class Role extends SqlBaseEntity {

    private String role;

    public Role(Long version) {
        super(version);
    }
}
