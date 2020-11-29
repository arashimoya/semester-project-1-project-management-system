package Model;

import java.util.ArrayList;

public class Project {

private int id;
private String name;
private RequirementList requirementList;
private ScrumMaster scrumMaster;
private ProductOwner productOwner;
private ProjectCreator projectCreator;
private MyDate deadline;
private Customer customer;
private TeamMemberList teamMembers;

public Project(int id, String name, RequirementList requirementList, ScrumMaster scrumMaster, ProductOwner productOwner, ProjectCreator projectCreator, MyDate deadline, Customer customer){
    this.id = id;
    this.name = name;
    this.requirementList = requirementList;
    this.scrumMaster = scrumMaster;
    this.productOwner = productOwner;
    this.projectCreator = projectCreator;
    this.deadline = deadline;
    this.customer = customer;
}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public MyDate getDeadline() {
        return deadline;
    }

    public ScrumMaster getScrumMaster() {
        return scrumMaster;
    }

    public ProductOwner getProductOwner() {
        return productOwner;
    }

    public ProjectCreator getProjectCreator() {
        return projectCreator;
    }

    public TeamMemberList getTeamMembers() {
        return teamMembers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDeadline(MyDate deadline) {
        this.deadline = deadline;
    }

    public void setScrumMaster(ScrumMaster scrumMaster) {
        this.scrumMaster = scrumMaster;
    }

    public void setProductOwner(ProductOwner productOwner) {
        this.productOwner = productOwner;
    }

    public void setProjectCreator(ProjectCreator projectCreator) {
        this.projectCreator = projectCreator;
    }

}
