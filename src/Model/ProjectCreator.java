package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class representing the project creator
 * @author CJ
 * @version ?
 */
public class ProjectCreator extends TeamMember implements Serializable {

    /**
     * Constructor of projectCreator letting to input id and name parameters
     * @param id id of project creator
     * @param name name of project creator
     */
    public ProjectCreator (int id, String name) {
        super(id, name);
    }

    /**
     * Constructor of projectCreator letting to input a teamMember parameter
     * @param teamMember a TeamMember object with id and name parameters
     */
    public ProjectCreator(TeamMember teamMember) {
        super(teamMember.getId(), teamMember.getName());
    }


    /**
     * A method that lets the project creator create a project
     * @param name id of the project
     * @param scrumMaster scrum master responsible for the project
     * @param productOwner person testing the project
     * @param projectCreator creator of the project
     * @param deadline deadline of the project
     * @param customer customer the project is for
     * @param description description of the project
     * @param colourIT parameter initializing list of team members, list of requirements and list of project reports
     */
    public void creatorCreateProject (String name, ScrumMaster scrumMaster, ProductOwner productOwner, ProjectCreator projectCreator, MyDate deadline, Customer customer, String description, ColourIT colourIT) {

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


