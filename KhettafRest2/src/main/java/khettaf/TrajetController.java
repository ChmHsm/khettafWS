package khettaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import khettaf.resourceEntities.validation.KhettafValidation;

import java.security.Principal;

/**
 * Created by Me on 23/09/2017.
 */

@RestController
@RequestMapping("/trajets")
public class TrajetController {
    private final TrajetRepo trajetRepo;
    private final KhettafRepo khettafRepo;

    @Autowired
    public TrajetController(TrajetRepo trajetRepo, KhettafRepo khettafRepo) {
        this.trajetRepo = trajetRepo;
        this.khettafRepo = khettafRepo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    ResponseEntity<?> getAllTrajets(Principal principal){
        new KhettafValidation(khettafRepo).validateKhettaf(principal);
        return ResponseEntity.ok()
                .body(trajetRepo.findAll());
    }
}
