package Model;

import java.io.Serializable;

public class ProductOwner extends TeamMember implements Serializable {
    public ProductOwner (int id, String name) {
        super(id, name);
    }

    public ProductOwner(TeamMember teamMember) {
        super(teamMember.getId(), teamMember.getName());
    }

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
