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
    private int idCounter;

    /**
     * no argument constructor that initialize the requirements list
     */
    public RequirementList() {
        requirements = new ArrayList<Requirement>();
        idCounter = 0;
    }

    /**
     * gets requirement that has given ID
     *
     * @param ID id of a requirement
     * @return requirement object if exist else null
     */
    public Requirement getRequirement(int ID) throws RequirementNotFoundException {
        for (Requirement requirement :
                requirements) {
            if (requirement.getID() == ID)
                return requirement;

        }
        throw new RequirementNotFoundException();
    }

    public Requirement getRequirement(String name) throws RequirementNotFoundException {
        for (Requirement requirement :
                requirements) {
            if (requirement.getName().equals(name))
                return requirement;

        }
        throw new RequirementNotFoundException();
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
        if (!requirements.contains(requirement)) {
            requirements.add(requirement);
        }
        else {
            System.out.println("Requirement already exists");
        }

    }

    /**
     * delete requirement with given ID from the list if there was one
     *
     * @param ID id of a requirement that is going to be deleted
     */
    public void deleteRequirement(int ID) throws RequirementNotFoundException {
        boolean isThere = false;
        for (Requirement requirement :
                requirements) {
            if (requirement.getID() == ID)
                requirements.remove(requirement);
            isThere = true;
        }
        if (isThere = false) {
            throw new RequirementNotFoundException();
        }
    }

    /**
     * creates a new requirement to the list of requirements
     * if this requirement is unique adds it to the list of requirements
     *
     * @param projectID     ID of the related project
     * @param userStoryText user story text
     * @param name          name of the requirement
     * @param functional    if requirement is functional or not
     * @param deadline      deadline
     * @param estimatedTime estimated time
     * @param priority      requirement priority
     */
    public void createRequirement(int projectID, String userStoryText, String status, String name, MyDate deadline, boolean functional, int priority, int estimatedTime) {

        Requirement requirement = new Requirement(idCounter++, projectID, userStoryText, status, name, deadline, functional, priority, estimatedTime);
        addRequirement(requirement);
    }


    /**
     * creates a new requirement to the list of requirements
     * if this requirement is unique adds it to the list of requirements
     *
     * @param ID            id of a requirement that is going to be edited
     * @param userStoryText user story text
     * @param name          name of the requirement
     * @param functional    if requirement is functional or not
     * @param deadline      deadline
     * @param estimatedTime estimated time
     * @param priority      priority of the requirement
     */
    public void editRequirement(int ID, String userStoryText, String status, String name, MyDate deadline, boolean functional, int priority, int estimatedTime) throws RequirementNotFoundException {
        boolean isThere = false;
        for (Requirement requirement : requirements) {
            if (requirement.getID() == ID) {
                requirement.setDeadline(deadline);
                requirement.setFunctional(functional);
                requirement.setName(name);
                requirement.setPriority(priority);
                requirement.setUserStoryText(userStoryText);
                requirement.setEstimatedTime(estimatedTime);
                isThere = true;
            }
        }
        if (isThere = false) {
            throw new RequirementNotFoundException();
        }
    }


}


