package Model;

import java.io.Serializable;

public class ScrumMaster extends TeamMember implements Serializable {
    public ScrumMaster(int id, String name) {
        super(id, name);
    }

    public ScrumMaster(TeamMember teamMember) {
        super(teamMember.getId(), teamMember.getName());
    }

    public void documentChanges(ProjectList projectList, Project targetProject, String message) throws ObjectAlreadyExistsException {
        for (Project project : projectList.getProjects()) {
            if (targetProject.equals(project)) {
                project.getProjectReports().createProjectReport(this, message);
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
