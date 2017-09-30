package khettaf.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Me on 22/09/2017.
 */
@Entity
public class Trajet implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Khettaf khettaf;

    @ManyToOne
    private POI depart;

    @ManyToOne
    private POI destination;

    public Trajet() {
        //JPA
    }

    public Trajet(Khettaf khettaf, POI depart, POI destination) {
        this.khettaf = khettaf;
        this.depart = depart;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public Khettaf getKhettaf() {
        return khettaf;
    }

    public void setKhettaf(Khettaf khettaf) {
        this.khettaf = khettaf;
    }

    public POI getDepart() {
        return depart;
    }

    public void setDepart(POI depart) {
        this.depart = depart;
    }

    public POI getDestination() {
        return destination;
    }

    public void setDestination(POI destination) {
        this.destination = destination;
    }
}
