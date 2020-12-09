package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class ProjectCreator extends TeamMember implements Serializable {


    public ProjectCreator (int id, String name) {
        super(id, name);
    }

    public ProjectCreator(TeamMember teamMember) {
        super(teamMember.getId(), teamMember.getName());
    }

    public void creatorCreateProject (String name, ScrumMaster scrumMaster, ProductOwner productOwner, ProjectCreator projectCreator, MyDate deadline, Customer customer, String description, ColourIT colourIT) throws ObjectAlreadyExistsException {
        colourIT.getProjectList().createProject(name, scrumMaster, productOwner, projectCreator, deadline, customer, description);
    }

    public void assignRoles (ColourIT colourIT, Project targetProject, ScrumMaster scrumMaster, ProductOwner productOwner, ArrayList<TeamMember> teamMembers) throws ObjectAlreadyExistsException {
        for (Project project : colourIT.getProjectList().getProjects()){
            if (project.equals(targetProject)) {
                project.setProductOwner(productOwner);
                project.setScrumMaster(scrumMaster);
                for (TeamMember teamMember : teamMembers) {
                    project.getTeamMembers().addTeamMember(teamMember);
                }
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


