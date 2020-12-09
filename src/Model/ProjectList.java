package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class ProjectList implements Serializable {
    private ArrayList<Project> projects;
    private static int idCounter;

    public ProjectList() {
        projects = new ArrayList<Project>();
        idCounter = 0;
    }

    public Project getProject(int id) throws CustomNotFoundException {
        for (Project project : projects) {
            if (project.getId() == id)
                return project;
        }
        throw new CustomNotFoundException();
    }

    public Project getProject(String name) throws CustomNotFoundException {
        for (Project project : projects) {
            if (project.getName().equals(name))
                return project;
        }
        throw new CustomNotFoundException();
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) throws ObjectAlreadyExistsException {
        if (!projects.contains(project)) {
            projects.add(project);
        } else {
            throw new ObjectAlreadyExistsException();
        }
    }

    public void deleteProject(Project project) throws CustomNotFoundException {
        if (projects.contains(project)) {
            projects.remove(project);
        } else
            throw new CustomNotFoundException();
    }

    public Project createProject(String name, TeamMember scrumMaster, TeamMember productOwner, TeamMember projectCreator, MyDate deadline, Customer customer, String description) throws ObjectAlreadyExistsException {
        Project newProject = new Project(idCounter++, name, scrumMaster, productOwner, projectCreator, deadline, customer, description);
        if (!projects.contains(newProject)) {
            projects.add(newProject);
            return newProject;
        } else {
            throw new ObjectAlreadyExistsException();
        }
    }

    public void editProject(Project project, String name, TeamMember scrumMaster, TeamMember productOwner, TeamMember projectCreator, MyDate deadline, Customer customer, String description) throws CustomNotFoundException {
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
