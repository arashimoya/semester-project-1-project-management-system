package Model;

public class ColourIT {


private TeamMemberList teamMemberList;
private ProjectList projectList;
private CustomerList customerList;

  public ColourIT()
  {
    this.teamMemberList = new TeamMemberList();
    this.projectList = new ProjectList();
    this.customerList = new CustomerList();
  }

  public TeamMemberList getTeamMemberList()
  {
    return teamMemberList;
  }

  public ProjectList getProjectList()
  {
    return projectList;
  }

  public CustomerList getCustomerList() {
    return customerList;
  }
}