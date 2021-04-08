package ma.ibi.parent.domain.exceptionhandler;

public class TacheNotFound extends RuntimeException {
    @Override
    public String getMessage() {
        return "Tache not found";
    }

}
