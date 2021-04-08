package ma.ibi.parent.prez.projet;

import ma.ibi.parent.prez.agent.AgentController;
import ma.ibi.parent.prez.project.ProjectController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;

@WebMvcTest(controllers = ProjectController.class)
@ActiveProfiles("test")
public class ProjectControllerTest {
}
