package Model;

public class ScrumMaster extends TeamMember {
    public ScrumMaster(int id, String name){
        super(id, name);
    }

    public void documentChanges(ProjectList projectList, Project targetProject, String message) {
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
