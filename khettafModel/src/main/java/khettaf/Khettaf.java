package khettaf;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Me on 22/09/2017.
 */
@Entity
public class Khettaf implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String utilisateur;

    @JsonIgnore
    private String password;

    public Khettaf(){
        //JPA
    }

    public Khettaf(String username, String password) {
        this.utilisateur = username;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {

        return utilisateur;
    }

    public void setUsername(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
