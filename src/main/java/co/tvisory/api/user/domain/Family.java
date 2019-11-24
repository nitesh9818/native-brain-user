package co.tvisory.api.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter @Getter
public class Family extends SqlBaseEntity {

    private String parentMobileNo;

    @OneToMany(mappedBy = "family")
    private List<User> users;

    public Family(Long version) {
        super(version);
    }
}
