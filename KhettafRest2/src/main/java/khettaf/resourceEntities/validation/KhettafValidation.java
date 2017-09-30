package khettaf.resourceEntities.validation;

import khettaf.exceptions.KhettafNotFoundException;
import khettaf.entities.KhettafRepo;

import java.security.Principal;

/**
 * Created by Me on 23/09/2017.
 */
public class KhettafValidation {

    private final KhettafRepo khettafRepo;

    public KhettafValidation(KhettafRepo khettafRepo) {
        this.khettafRepo = khettafRepo;
    }

    public void validateKhettaf(Principal principal) {
        String name = principal.getName();
        this.khettafRepo
                .findByUtilisateurIgnoreCase(name)
                .orElseThrow(
                        () -> new KhettafNotFoundException(name));
    }
}
