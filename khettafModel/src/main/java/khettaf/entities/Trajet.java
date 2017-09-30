package khettaf.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

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

    private String description;

    private Date dateDepart;

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Trajet() {
        //JPA
    }

    public Trajet(Khettaf khettaf, POI depart, POI destination, String description, Date dateDepart) {
        this.khettaf = khettaf;
        this.depart = depart;
        this.destination = destination;
        this.description = description;
        this.dateDepart = dateDepart;
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
