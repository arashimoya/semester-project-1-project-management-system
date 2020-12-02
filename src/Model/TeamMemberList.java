package Model;
/**
 *
 * @author alex
 * @version 1.0
 */

import java.util.ArrayList;

public class TeamMemberList {
  private ArrayList<TeamMember> teamMembers;


  public TeamMemberList(){
    teamMembers=new ArrayList<TeamMember>();
  }
  public TeamMember getTeamMembers(int id) throws TeamMemberNotFoundException{
    for (TeamMember teamMember:teamMembers){
      if(teamMember.getId()==id)
        return teamMember;
    }
    throw new TeamMemberNotFoundException();
  }
  public ArrayList<TeamMember> getTeamMembers(){
    return teamMembers;
  }
  public void addTeamMember(TeamMember teamMember){
    teamMembers.add(teamMember);
  }
  public void deleteTeamMember(int id) throws TeamMemberNotFoundException{
    boolean tm = false;
    for(TeamMember teamMember:teamMembers);
    if(TeamMember.getId()==id)
      teamMembers.remove(teamMembers);
    tm=true;
    if(tm=false){
      throw new TeamMemberNotFoundException();
    }
  }
  public void CreateTeamMember(int id,String name){
    TeamMember teamMember=new TeamMember(id, name);
    addTeamMember(teamMember);
  }
  public void editTeamMember(int id,String name)
      throws TeamMemberNotFoundException
  {
    boolean tm=false;
    for(TeamMember teamMember:teamMembers){
      if(teamMember.getId()==id){
        teamMember.setName(name);
        tm=true;
      }
     if(tm=false){
       throw new TeamMemberNotFoundException();
     }
    }
  }
}
