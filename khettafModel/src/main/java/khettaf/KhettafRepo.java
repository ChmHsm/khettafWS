package khettaf;

import khettaf.Khettaf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Me on 22/09/2017.
 */
public interface KhettafRepo extends JpaRepository<Khettaf, Long> {
    Optional<Khettaf> findByUtilisateurIgnoreCase(String utilisateur);
}
