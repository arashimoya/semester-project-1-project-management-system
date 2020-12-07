package Model;

import java.util.ArrayList;

public class ProjectList {
    private ArrayList<Project> projects;
    private int idCounter;

    public ProjectList() {
        projects = new ArrayList<Project>();
        idCounter = 0;
    }

    public Project getProject(int id) throws ProjectNotFoundException {
        for (Project project : projects) {
            if (project.getId() == id)
                return project;
        }
        throw new ProjectNotFoundException();
    }

    public Project getProject(String name) throws ProjectNotFoundException {
        for (Project project : projects) {
            if (project.getName().equals(name))
                return project;
        }
        throw new ProjectNotFoundException();
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        if (!projects.contains(project)) {
            projects.add(project);
        }
        else {
            System.out.println("Project already exists");
        }
    }

    public void deleteProject(int id) throws ProjectNotFoundException {
        boolean isThere = false;
        for (Project project : projects) {
            if (project.getId() == id)
                projects.remove(project);
            isThere = true;
        }
        if (!isThere) {
            throw new ProjectNotFoundException();
        }
    }

    public void createProject(String name, TeamMember scrumMaster, TeamMember productOwner, TeamMember projectCreator, MyDate deadline, Customer customer) {
        projects.add(new Project(idCounter++, name, scrumMaster, productOwner, projectCreator, deadline, customer));
    }

    public void editProject(int id, String name, ScrumMaster scrumMaster, ProductOwner productOwner, ProjectCreator projectCreator, MyDate deadline, Customer customer) throws ProjectNotFoundException {
        boolean isThere = false;
        for (Project project : projects) {
            if (project.getId() == id) {
                project.setName(name);
                project.setScrumMaster(scrumMaster);
                project.setProductOwner(productOwner);
                project.setDeadline(deadline);
                project.setCustomer(customer);
                isThere = true;
            }
        }
        if (!isThere) {
            throw new ProjectNotFoundException();
        }
    }

}
