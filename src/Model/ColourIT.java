package Model;

import java.io.Serializable;

/**
 * description somebody help me out
 * @author shrek
 * @version ?
 */
public class ColourIT implements Serializable {


private TeamMemberList teamMemberList;
private ProjectList projectList;
private CustomerList customerList;

private static int customerId;
private static int projectId;
private static int projectReportId;
private static int requirementId;
private static int taskReportId;
private static int teamMemberId;

  /**
   * Non-argument constructor initializing TeamMemberList, ProjectList, CustomerList and ID variables
   */
  public ColourIT()
  {
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
   * @return teamMemberList
   */
  public TeamMemberList getTeamMemberList()
  {
    return teamMemberList;
  }

  /**
   * Getter for projectList
   * @return projectList
   */
  public ProjectList getProjectList()
  {
    return projectList;
  }

  /**
   * Getter for customerList
   * @return customerList
   */
  public CustomerList getCustomerList() {
    return customerList;
  }

  public static void setCustomerId(int customerId) {
    ColourIT.customerId = customerId;
  }

  public static void setProjectId(int projectId) {
    ColourIT.projectId = projectId;
  }

  public static void setProjectReportId(int projectReportId) {
    ColourIT.projectReportId = projectReportId;
  }

  public static void setRequirementId(int requirementId) {
    ColourIT.requirementId = requirementId;
  }

  public static void setTaskReportId(int taskReportId) {
    ColourIT.taskReportId = taskReportId;
  }

  public static void setTeamMemberId(int teamMemberListId) {
    ColourIT.teamMemberId = teamMemberListId;
  }

  public static int getCustomerId() {
    return customerId;
  }

  public static int getProjectId() {
    return projectId;
  }

  public static int getProjectReportId() {
    return projectReportId;
  }

  public static int getRequirementId() {
    return requirementId;
  }

  public static int getTaskReportId() {
    return taskReportId;
  }

  public static int getTeamMemberId() {
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