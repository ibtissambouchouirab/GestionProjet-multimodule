package ma.ibi.parent.domain.exceptionhandler;

public class AgentNotFound extends RuntimeException {
    @Override
    public String getMessage() {
        return "Agent not found";
    }
}
