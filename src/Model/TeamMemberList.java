package Model;
/**
 * @author alex
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Objects;

public class TeamMemberList {
    private ArrayList<TeamMember> teamMembers;
    private int idCounter;


    public TeamMemberList() {
        teamMembers = new ArrayList<TeamMember>();
        idCounter = 0;
    }

    public TeamMember getTeamMembers(int id) throws TeamMemberNotFoundException {
        for (TeamMember teamMember : teamMembers) {
            if (teamMember.getId() == id)
                return teamMember;
        }
        throw new TeamMemberNotFoundException();
    }

    public ArrayList<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void addTeamMember(TeamMember teamMember) {
        boolean exists = false;
        for (TeamMember teamMember1 : teamMembers) {
            if (teamMember1.equals(teamMember)) {
                exists = true;
                break;
            }
            if (!(exists))
                teamMembers.add(teamMember);
        }
    }

    public void deleteTeamMember(int id) throws TeamMemberNotFoundException {
        boolean removed = false;
        for (TeamMember teamMember : teamMembers) {
            if (teamMember.getId() == id) {
                teamMembers.remove(teamMember);
                removed = true;
            }
        }
        if (!removed) {
            throw new TeamMemberNotFoundException();
        }
    }

    public void CreateTeamMember(String name) {
        TeamMember teamMember = new TeamMember(idCounter++, name);
        addTeamMember(teamMember);
    }

    public void editTeamMember(int id, String name) throws TeamMemberNotFoundException {
        boolean found = false;
        for (TeamMember teamMember : teamMembers) {
            if (teamMember.getId() == id) {
                teamMember.setName(name);
                found = true;
            }

        }
        if (!found) {
            throw new TeamMemberNotFoundException();
        }
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamMemberList that = (TeamMemberList) o;
        return Objects.equals(teamMembers, that.teamMembers);
    }

}

