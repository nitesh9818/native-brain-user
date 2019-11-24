package co.tvisory.api.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Setter @Getter
public class PersonalInfo extends SqlBaseEntity{

    @OneToOne
    private User user;

    public PersonalInfo(Long version) {
        super(version);
    }
}
