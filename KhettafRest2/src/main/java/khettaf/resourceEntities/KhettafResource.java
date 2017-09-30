package khettaf.resourceEntities;

import khettaf.entities.Khettaf;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Me on 23/09/2017.
 */
public class KhettafResource extends ResourceSupport {
    private final Khettaf khettaf;

    public KhettafResource(Khettaf khettaf) {
        this.khettaf = khettaf;

    }
}
