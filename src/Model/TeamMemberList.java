package Model;
/**
 * @author alex
 * @version 1.0
 */

import java.io.Serializable;
import java.util.ArrayList;


public class TeamMemberList implements Serializable {
    private ArrayList<TeamMember> teamMembers;
    private int idCounter;

    /**
     * no argument constructor to initliaze the team member list and the id counter
     */
    public TeamMemberList() {
        teamMembers = new ArrayList<TeamMember>();
        idCounter = 0;
    }

    /**
     * to get team member by id
     * @param id id to search the team member by
     * @return the found team member
     * @throws CustomNotFoundException if the team member was not found
     */
    public TeamMember getTeamMember(int id) throws CustomNotFoundException {
        for (TeamMember teamMember : teamMembers) {
            if (teamMember.getId() == id)
                return teamMember;
        }
        throw new CustomNotFoundException();
    }

    /**
     * to get the team member by name
     * @param name the name to find the team member by
     * @return the found team member
     * @throws CustomNotFoundException if the team member was not found
     */
    public TeamMember getTeamMember(String name) throws CustomNotFoundException {
        for (TeamMember teamMember : teamMembers) {
            if (teamMember.getName().equals(name))
                return teamMember;
        }
        throw new CustomNotFoundException();
    }

    /**
     * to get the list of the team members
     * @return the list of the team members
     */
    public ArrayList<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    /**
     * to add a team member to the list
     * @param teamMember the team member to be added
     * @throws ObjectAlreadyExistsException if the team member already exists
     */
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
        TeamMember teamMember = new TeamMember(idCounter, name);
        if (!teamMembers.contains(teamMember)){
            teamMembers.add(teamMember);
            idCounter++;
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

    public int getIdCounter() {
        return ++idCounter;
    }
}

