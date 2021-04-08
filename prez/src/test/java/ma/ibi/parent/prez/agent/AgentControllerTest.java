package ma.ibi.parent.prez.agent;


import ma.ibi.parent.domain.agent.AgentAggregate;
import ma.ibi.parent.domain.agent.AgentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static ma.ibi.parent.prez.common.Constants.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AgentController.class)
@ActiveProfiles("test")
public class AgentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AgentService agentService;

    /*
    @Test
    public void should_Get_All_Agent() throws  Exception{
        List<AgentAggregate> userList = new ArrayList<>();
        given(agentService.getAll()).willReturn(userList);
        this.mockMvc.perform( Get(AGENT_BASE_URL))
                .contentType("application/json")
                .andExpect(status().isOk()) ;
    }

    @Test
    public void should_Add_User() throws  Exception{
        AgentAggregate user = new AgentAggregate();
        agentService.addAgent(user);
        this.mockMvc.perform(post(AGENT_ADD_URL , user))
                .contentType("application/json")
                .andExpect(status().isOk());
    }

     */
}
