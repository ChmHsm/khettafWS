package khettaf;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Me on 22/09/2017.
 */
@Entity
public class POI implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    private Double X;

    private Double Y;

    private String nom;

    public POI() {
        //JPA
    }

    public POI(Double x, Double y, String nom) {
        X = x;
        Y = y;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getX() {
        return X;
    }

    public void setX(Double x) {
        X = x;
    }

    public Double getY() {
        return Y;
    }

    public void setY(Double y) {
        Y = y;
    }

    public Long getId() {
        return id;
    }
}
