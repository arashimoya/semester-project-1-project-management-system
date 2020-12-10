package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a project
 * @author John Paul II
 * @version ?
 */
public class Project implements Serializable {

    private int id;
    private String name;
    private ScrumMaster scrumMaster;
    private ProductOwner productOwner;
    private ProjectCreator projectCreator;
    private MyDate deadline;
    private Customer customer;
    private String description;
    private RequirementList requirementList;
    private TeamMemberList teamMembers;
    private ProjectReportList projectReports;

    /**
     * 8-argument constructor of the project letting user to enter parameters
     * listed below and initializing requirement list, list of team members and
     * list of project reports
     * @param id id of the project
     * @param name name of the project
     * @param scrumMaster scrum master responsible for the project
     * @param productOwner product owner testing the project
     * @param projectCreator creator of the project
     * @param deadline deadline of the project
     * @param customer customer the project is for
     * @param description description of the project
     */
    public Project(int id, String name, TeamMember scrumMaster, TeamMember productOwner, TeamMember projectCreator, MyDate deadline, Customer customer, String description) {
        this.name = name;
        this.scrumMaster = new ScrumMaster(scrumMaster);
        this.productOwner = new ProductOwner(productOwner);
        this.projectCreator = new ProjectCreator(projectCreator);
        this.deadline = deadline;
        this.customer = customer;
        this.description = description;
        this.requirementList = new RequirementList();
        this.teamMembers = new TeamMemberList();
        this.projectReports = new ProjectReportList();
        this.id = id;
    }

    /**
     * Gets id of the project
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets name of the project
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets scrum master of the project
     * @return scrumMaster
     */
    public ScrumMaster getScrumMaster() {
        return scrumMaster;
    }

    /**
     * Gets product owner
     * @return productOwner
     */
    public ProductOwner getProductOwner() {
        return productOwner;
    }

    /**
     * Gets projectCreator
     * @return projectCreator
     */
    public ProjectCreator getProjectCreator() {
        return projectCreator;
    }

    /**
     * Gets deadline of the project
     * @return deadline
     */
    public MyDate getDeadline() {
        return deadline;
    }

    /**
     * Gets the customer the project is for
     * @return customer
     */
    public Customer getCustomer() {
        return customer;
    }


    /**
     * Gets the description of the project
     * @return
     */

    public String getDescription() {

        return description;
    }

    /**
     * Gets the list of requirements
     * @return requirementList
     */
    public RequirementList getRequirementList() {
        return requirementList;
    }

    /**
     * Gets the list of team members
     * @return teamMembers
     */
    public TeamMemberList getTeamMemberList() {
        return teamMembers;
    }

    /**
     * Gets the list of project reports
     * @return projectReports
     */
    public ProjectReportList getProjectReportList() {
        return projectReports;
    }

    /**
     * Sets the name of the project
     * @param name name of the project
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Sets the scrum master of the project
     * @param scrumMaster scrum master of the project
     */
    public void setScrumMaster(ScrumMaster scrumMaster) {
        this.scrumMaster = scrumMaster;
    }

    /**
     * Sets the owner of the project
     * @param productOwner owner of the project
     */
    public void setProductOwner(ProductOwner productOwner) {
        this.productOwner = productOwner;
    }

    public void setScrumMaster(TeamMember scrumMaster) {
        this.scrumMaster = new ScrumMaster(scrumMaster);
    }

    public void setProductOwner(TeamMember productOwner) {
        this.productOwner = new ProductOwner(productOwner);

    }

    /**
     * Sets the deadline of the project
     * @param deadline deadline of the project
     */
    public void setDeadline(MyDate deadline) {
        this.deadline = deadline;
    }

    /**
     * Sets the customer the project is for
     * @param customer customer the project is for
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Sets the description of the project
     * @param description description of the project
     */
    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (getId() != project.getId()) return false;
        if (getName() != null ? !getName().equals(project.getName()) : project.getName() != null) return false;
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
        if (getDescription() != null ? !getDescription().equals(project.getDescription()) : project.getDescription() != null)
            return false;
        if (getRequirementList() != null ? !getRequirementList().equals(project.getRequirementList()) : project.getRequirementList() != null)
            return false;
        if (teamMembers != null ? !teamMembers.equals(project.teamMembers) : project.teamMembers != null) return false;
        return projectReports != null ? projectReports.equals(project.projectReports) : project.projectReports == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getScrumMaster() != null ? getScrumMaster().hashCode() : 0);
        result = 31 * result + (getProductOwner() != null ? getProductOwner().hashCode() : 0);
        result = 31 * result + (getProjectCreator() != null ? getProjectCreator().hashCode() : 0);
        result = 31 * result + (getDeadline() != null ? getDeadline().hashCode() : 0);
        result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getRequirementList() != null ? getRequirementList().hashCode() : 0);
        result = 31 * result + (teamMembers != null ? teamMembers.hashCode() : 0);
        result = 31 * result + (projectReports != null ? projectReports.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scrumMaster=" + scrumMaster +
                ", productOwner=" + productOwner +
                ", projectCreator=" + projectCreator +
                ", deadline=" + deadline +
                ", customer=" + customer +
                ", description='" + description + '\'' +
                ", requirementList=" + requirementList +
                ", teamMembers=" + teamMembers +
                ", projectReports=" + projectReports +
                '}';
    }
}
