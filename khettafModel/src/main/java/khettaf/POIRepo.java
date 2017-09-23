package khettaf;

import khettaf.POI;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Me on 22/09/2017.
 */
public interface POIRepo extends JpaRepository<POI, Long>{
    POI findByNomIgnoreCase(String name);
}
