package khettaf.exceptions;

/**
 * Created by Me on 23/09/2017.
 */
@SuppressWarnings("serial")
public class ConnectedUserNotFound extends RuntimeException{

    public ConnectedUserNotFound(String connectedUsername){
        super("L'utilisateur connecté demandé est introuvable ou invalide (" + connectedUsername + ")");
    }

}
