package Model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A class representing a task
 *
 * @author adam
 * @version 1.0
 */
public class Task {

    private int id;
    private int requirementID;
    private String description;
    private int timeSpent;
    private String name;
    private MyDate deadline;
    private String status;
    private TaskReportList taskReportList;
    private TeamMemberList teamMemberList;
    private int estimatedTime;


    /**
     * A 6-argument constructor initializing the teamMembers Arraylist and lets
     * user to input data for parameters listed below
     *
     * @param id            id of the task
     * @param requirementID id of requirement the task is assigned with
     * @param description   description of the task
     * @param name          name of the task
     * @param deadline      furthest date the task can be completed
     * @param estimatedTime estimated time of task completion
     */
    public Task(int id,int requirementID, String description, String name, MyDate deadline, int estimatedTime) {
        this.id = id;
        this.requirementID = requirementID;
        this.description = description;
        this.name = name;
        this.deadline = deadline;
        this.estimatedTime = estimatedTime;
        taskReportList = new TaskReportList();
        teamMemberList = new TeamMemberList();
    }

    /**
     * Gets the ID of the task
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the ID of the requirement the task is assigned to
     *
     * @return requirementID
     */
    public int getRequirementID() {
        return requirementID;
    }

    /**
     * Gets the description of the task
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets time spent on the task
     *
     * @return estimatedTime
     */
    public int getTimeSpent() {
        return timeSpent;
    }

    /**
     * Gets the status of the task
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets name of the task
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets deadline of the task
     *
     * @return deadline
     */
    public MyDate getDeadline() {
        return deadline;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public TaskReportList getTaskReports() {
        return taskReportList;
    }

    public TeamMemberList getTeamMembers() {
        return teamMemberList;
    }

    /**
     * Replaces the description of the task
     *
     * @param description the description to replace with
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Replaces the status of the task
     *
     * @param status the status to replace with
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Replaces the name of the task
     *
     * @param name the name to replace with
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Replaces the deadline of the task
     *
     * @param deadline the deadline to replace with
     */
    public void setDeadline(MyDate deadline) {
        this.deadline = deadline;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                requirementID == task.requirementID &&
                timeSpent == task.timeSpent &&
                estimatedTime == task.estimatedTime &&
                Objects.equals(description, task.description) &&
                Objects.equals(name, task.name) &&
                Objects.equals(deadline, task.deadline) &&
                Objects.equals(status, task.status) &&
                Objects.equals(taskReportList, task.taskReportList) &&
                Objects.equals(teamMemberList, task.teamMemberList);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", requirementID=" + requirementID +
                ", description='" + description + '\'' +
                ", timeSpent=" + timeSpent +
                ", name='" + name + '\'' +
                ", deadline=" + deadline +
                ", status='" + status + '\'' +
                ", taskReportList=" + taskReportList +
                ", teamMemberList=" + teamMemberList +
                ", estimatedTime=" + estimatedTime +
                '}';
    }
}
