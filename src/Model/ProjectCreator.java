package Model;

import java.util.ArrayList;

public class ProjectCreator extends TeamMember{


    public ProjectCreator (int id, String name) {
        super(id, name);
    }

    public void createProject (ColourIT colourIT, int id, String name, RequirementList requirementList, ScrumMaster scrumMaster, ProductOwner productOwner, ProjectCreator projectCreator, MyDate deadline, Customer customer) {
        colourIT.getProjectList().createProject(id, name, requirementList, scrumMaster, productOwner, projectCreator, deadline, customer);
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
}
