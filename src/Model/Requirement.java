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
    private int timeSpent;
    private int estimatedTime;
    private int priority;
    private String userStoryText;
    private String status;
    private String name;
    private boolean functional;
    private TaskList taskList;
    private MyDate deadline;
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

    /**
     * returns the name of the requirement
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * adds a teammember to teammember list
     *
     * @param teamMember
     */
    public void addTeamMember(TeamMember teamMember) {
        teamMembers.add(teamMember);
    }

    /**
     * returns the estimated time
     *
     * @return estimatedTime
     */
    public int getEstimatedTime() {
        return estimatedTime;
    }

    /**
     * returns requirement ID
     *
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * gets a requirement priority
     *
     * @return priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * gets project ID
     *
     * @return project ID
     */
    public int getProjectID() {
        return projectID;
    }

    /**
     * gets time spent
     *
     * @return time spent
     */
    public int getTimeSpent() {
        return timeSpent;
    }

    /**
     * gets deadline
     *
     * @return deadline
     */

    public MyDate getDeadline() {
        return deadline;
    }

    /**
     * gets status
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * gets user story text
     *
     * @return userStoryText
     */

    public String getUserStoryText() {
        return userStoryText;
    }

    /**
     * gets Task List
     *
     * @return taskList
     */
    public TaskList getTaskList() {
        return taskList;
    }

    /**
     * gets all the teammembers
     *
     * @return teamMembers
     */
    public TeamMemberList getTeamMembers() {
        return teamMembers;
    }

    /**
     * checks if requirement is functional
     *
     * @return true or false
     */
    public boolean isFunctional() {
        return functional;
    }

    /**
     * sets user Story text to the given parameter
     *
     * @param userStoryText
     */
    public void setUserStoryText(String userStoryText) {
        this.userStoryText = userStoryText;
    }

    /**
     * sets status
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * sets time spent
     *
     * @param timeSpent
     */
    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    /**
     * sets name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets requirement to functional or notfuncional
     *
     * @param functional
     */
    public void setFunctional(boolean functional) {
        this.functional = functional;
    }

    /**
     * sets priority
     *
     * @param priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * sets a deadline
     *
     * @param deadline
     */
    public void setDeadline(MyDate deadline) {
        this.deadline = deadline;
    }

    /**
     * sets an estimated time
     *
     * @param estimatedTime estimated time
     */
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
