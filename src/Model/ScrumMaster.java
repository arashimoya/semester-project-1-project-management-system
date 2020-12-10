package Model;

import java.io.Serializable;

/**
 * A class representing Scrum Master
 */
public class ScrumMaster extends TeamMember implements Serializable {

    /**
     * A two-argument constructor
     * @param id id of the scrum master
     * @param name name of the scrum master
     */

    public ScrumMaster(int id, String name) {
        super(id, name);
    }

    /**
     * A one-argument constructor
     * @param teamMember a TeamMember object, containing name and ID of the scrum master
     */
    public ScrumMaster(TeamMember teamMember) {
        super(teamMember.getId(), teamMember.getName());
    }


    /**
     * A method letting scrum master to document changes in the project
     * @param projectList a list that contains projects
     * @param targetProject the project that is documented
     * @param message message of the documentation
     */

    public void documentChanges(ProjectList projectList, Project targetProject, String message) throws ObjectAlreadyExistsException {

        for (Project project : projectList.getProjects()) {
            if (targetProject.equals(project)) {
                project.getProjectReportList().createProjectReport(this, message);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
