package co.tvisory.api.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends SqlBaseEntity{

	private static final long serialVersionUID = 1L;

	private String firstName;

    private String lastName;

    private String email;

    private String mobileNo;

    private String gender;

    private String dateOfBirth;

    @OneToMany(mappedBy = "user")
    private List<Qualification> qualifications;
    
    @OneToOne
    private Security security;
    
    public User(Long version) {
        super(version);
    }
}
