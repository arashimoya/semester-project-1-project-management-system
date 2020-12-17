package Model;

import java.io.Serializable;

/**
 * Class responsible for storing all the data
 * @author Dan
 * @version 1
 */
public class ColourIT implements Serializable {


private TeamMemberList teamMemberList;
private ProjectList projectList;
private CustomerList customerList;

  /**
   * Non-argument constructor initializing TeamMemberList, ProjectList, CustomerList
   */
  public ColourIT()
  {
    teamMemberList = new TeamMemberList();
    projectList = new ProjectList();
    customerList = new CustomerList();
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


  @Override
  public String toString() {
    return "ColourIT{" +
            "teamMemberList=" + teamMemberList +
            ", projectList=" + projectList +
            ", customerList=" + customerList +
            '}';
  }
}