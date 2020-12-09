package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Stores requirements in a list
 *
 * @author tymon
 * @version 1.0
 */
public class RequirementList implements Serializable {
    private ArrayList<Requirement> requirements;
    private static int idCounter;

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
    public Requirement getRequirement(int ID) throws CustomNotFoundException {
        for (Requirement requirement :
                requirements) {
            if (requirement.getID() == ID)
                return requirement;

        }
        throw new CustomNotFoundException();
    }

    public Requirement getRequirement(String name) throws CustomNotFoundException {
        for (Requirement requirement :
                requirements) {
            if (requirement.getName().equals(name))
                return requirement;

        }
        throw new CustomNotFoundException();
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
    public void addRequirement(Requirement requirement) throws ObjectAlreadyExistsException {
        if (!requirements.contains(requirement)) {
            requirements.add(requirement);
        }
        else {
            throw new ObjectAlreadyExistsException();
        }

    }

    /**
     * delete requirement with given ID from the list if there was one
     *
     */
    public void deleteRequirement(Requirement requirement) throws CustomNotFoundException{
        if(requirements.contains(requirement)){
            requirements.remove(requirement);
        } else {
            throw new CustomNotFoundException();
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
    public Requirement createRequirement(int projectID, String userStoryText, String status, String name, MyDate deadline, boolean functional, int priority, int estimatedTime) throws ObjectAlreadyExistsException {

        Requirement requirement = new Requirement(idCounter++, projectID, userStoryText, status, name, deadline, functional, priority, estimatedTime);
        if (!requirements.contains(requirement)) {
            requirements.add(requirement);
            return requirement;
        }
        else throw new ObjectAlreadyExistsException();
    }


    /**
     * creates a new requirement to the list of requirements
     * if this requirement is unique adds it to the list of requirements
     *
     * @param userStoryText user story text
     * @param name          name of the requirement
     * @param functional    if requirement is functional or not
     * @param deadline      deadline
     * @param estimatedTime estimated time
     * @param priority      priority of the requirement
     */
    public void editRequirement(Requirement requirement, String userStoryText, String status, String name, MyDate deadline, boolean functional, int priority, int estimatedTime) throws CustomNotFoundException {
        if (requirements.contains(requirement)) {
                requirement.setDeadline(deadline);
                requirement.setFunctional(functional);
                requirement.setName(name);
                requirement.setPriority(priority);
                requirement.setUserStoryText(userStoryText);
                requirement.setEstimatedTime(estimatedTime);
            } else {
            throw new CustomNotFoundException();
        }

    }


}


