package Model;

import java.io.Serializable;

/**
 * A class representing product owner, which extends a TeamMember class
 * @author tokyo drift
 * @version ?
 */
public class ProductOwner extends TeamMember implements Serializable {
    public ProductOwner (int id, String name) {
        super(id, name);
    }

    /**
     * Constructor for product owner
     * @param teamMember teamMember variable with name and id instances
     */
    public ProductOwner(TeamMember teamMember) {
        super(teamMember.getId(), teamMember.getName());
    }

    /**
     * A method letting product owner to edit status of project
     * @param project edited status
     * @param requirement edited requirement
     * @param status edited status
     */
    public void editStatus(Project project, Requirement requirement,  String status) {
        for (Requirement targetRequirement : project.getRequirements().getRequirements()){
            if(targetRequirement.equals(requirement)) {
                targetRequirement.setStatus(status);
            }
        }
    }


    @Override public String toString()
    {
        return super.toString();
    }


    @Override public boolean equals(Object o)
    {
        return super.equals(o);
    }
}
