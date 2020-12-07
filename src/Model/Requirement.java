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
     * constructor that takes all the listed data below
     * and initialises team members list
     *
     * @param projectID
     * @param userStoryText
     * @param name
     * @param functional
     * @param deadline
     * @param estimatedTime
     * @param priority
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

    public int getID() {
        return ID;
    }

    public int getProjectID() {
        return projectID;
    }

    public String getUserStoryText() {
        return userStoryText;
    }

    public String getStatus() {
        return status;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public String getName() {
        return name;
    }

    public MyDate getDeadline() {
        return deadline;
    }

    public boolean isFunctional() {
        return functional;
    }

    public int getPriority() {
        return priority;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public TaskList getTasks() {
        return taskList;
    }

    public TeamMemberList getTeamMembers() {
        return teamMembers;
    }

    public void setUserStoryText(String userStoryText) {
        this.userStoryText = userStoryText;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeadline(MyDate deadline) {
        this.deadline = deadline;
    }

    public void setFunctional(boolean functional) {
        this.functional = functional;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

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
