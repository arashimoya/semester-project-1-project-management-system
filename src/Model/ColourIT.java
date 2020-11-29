package Model;

public class ColourIT {

private TeamMemberList teamMemberList;
private ProjectList projectList;

  public ColourIT(TeamMemberList teamMemberList, ProjectList projectList)
  {
    this.teamMemberList = teamMemberList;
    this.projectList = projectList;
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
