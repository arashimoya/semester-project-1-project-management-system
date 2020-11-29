package Model;

import java.util.ArrayList;

/**
 * Stores requirements in a list
 *
 * @author tymon
 * @version 1.0
 */
public class RequirementList {
    private ArrayList<Requirement> requirements;

    /**
     * no argument constructor that initialize the requirements list
     */
    public RequirementList() {
        requirements = new ArrayList<Requirement>();
    }

    /**
     * gets requirement that has given ID
     *
     * @param ID id of a requirement
     * @return requirement object if exist else null
     */
    public Requirement getRequirement(int ID) {
        for (Requirement requirement :
                requirements) {
            if (requirement.getID() == ID)
                return requirement;

        }
        return null;
    }

    /**
     * gets requirements
     *
     * @return the list of requirements
     */
    public ArrayList<Requirement> getRequirements() {
        return requirements;
    }

    /**
     * adds a new requirement if there is no requirement like that
     *
     * @param requirement requirement to be added
     */
    public void addRequirement(Requirement requirement) {
        var check = 0;
        for (Requirement req :
                requirements) {
            if (req.equals(requirement))
                check = 1;

        }
        if (check != 0)
            requirements.add(requirement);

    }

    /**
     * delete requirement with given ID from the list if there was one
     *
     * @param ID id of a requirement that is going to be deleted
     */
    public void deleteRequirement(int ID) {
        for (Requirement requirement :
                requirements) {
            if (requirement.getID() == ID)
                requirements.remove(requirement);

        }
    }

    /**
     * creates a new requirement to the list of requirements
     * if this requirement is unique adds it to the list of requirements
     *
     * @param ID            requirement ID
     * @param projectID     ID of the related project
     * @param userStoryText user story text
     * @param name          name of the requirement
     * @param functional    if requirement is functional or not
     * @param deadline      deadline
     * @param estimatedTime estimated time
     * @param priority      requirement priority
     */
    public void createRequirement(int ID, int projectID, String userStoryText, String name,
                                  boolean functional, MyDate deadline, int estimatedTime, int priority) {

        Requirement requirement = new Requirement(ID, projectID, userStoryText, name,
                functional, deadline, estimatedTime, priority);
        addRequirement(requirement);
    }


    /**
     * creates a new requirement to the list of requirements
     * if this requirement is unique adds it to the list of requirements
     *
     * @param ID            id of a requirement that is going to be eddited
     * @param userStoryText user story text
     * @param name          name of the requirement
     * @param functional    if requirement is functional or not
     * @param deadline      deadline
     * @param estimatedTime estimated time
     * @param priority      priority of the requirement
     */
    public void editRequirement(int ID, String userStoryText, String name,
                                boolean functional, MyDate deadline, int estimatedTime, int priority) {

        for (Requirement requirement : requirements) {
            if (requirement.getID() == ID) {
                requirement.setDeadline(deadline);
                requirement.setFunctional(functional);
                requirement.setName(name);
                requirement.setPriority(priority);
                requirement.setUserStoryText(userStoryText);
                requirement.setEstimatedTime(estimatedTime);
            }
        }
    }


}


