package Model;

import java.util.Objects;

/**
 * A class representing a requirement
 *
 * @author tymon
 * @version 1.0
 */
public class Requirement {

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
     * @param ID
     * @param projectID
     * @param userStoryText
     * @param name
     * @param functional
     * @param deadline
     * @param estimatedTime
     * @param priority
     */
    public Requirement(int ID, int projectID, String userStoryText, String name,
                       boolean functional, MyDate deadline, int estimatedTime, int priority) {
        this.ID = ID;
        this.projectID = projectID;
        this.userStoryText = userStoryText;
        this.status = "In progress";
        taskList = new TaskList();
        this.deadline = deadline;
        this.functional = functional;
        this.timeSpent = 0;
        this.name = name;
        this.estimatedTime = estimatedTime;
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

    /**
     * checks if two objects are the same
     *
     * @param o object that is going to be compared
     * @return true if objects are equal, otherwise returns false
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Requirement that = (Requirement) o;
        return ID == that.ID &&
                projectID == that.projectID &&
                timeSpent == that.timeSpent &&
                estimatedTime == that.estimatedTime &&
                priority == that.priority &&
                functional == that.functional &&
                Objects.equals(userStoryText, that.userStoryText) &&
                Objects.equals(status, that.status) &&
                Objects.equals(name, that.name) &&
                Objects.equals(taskList, that.taskList) &&
                Objects.equals(deadline, that.deadline) &&
                Objects.equals(teamMembers, that.teamMembers);
    }

}
