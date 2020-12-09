package Model;
/**
 * @author alex
 * @version 1.0
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class TeamMemberList implements Serializable {
    private ArrayList<TeamMember> teamMembers;
    private static int idCounter;

    public TeamMemberList() {
        teamMembers = new ArrayList<TeamMember>();
        idCounter = 0;
    }

    public TeamMember getTeamMember(int id) throws CustomNotFoundException {
        for (TeamMember teamMember : teamMembers) {
            if (teamMember.getId() == id)
                return teamMember;
        }
        throw new CustomNotFoundException();
    }

    public TeamMember getTeamMember(String name) throws CustomNotFoundException {
        for (TeamMember teamMember : teamMembers) {
            if (teamMember.getName().equals(name))
                return teamMember;
        }
        throw new CustomNotFoundException();
    }

    public ArrayList<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void addTeamMember(TeamMember teamMember) throws ObjectAlreadyExistsException {
        if (!teamMembers.contains(teamMember)) {
            teamMembers.add(teamMember);
        }
        else {
            throw new ObjectAlreadyExistsException();
        }
    }

    public void deleteTeamMember(TeamMember teamMember) throws CustomNotFoundException {
        if (teamMembers.contains(teamMember))
            teamMembers.remove(teamMember);
        else
            throw new CustomNotFoundException();
    }

    public TeamMember createTeamMember(String name) throws ObjectAlreadyExistsException{
        TeamMember teamMember = new TeamMember(idCounter++, name);
        if (!teamMembers.contains(teamMember)){
            teamMembers.add(teamMember);
            return teamMember;
        }
        throw new ObjectAlreadyExistsException();
    }

    public void editTeamMember(TeamMember teamMember, String name) throws CustomNotFoundException {
        if (teamMembers.contains(teamMember)) {
            teamMember.setName(name);
        }
        else{
            throw new CustomNotFoundException();
        }
    }

}

