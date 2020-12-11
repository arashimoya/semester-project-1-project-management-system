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
    private int idCounter;

    /**
     * no argument constructor that initializes the requirements list
     */
    public RequirementList() {
        requirements = new ArrayList<Requirement>();
        idCounter = 0;
    }

    /**
     * to get requirement by id
     *
     * @param ID the id by which you are searching for the requirement
     * @return the found requirement
     * @throws CustomNotFoundException if the requirement was not found
     */
    public Requirement getRequirement(int ID) throws CustomNotFoundException {
        for (Requirement requirement :
                requirements) {
            if (requirement.getID() == ID)
                return requirement;

        }
        throw new CustomNotFoundException();
    }

    /**
     * to get the requirement by name
     *
     * @param name the name by which you are searching for the requirement
     * @return the found requirement
     * @throws CustomNotFoundException if the requirement was not found
     */
    public Requirement getRequirement(String name) throws CustomNotFoundException {
        for (Requirement requirement :
                requirements) {
            if (requirement.getName().equals(name))
                return requirement;

        }
        throw new CustomNotFoundException();
    }

    /**
     * to get all of the requirements
     *
     * @return the list of requirements
     */
    public ArrayList<Requirement> getRequirements() {
        return requirements;
    }

    /**
     * to add a requirement
     *
     * @param requirement the requirement to be added
     * @throws ObjectAlreadyExistsException if the requirement is already added
     */
    public void addRequirement(Requirement requirement) throws ObjectAlreadyExistsException {
        if (!requirements.contains(requirement)) {
            requirements.add(requirement);
        } else {
            throw new ObjectAlreadyExistsException();
        }

    }

    /**
     * to delete a requirement
     *
     * @param requirement the requirement to be deleted
     * @throws CustomNotFoundException if the requirement was not found
     */
    public void deleteRequirement(Requirement requirement) throws CustomNotFoundException {
        if (requirements.contains(requirement)) {
            requirements.remove(requirement);
        } else {
            throw new CustomNotFoundException();
        }
    }

    /**
     * to create a new requirement
     *
     * @param projectID     the id of the project to which the requirement belongs to
     * @param userStoryText user story text of the new requirement
     * @param status        status of the new requirement
     * @param name          name of the new requirement
     * @param deadline      deadline of the new requirement
     * @param functional    whether the requirement is functional
     * @param priority      priority of the new requirement
     * @param estimatedTime estimated time of the new requirement
     * @return the newly created requirement object
     * @throws ObjectAlreadyExistsException if the requirement already exists
     */
    public Requirement createRequirement(int projectID, String userStoryText, String status, String name, MyDate deadline, boolean functional, int priority, int estimatedTime) throws ObjectAlreadyExistsException {

        Requirement requirement = new Requirement(idCounter, projectID, userStoryText, status, name, deadline, functional, priority, estimatedTime);
        if (!requirements.contains(requirement)) {
            requirements.add(requirement);
            idCounter++;
            return requirement;
        } else throw new ObjectAlreadyExistsException();
    }


    /**
     * to edit a requirement
     *
     * @param requirement   the requirement to be edited
     * @param userStoryText new user story text of the requirement
     * @param status        new status of the requirement
     * @param name          new name of the requirement
     * @param deadline      new deadline of the requirement
     * @param functional    whether the requirement is functional
     * @param priority      new priority of the requirement
     * @param estimatedTime new estimated time of the requirement
     * @throws CustomNotFoundException if the requirement was not found
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

    public int getIdCounter() {
        return idCounter;
    }
}


