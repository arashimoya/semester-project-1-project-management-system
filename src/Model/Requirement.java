package Model;

import java.io.Serializable;
import java.util.Objects;

/**
 * A class representing a requirement
 *
 * @author tymon
 * @version 1.0
 */
public class Requirement implements Serializable {

    private int ID;
    private int projectID;
    private String userStoryText;
    private String status;
    private int timeSpent;
    private String name;
    private MyDate deadline;
    private boolean functional;
    private int priority;
    private int estimatedTime;
    private TaskList taskList;
    private TeamMemberList teamMembers;

    /**
     * 9-argument constructor initializing taskList and teamMembers list
     * @param id ID of the requirement
     * @param projectID ID of a project the requirement is assigned to
     * @param userStoryText user story text of the requirement
     * @param status status of the requirement
     * @param name name of the requirement
     * @param deadline deadline of the requirement
     * @param functional information whether the requirement is functional or not
     * @param priority priority of the requirement
     * @param estimatedTime estimated time of completing the requirement
     */
    public Requirement(int id, int projectID, String userStoryText, String status, String name, MyDate deadline, boolean functional, int priority, int estimatedTime) {
        this.ID = id;
        this.projectID = projectID;
        this.userStoryText = userStoryText;
        this.status = status;
        this.name = name;
        this.deadline = deadline;
        this.functional = functional;
        this.priority = priority;
        this.estimatedTime = estimatedTime;
        taskList = new TaskList();
        teamMembers = new TeamMemberList();
    }

    /**
     * Gets the ID of the requirement
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Gets the ID of the project the requirement is assigned to
     * @return projectID
     */
    public int getProjectID() {
        return projectID;
    }

    /**
     * Gets user story text of the requirement
     * @return userStoryText
     */
    public String getUserStoryText() {
        return userStoryText;
    }

    /**
     * Gets the status of the requirement
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets time spent on the requirement
     * @return timeSpent
     */
    public int getTimeSpent() {
        return timeSpent;
    }

    /**
     * Gets the name of the requirement
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets deadline of the requirement
     * @return deadline
     */
    public MyDate getDeadline() {
        return deadline;
    }

    /**
     * Gets the information whether the requirement is functional or not
     * @return functional
     */
    public boolean isFunctional() {
        return functional;
    }

    /**
     * Gets the priority of the requirement
     * @return priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Gets estimated time of completing the requirement
     * @return estimatedTime
     */
    public int getEstimatedTime() {
        return estimatedTime;
    }

    /**
     * Gets the list of the tasks assigned to this requirement
     * @return taskList
     */
    public TaskList getTasks() {
        return taskList;
    }

    /**
     * Gets the list of the team members assigned to this requirement
     * @return
     */
    public TeamMemberList getTeamMembers() {
        return teamMembers;
    }

    /**
     * Sets the user story text of the requirement
     * @param userStoryText user story text of the requirement
     */
    public void setUserStoryText(String userStoryText) {
        this.userStoryText = userStoryText;
    }

    /**
     * Sets the status of the requirement
     * @param status status of the requirement
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Sets time spent of the requirement
     * @param timeSpent time spent on the requirement
     */
    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    /**
     * Sets the name of the requirement
     * @param name the name of the requirement
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the deadline of the requirement
     * @param deadline deadline of the requirement
     */
    public void setDeadline(MyDate deadline) {
        this.deadline = deadline;
    }

    /**
     * Sets the boolean variable of functional
     * @param functional the information whether the requirement is functional or not
     */
    public void setFunctional(boolean functional) {
        this.functional = functional;
    }

    /**
     * Sets the priority of the requirement
     * @param priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Sets estimated time of completing the requirement
     * @param estimatedTime estimated time of completing the requirement
     */
    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Requirement that = (Requirement) o;

        if (getID() != that.getID()) return false;
        if (getProjectID() != that.getProjectID()) return false;
        if (getTimeSpent() != that.getTimeSpent()) return false;
        if (isFunctional() != that.isFunctional()) return false;
        if (getPriority() != that.getPriority()) return false;
        if (getEstimatedTime() != that.getEstimatedTime()) return false;
        if (getUserStoryText() != null ? !getUserStoryText().equals(that.getUserStoryText()) : that.getUserStoryText() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getDeadline() != null ? !getDeadline().equals(that.getDeadline()) : that.getDeadline() != null)
            return false;
        if (taskList != null ? !taskList.equals(that.taskList) : that.taskList != null) return false;
        return getTeamMembers() != null ? getTeamMembers().equals(that.getTeamMembers()) : that.getTeamMembers() == null;
    }

    @Override
    public int hashCode() {
        int result = getID();
        result = 31 * result + getProjectID();
        result = 31 * result + (getUserStoryText() != null ? getUserStoryText().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + getTimeSpent();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDeadline() != null ? getDeadline().hashCode() : 0);
        result = 31 * result + (isFunctional() ? 1 : 0);
        result = 31 * result + getPriority();
        result = 31 * result + getEstimatedTime();
        result = 31 * result + (taskList != null ? taskList.hashCode() : 0);
        result = 31 * result + (getTeamMembers() != null ? getTeamMembers().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Requirement{" +
                "ID=" + ID +
                ", projectID=" + projectID +
                ", userStoryText='" + userStoryText + '\'' +
                ", status='" + status + '\'' +
                ", timeSpent=" + timeSpent +
                ", name='" + name + '\'' +
                ", deadline=" + deadline +
                ", functional=" + functional +
                ", priority=" + priority +
                ", estimatedTime=" + estimatedTime +
                ", taskList=" + taskList +
                ", teamMembers=" + teamMembers +
                '}';
    }
}
