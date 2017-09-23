package khettaf.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Me on 23/09/2017.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class KhettafNotFoundException extends RuntimeException {
    public KhettafNotFoundException(String username){
        super("le khettaf source de la requête (" + username + ") n'est pas valide :/");
    }
}
