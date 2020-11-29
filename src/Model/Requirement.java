package Model;

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

    public String getName() {
        return name;
    }
    public void addTeamMember(TeamMember teamMember){
        teamMembers.add(teamMember);
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public int getID() {
        return ID;
    }

    public int getPriority() {
        return priority;
    }

    public int getProjectID() {
        return projectID;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public MyDate getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    public String getUserStoryText() {
        return userStoryText;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public TeamMemberList getTeamMembers() {
        return teamMembers;
    }

    public boolean isFunctional() {
        return functional;
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

    public void setFunctional(boolean functional) {
        this.functional = functional;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDeadline(MyDate deadline) {
        this.deadline = deadline;
    }

}
