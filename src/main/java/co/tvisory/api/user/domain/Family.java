package co.tvisory.api.user.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class Family extends SqlBaseEntity {

    private String parentMobileNo;

    @OneToMany(mappedBy = "family")
    private List<User> users;

    public Family(Long version) {
        super(version);
    }
}
