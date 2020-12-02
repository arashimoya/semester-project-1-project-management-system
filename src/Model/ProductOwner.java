package Model;

public class ProductOwner extends TeamMember{
    public ProductOwner (int id, String name) {
        super(id, name);
    }

    public void editStatus(Project project, Requirement requirement,  String status) {
        for (Requirement targetRequirement : project.getRequirements().getRequirements()){
            if(targetRequirement.equals(requirement)) {
                targetRequirement.setStatus(status);
            }
        }
    }
}
