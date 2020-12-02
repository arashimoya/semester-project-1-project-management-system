package Model;

import java.util.ArrayList;

public class Project {

private int id;
private String name;
private ScrumMaster scrumMaster;
private ProductOwner productOwner;
private ProjectCreator projectCreator;
private MyDate deadline;
private Customer customer;
private RequirementList requirements;
private TeamMemberList teamMembers;
private ProjectReportList projectReports;

public Project(int id, String name, ScrumMaster scrumMaster, ProductOwner productOwner, ProjectCreator projectCreator, MyDate deadline, Customer customer){
    this.id = id;
    this.name = name;
    this.scrumMaster = scrumMaster;
    this.productOwner = productOwner;
    this.projectCreator = projectCreator;
    this.deadline = deadline;
    this.customer = customer;
    this.requirements = new RequirementList();
    this.teamMembers = new TeamMemberList();
    this.projectReports = new ProjectReportList();
}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public MyDate getDeadline() {
        return deadline;
    }

    public Customer getCustomer() {
        return customer;
    }

    public RequirementList getRequirements() {
        return requirements;
    }

    public TeamMemberList getTeamMembers() {
        return teamMembers;
    }

    public ProjectReportList getProjectReports() {
        return projectReports;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScrumMaster(ScrumMaster scrumMaster) {
        this.scrumMaster = scrumMaster;
    }

    public void setProductOwner(ProductOwner productOwner) {
        this.productOwner = productOwner;
    }

    public void setDeadline(MyDate deadline) {
        this.deadline = deadline;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (getId() != project.getId()) return false;
        if (getName() != null ? !getName().equals(project.getName()) : project.getName() != null) return false;
        if (getRequirements() != null ? !getRequirements().equals(project.getRequirements()) : project.getRequirements() != null)
            return false;
        if (getScrumMaster() != null ? !getScrumMaster().equals(project.getScrumMaster()) : project.getScrumMaster() != null)
            return false;
        if (getProductOwner() != null ? !getProductOwner().equals(project.getProductOwner()) : project.getProductOwner() != null)
            return false;
        if (getProjectCreator() != null ? !getProjectCreator().equals(project.getProjectCreator()) : project.getProjectCreator() != null)
            return false;
        if (getDeadline() != null ? !getDeadline().equals(project.getDeadline()) : project.getDeadline() != null)
            return false;
        if (getCustomer() != null ? !getCustomer().equals(project.getCustomer()) : project.getCustomer() != null)
            return false;
        return getTeamMembers() != null ? getTeamMembers().equals(project.getTeamMembers()) : project.getTeamMembers() == null;
    }

    @Override public String toString()
    {
        return "Project{" + "id=" + id + ", name='" + name + '\''
            + ", scrumMaster=" + scrumMaster + ", productOwner=" + productOwner
            + ", projectCreator=" + projectCreator + ", deadline=" + deadline
            + ", customer=" + customer + ", requirements=" + requirements
            + ", teamMembers=" + teamMembers + ", projectReports="
            + projectReports + '}';
    }
}
