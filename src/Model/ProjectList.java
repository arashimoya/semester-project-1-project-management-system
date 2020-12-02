package Model;

import java.util.ArrayList;

public class ProjectList {
    private ArrayList<Project> projects;

    public ProjectList(){
        projects = new ArrayList<Project>();
    }

    public Project getProject(int id) throws ProjectNotFoundException{
        for (Project project : projects) {
            if(project.getId() == id)
                return project;
        }
        throw new ProjectNotFoundException();
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        boolean isThere = false;
        for (Project thisProject : projects){
            if (thisProject.equals(project))
                isThere = true;
        }
        if(isThere = false)
            projects.add(project);
        else
            //needs to be changed later
            System.out.println("Project already exists");
    }

    public void deleteProject(int id) throws ProjectNotFoundException {
        boolean isThere = false;
        for (Project project : projects) {
            if(project.getId() == id)
                projects.remove(project);
            isThere = true;
        }
        if (isThere = false) {
            throw new ProjectNotFoundException();
        }
    }

    public void createProject (int id, String name, RequirementList requirementList, ScrumMaster scrumMaster, ProductOwner productOwner, ProjectCreator projectCreator, MyDate deadline, Customer customer) {
        projects.add(new Project(id, name, scrumMaster, productOwner, projectCreator, deadline, customer));
    }

    public void editProject (int id, String name, ScrumMaster scrumMaster, ProductOwner productOwner, ProjectCreator projectCreator, MyDate deadline, Customer customer) throws ProjectNotFoundException {
        boolean isThere = false;
        for (Project project : projects) {
            if(project.getId() == id){
                project.setName(name);
                project.setScrumMaster(scrumMaster);
                project.setProductOwner(productOwner);
                project.setDeadline(deadline);
                project.setCustomer(customer);
                isThere = true;
            }
        }
        if (isThere = false){
            throw new ProjectNotFoundException();
        }
    }

}
