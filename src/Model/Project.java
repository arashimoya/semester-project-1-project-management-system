package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A class representing a project
 *
 * @author Oliver
 * @version 1
 */
public class Project implements Serializable {

    private int id;
    private String name;
    private TeamMember scrumMaster;
    private TeamMember productOwner;
    private TeamMember projectCreator;
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
     *
     * @param id             id of the project
     * @param name           name of the project
     * @param scrumMaster    scrum master responsible for the project
     * @param productOwner   product owner testing the project
     * @param projectCreator creator of the project
     * @param deadline       deadline of the project
     * @param customer       customer the project is for
     * @param description    description of the project
     */
    public Project(int id, String name, TeamMember scrumMaster, TeamMember productOwner, TeamMember projectCreator, MyDate deadline, Customer customer, String description) {
        this.name = name;
        this.scrumMaster = scrumMaster;
        this.productOwner = productOwner;
        this.projectCreator = projectCreator;
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
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets name of the project
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets scrum master of the project
     *
     * @return scrumMaster
     */
    public TeamMember getScrumMaster() {
        return scrumMaster;
    }

    /**
     * Gets product owner
     *
     * @return productOwner
     */
    public TeamMember getProductOwner() {
        return productOwner;
    }

    /**
     * Gets projectCreator
     *
     * @return projectCreator
     */
    public TeamMember getProjectCreator() {
        return projectCreator;
    }

    /**
     * Gets deadline of the project
     *
     * @return deadline
     */
    public MyDate getDeadline() {
        return deadline;
    }

    /**
     * Gets the customer the project is for
     *
     * @return customer
     */
    public Customer getCustomer() {
        return customer;
    }


    /**
     * Gets the description of the project
     *
     * @return
     */

    public String getDescription() {

        return description;
    }

    /**
     * Gets the list of requirements
     *
     * @return requirementList
     */
    public RequirementList getRequirementList() {
        return requirementList;
    }

    /**
     * Gets the list of team members
     *
     * @return teamMembers
     */
    public TeamMemberList getTeamMemberList() {
        return teamMembers;
    }

    /**
     * Gets the list of project reports
     *
     * @return projectReports
     */
    public ProjectReportList getProjectReportList() {
        return projectReports;
    }

    /**
     * Sets the name of the project
     *
     * @param name name of the project
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Sets the scrum master of the project
     *
     * @param scrumMaster scrum master of the project
     */
    public void setScrumMaster(TeamMember scrumMaster) {
        this.scrumMaster = scrumMaster;
    }

    /**
     * Sets the owner of the project
     *
     * @param productOwner owner of the project
     */
    public void setProductOwner(TeamMember productOwner) {
        this.productOwner = productOwner;
    }


    /**
     * Sets the deadline of the project
     *
     * @param deadline deadline of the project
     */
    public void setDeadline(MyDate deadline) {
        this.deadline = deadline;
    }

    /**
     * Sets the customer the project is for
     *
     * @param customer customer the project is for
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Sets the description of the project
     *
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
        return id == project.id &&
                Objects.equals(name, project.name) &&
                Objects.equals(scrumMaster, project.scrumMaster) &&
                Objects.equals(productOwner, project.productOwner) &&
                Objects.equals(projectCreator, project.projectCreator) &&
                Objects.equals(deadline, project.deadline) &&
                Objects.equals(customer, project.customer) &&
                Objects.equals(description, project.description) &&
                Objects.equals(requirementList, project.requirementList) &&
                Objects.equals(teamMembers, project.teamMembers) &&
                Objects.equals(projectReports, project.projectReports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, scrumMaster, productOwner, projectCreator, deadline, customer, description, requirementList, teamMembers, projectReports);
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
