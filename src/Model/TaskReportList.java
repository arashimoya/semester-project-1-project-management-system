package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of TaskReport objects.
 *
 * @author adam
 * @version 1.0
 */

public class TaskReportList implements Serializable {
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
    public void addTaskReport(TaskReport taskReport) throws ObjectAlreadyExistsException {
        if (!taskReports.contains(taskReport)) {
            taskReports.add(taskReport);
        }
        else {
            throw new ObjectAlreadyExistsException();
        }
    }

    /**
     * Removes a task report of the chosen id from the list
     *
     *
     */
    public void deleteTaskReport(TaskReport taskReport) throws CustomNotFoundException {
        if (taskReports.contains(taskReport)) {
            taskReports.remove(taskReport);
        } else throw new CustomNotFoundException();
    }

    /**
     * Creates a new task report and adds it to the list
     *
     * @param teamMember the team member reporting
     * @param report       report represented by String
     * @param reportDate   date the report was sent
     */
    public TaskReport createTaskReport(TeamMember teamMember, String report, MyDate reportDate) throws ObjectAlreadyExistsException{
        TaskReport newTaskReport = new TaskReport(idCounter++, teamMember, report, reportDate);
        if (!taskReports.contains(newTaskReport)) {
            taskReports.add(newTaskReport);
            return newTaskReport;
        } else {
            throw new ObjectAlreadyExistsException();
        }
    }
}
