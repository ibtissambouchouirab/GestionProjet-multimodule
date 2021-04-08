package ma.ibi.parent.prez.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public final static String BASE_URL = "v1/api";

    public final static String TASK_BASE_URL = BASE_URL + "/tasks";
    public final static String TASK_DELETE_URL = TASK_BASE_URL + "/{code}";


    public final static String PROJECT_BASE_URL = BASE_URL + "/projects";
    public final static String PROJECT_DELETE_URL = PROJECT_BASE_URL + "/{codeP}";


    public final static String AGENT_BASE_URL = BASE_URL + "/agents";
    public final static String AGENT_DELETE_URL = TASK_BASE_URL + "/{matricule}";


}
