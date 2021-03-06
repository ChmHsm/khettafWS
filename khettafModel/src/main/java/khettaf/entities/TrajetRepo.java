package khettaf.entities;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Me on 22/09/2017.
 */
public interface TrajetRepo extends JpaRepository<Trajet, Long> {
    Trajet findByDepartNomIgnoreCase(String depart);
}
