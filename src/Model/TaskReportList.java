package Model;

import java.util.ArrayList;

/**
 * A class containing a list of TaskReport objects.
 *
 * @author adam
 * @version 1.0
 */

public class TaskReportList {
    private ArrayList<TaskReport> taskReports;
    private int idCounter;

    /**
     * No-argument constructor initializing the TaskReportList
     */
    public TaskReportList() {
        taskReports = new ArrayList<TaskReport>();
        idCounter = 0;
    }

    /**
     * Gets the task report of chosen ID
     *
     * @param id the ID of a task report
     * @return task report of chosen ID
     */
    public TaskReport getTaskReport(int id) {
        TaskReport returnTaskReport = null;

        for (TaskReport taskReport : taskReports) {
            if (id == taskReport.getId())
                returnTaskReport = taskReport;
        }
        return returnTaskReport;
    }

    /**
     * Gets the ArrayList containing TaskReport objects
     *
     * @return the ArrayList with TaskReport objects
     */
    public ArrayList<TaskReport> getTasks() {
        return taskReports;
    }

    /**
     * Adds a task report to the list
     *
     * @param taskReport the task report to add to the list
     */
    public void addTaskReport(TaskReport taskReport) {
        if (!taskReports.contains(taskReport)) {
            taskReports.add(taskReport);
        }
        else {
            System.out.println("already exists");
        }
    }

    /**
     * Removes a task report of the chosen id from the list
     *
     * @param id the id of the task report to delete
     */
    public void deleteTask(int id) {
        for (int i = 0; i < taskReports.size(); i++) {
            if (id == taskReports.get(i).getId()) {
                taskReports.remove(i);
                break;
            }
        }
    }

    /**
     * Creates a new task report and adds it to the list
     *
     * @param teamMemberID ID of the team member reporting
     * @param report       report represented by String
     * @param reportDate   date the report was sent
     */
    public void createTaskReport(int teamMemberID, String report, MyDate reportDate) {
        taskReports.add(new TaskReport(idCounter++, teamMemberID, report, reportDate));
    }

    /**
     * Removes and adds task report of chosen ID from and to the list
     *
     * @param id           the ID of the task report
     * @param teamMemberID ID of the team member reporting
     * @param report       report represented by String
     * @param reportDate   date the report was sent
     */
    public void editTask(int id, int teamMemberID, String report, MyDate reportDate) {
        for (int i = 0; i < taskReports.size(); i++) {
            if (id == taskReports.get(i).getId()) {
                taskReports.remove(i);
                break;
            }
        }
        taskReports.add(new TaskReport(id, teamMemberID, report, reportDate));
    }
}
