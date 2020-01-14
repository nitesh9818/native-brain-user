package co.tvisory.api.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfo extends SqlBaseEntity{

    @OneToOne
    private User user;

    public PersonalInfo(Long version) {
        super(version);
    }
}
