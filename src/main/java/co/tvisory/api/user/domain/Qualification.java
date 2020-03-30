package co.tvisory.api.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class Qualification extends SqlBaseEntity{

    @ManyToOne
    private User user;

    private String qualificationName;

    private String schoolOrCollege;

    private String board;

    private Double percent;

    private Long passingYear;

    private String description;

    public Qualification(Long version) {
        super(version);
    }
}
