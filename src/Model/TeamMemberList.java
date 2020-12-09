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
    private int idCounter;


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

    public void addTeamMember(TeamMember teamMember) {
        if (!teamMembers.contains(teamMember)) {
            teamMembers.add(teamMember);
        } else {
            System.out.println("Team member already exists");
        }
    }

    public void deleteTeamMember(int id) throws CustomNotFoundException {
        boolean removed = false;
        for (TeamMember teamMember : teamMembers) {
            if (teamMember.getId() == id) {
                teamMembers.remove(teamMember);
                removed = true;
            }
        }
        if (!removed) {
            throw new CustomNotFoundException();
        }
    }

    public void createTeamMember(String name) {
        TeamMember teamMember = new TeamMember(idCounter++, name);
        addTeamMember(teamMember);
    }

    public void editTeamMember(int id, String name) throws CustomNotFoundException {
        boolean found = false;
        for (TeamMember teamMember : teamMembers) {
            if (teamMember.getId() == id) {
                teamMember.setName(name);
                found = true;
            }

        }
        if (!found) {
            throw new CustomNotFoundException();
        }
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamMemberList that = (TeamMemberList) o;
        return Objects.equals(teamMembers, that.teamMembers);
    }

}

