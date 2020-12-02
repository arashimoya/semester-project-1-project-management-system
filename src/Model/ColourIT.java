package Model;

public class ColourIT {


private TeamMemberList teamMemberList;
private ProjectList projectList;

  public ColourIT()
  {
    this.teamMemberList = new TeamMemberList();
    this.projectList = new ProjectList();
  }

  public TeamMemberList getTeamMemberList()
  {
    return teamMemberList;
  }

  public ProjectList getProjectList()
  {
    return projectList;
  }
}