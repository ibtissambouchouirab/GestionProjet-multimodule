package ma.ibi.parent.domain.exceptionhandler;

public class ProjectNotFound extends RuntimeException {
    @Override
    public String getMessage() {
        return "Project not found";
    }
}
