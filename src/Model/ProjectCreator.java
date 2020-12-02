package Model;

import java.util.ArrayList;

public class ProjectCreator extends TeamMember{


    public ProjectCreator (String name) {
        super(name);
    }

    public void creatorCreateProject (String name, ScrumMaster scrumMaster, ProductOwner productOwner, ProjectCreator projectCreator, MyDate deadline, Customer customer, ColourIT colourIT) {
        colourIT.getProjectList().createProject(name, scrumMaster, productOwner, projectCreator, deadline, customer);
    }

    public void assignRoles (ColourIT colourIT, Project targetProject, ScrumMaster scrumMaster, ProductOwner productOwner, ArrayList<TeamMember> teamMembers) {
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


