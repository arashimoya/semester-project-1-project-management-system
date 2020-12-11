package Model;

import java.io.Serializable;

/**
 * description somebody help me out
 *
 * @author shrek
 * @version ?
 */
public class ColourIT implements Serializable {


    private TeamMemberList teamMemberList;
    private ProjectList projectList;
    private CustomerList customerList;

    private int customerId;
    private int projectId;
    private int projectReportId;
    private int requirementId;
    private int taskReportId;
    private int teamMemberId;

    /**
     * Non-argument constructor initializing TeamMemberList, ProjectList, CustomerList and ID variables
     */
    public ColourIT() {
        teamMemberList = new TeamMemberList();
        projectList = new ProjectList();
        customerList = new CustomerList();
        customerId = 0;
        projectReportId = 0;
        requirementId = 0;
        taskReportId = 0;
        teamMemberId = 0;

    }

    /**
     * Getter for teamMemberList
     *
     * @return teamMemberList
     */
    public TeamMemberList getTeamMemberList() {
        return teamMemberList;
    }

    /**
     * Getter for projectList
     *
     * @return projectList
     */
    public ProjectList getProjectList() {
        return projectList;
    }

    /**
     * Getter for customerList
     *
     * @return customerList
     */
    public CustomerList getCustomerList() {
        return customerList;
    }

    public  void setCustomerId(int customerId) {
        ColourIT.customerId = customerId;
    }

    public  void setProjectId(int projectId) {
        ColourIT.projectId = projectId;
    }

    public  void setProjectReportId(int projectReportId) {
        ColourIT.projectReportId = projectReportId;
    }

    public  void setRequirementId(int requirementId) {
        ColourIT.requirementId = requirementId;
    }

    public  void setTaskReportId(int taskReportId) {
        ColourIT.taskReportId = taskReportId;
    }

    public  void setTeamMemberId(int teamMemberListId) {
        ColourIT.teamMemberId = teamMemberListId;
    }

    public  int getCustomerId() {
        return customerId;
    }

    public  int getProjectId() {
        return projectId;
    }

    public  int getProjectReportId() {
        return projectReportId;
    }

    public  int getRequirementId() {
        return requirementId;
    }

    public  int getTaskReportId() {
        return taskReportId;
    }

    public  int getTeamMemberId() {
        return teamMemberId;
    }

    @Override
    public String toString() {
        return "ColourIT{" +
                "teamMemberList=" + teamMemberList +
                ", projectList=" + projectList +
                ", customerList=" + customerList +
                '}';
    }
}