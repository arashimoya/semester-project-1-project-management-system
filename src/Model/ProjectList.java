package Model;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * class to hold a list of projects
 */
public class ProjectList implements Serializable {
    private ArrayList<Project> projects;
    private int idCounter;

    /**
     * no args constructor initializing the project list and a counter for IDs
     */
    public ProjectList() {
        projects = new ArrayList<Project>();
        idCounter = 0;
    }

    /**
     * search for a project by id
     *
     * @param id the id to search for the project by
     * @return returns the found project
     * @throws CustomNotFoundException if no project was found
     */
    public Project getProject(int id) throws CustomNotFoundException {
        for (Project project : projects) {
            if (project.getId() == id)
                return project;
        }
        throw new CustomNotFoundException();
    }

    /**
     * search for a project by name
     *
     * @param name the name to search for the project by
     * @return returns the found project
     * @throws CustomNotFoundException if no project was found
     */
    public Project getProject(String name) throws CustomNotFoundException {
        for (Project project : projects) {
            if (project.getName().equals(name))
                return project;
        }
        throw new CustomNotFoundException();
    }

    /**
     * get all projects inside of the list
     *
     * @return the list of projects
     */
    public ArrayList<Project> getProjects() {
        return projects;
    }


    /**
     * add project into the list
     *
     * @param project the project object to be added into the list
     * @throws ObjectAlreadyExistsException if the object is already in the list
     */
    public void addProject(Project project) throws ObjectAlreadyExistsException {

        if (!projects.contains(project)) {
            projects.add(project);
        } else {
            throw new ObjectAlreadyExistsException();
        }
    }

    /**
     * delete a project
     *
     * @param project the project object to be deleted
     * @throws CustomNotFoundException if the project was not found
     */
    public void deleteProject(Project project) throws CustomNotFoundException {
        if (projects.contains(project)) {
            projects.remove(project);
        } else
            throw new CustomNotFoundException();
    }

    /**
     * creating a new project inside the list
     *
     * @param name           name for the new project
     * @param scrumMaster    scrum master for the new project
     * @param productOwner   product owner for the new project
     * @param projectCreator project creator for the new project
     * @param deadline       deadline for the new project
     * @param customer       customer for the new project
     * @param description    description for the new project
     * @return the newly created project
     * @throws ObjectAlreadyExistsException if such project was already inside the list
     */
    public Project createProject(String name, TeamMember scrumMaster, TeamMember productOwner, TeamMember projectCreator, MyDate deadline, Customer customer, String description) throws ObjectAlreadyExistsException {
        Project newProject = new Project(idCounter, name, scrumMaster, productOwner, projectCreator, deadline, customer, description);
        if (!projects.contains(newProject)) {
            projects.add(newProject);
            idCounter++;
            return newProject;
        } else {
            throw new ObjectAlreadyExistsException();
        }
    }


    /**
     * editing a project
     *
     * @param project      the project to be edited
     * @param name         new name for the project
     * @param scrumMaster  new scrum master for the project
     * @param productOwner new product owner for the project
     * @param deadline     new deadline for the project
     * @param customer     new customer for the project
     * @throws CustomNotFoundException if the project was not found
     */
    public void editProject(Project project, String name, TeamMember scrumMaster, TeamMember productOwner, MyDate deadline, Customer customer, String description) throws CustomNotFoundException {

        if (projects.contains(project)) {
            project.setName(name);
            project.setScrumMaster(scrumMaster);
            project.setProductOwner(productOwner);
            project.setDeadline(deadline);
            project.setCustomer(customer);
        } else {
            throw new CustomNotFoundException();
        }
    }

}
