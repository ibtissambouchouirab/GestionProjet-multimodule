package ma.ibi.parent.domain.agent;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.security.SecurityProperties;



public class AgentServiceTest {

    @Mock
    private AgentProvider  agentProvider;

    @InjectMocks
    private AgentService agentService;

    @Test
    public void Should_add_Agent(){
        AgentAggregate agent = new AgentAggregate();
        agent.setNom("ibi");
        agent.setMatricule(123456);
         agentService.addAgent(agent);
        //agentProvider.saveAgent(agent);
        Mockito.verify(agentProvider,Mockito.times(1)).saveAgent(Mockito.any(AgentAggregate.class));
    }

}
