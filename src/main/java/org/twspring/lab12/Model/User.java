package org.twspring.lab12.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    //Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL UNIQUE")
    @NotEmpty(message = "Username cannot be empty")
    @Size(min=4,max = 30,
            message = "Username must have between 4 to 30 characters")
    private String username;

    @Column(columnDefinition = "VARCHAR(300) NOT NULL")
    @NotEmpty(message = "Password cannot be empty")
    //Test! changed somethings not sure it's still working
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[\\W_]).{8,}$",
            message = "Password must be strong (at least: at least 8 characters, one uppercase letter, one lowercase letter, one number, and one special character)")
    private String password;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    @Pattern(regexp = "^(USER|ADMIN)$")
    private String role;

//    //extra, for a little practice
//    @NotNull(message = "Birthdate cannot be null")
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Column(columnDefinition = "DATE NOT NULL DEFAULT TIMESTAMP(CURRENT_DATE)")
//    private LocalDate birthDate;
//
//    @Column(columnDefinition = "INT NOT NULL")
//    @NotNull(message = "age cannot be null")
//    @Positive(message = "age cannot be a negative number")
//    @Min(value = 13, message = "Users under the age of 13 cannot access the site")
//    private Integer Age;
//
//    //maybe ignore?
//    @Column(columnDefinition = "INT NOT NULL DEFAULT 0")
//    @NotNull(message = "number of blogs cannot be null")
//    @PositiveOrZero(message = "Number of blogs cannot be a negative number")
//    private Integer numberOfBlogs=0;
//

    //Relationships
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Blog> blogs;

    //My methods

//    //handles inside the service
//    public Integer calculateAge(LocalDate birthDate){
//       return Period.between(this.birthDate, LocalDate.now()).getYears();
//    }

    //UserDetails methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
