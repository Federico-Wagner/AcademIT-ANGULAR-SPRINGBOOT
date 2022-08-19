package com.barclays.webpage.barclaysweb.domain;
import com.barclays.webpage.barclaysweb.dto.Forms;
import com.barclays.webpage.barclaysweb.helper.UserHelper;
import com.barclays.webpage.barclaysweb.security.SecurityPasswordMng;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

@JsonSerialize
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "users") //en nombre de la tabla en la base de datos
public class User implements Serializable {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(name="firstname", nullable = false, length = 50)
    private String firstname;
    @Column(name="lastname", nullable = false, length = 50)
    private String lastname;
    @Column(name="email",unique = true, nullable = false, length = 100)
    private String email;
    @Column(name="password", nullable = false, length = 50)
    private String password;
    private String alias;
    private String cbu;
    private double cta_$, cta_u$$;

    @JsonIncludeProperties({"receptor","amount","type","date"})
    @OneToMany(mappedBy = "giver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions_sent;

    @JsonIncludeProperties({"giver","amount","type","date"})
    @OneToMany(mappedBy = "receptor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions_received;

    public User(Forms.RegisterForm registerForm) {
        this.firstname = registerForm.getFirstName();
        this.lastname = registerForm.getLastName();
        this.email = registerForm.getEmail();
        this.password = SecurityPasswordMng.passwordEncrypt(registerForm.getPassword());
        this.alias = UserHelper.generate_alias();
        this.cbu = UserHelper.generate_cbu();
        this.cta_$ = 0;
        this.cta_u$$ = 0;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", alias='" + alias + '\'' +
                ", cbu='" + cbu + '\'' +
                ", cta_$=" + cta_$ +
                ", cta_u$$=" + cta_u$$ +
                '}';
    }
}
