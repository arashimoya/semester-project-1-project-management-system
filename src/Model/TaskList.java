package Model;

import java.util.ArrayList;

/**
 * A class containing a list of Task objects
 *
 * @author adam
 * @version 1.0
 */

public class TaskList {

    private ArrayList<Task> tasks;
    private int idCounter;

    /**
     * No-argument constructor initializing TaskList
     */
    public TaskList() {
        tasks = new ArrayList<Task>();
        idCounter = 0;
    }

    /**
     * Gets a task of chosen ID from the list
     *
     * @param id the ID of task
     * @return task of chosen ID
     */
    public Task getTask(int id) {
        Task returnTask = null;

        for (Task task : tasks) {
            if (id == task.getId())
                returnTask = task;
        }
        return returnTask;
    }

    /**
     * Gets the ArrayList containing Task objects
     *
     * @return the ArrayList with Task objects
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Adds a Task to the list
     *
     * @param task the task to add to the list
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Removes a Task of chosen ID from the list
     *
     * @param id the ID of a task
     */
    public void deleteTask(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (id == tasks.get(i).getId()) {
                tasks.remove(i);
                break;
            }
        }
    }

    /**
     * Creates a new task and adds it to the list
     *
     * @param requirementID id of requirement the task is assigned with
     * @param description   description of the task
     * @param name          name of the task
     * @param deadline      furthest date the task can be completed
     * @param estimatedTime estimated time of task completion
     */
    public void createTask(int requirementID, String description, String name, MyDate deadline, int estimatedTime) {
        tasks.add(new Task(idCounter++, requirementID, description, name, deadline, estimatedTime));
    }

    /**
     * Removes and adds task of chosen ID from and to the list
     *
     * @param id            id of the task
     * @param requirementID id of requirement the task is assigned with
     * @param description   description of the task
     * @param name          name of the task
     * @param deadline      furthest date the task can be completed
     * @param estimatedTime estimated time of task completion
     */
    public void editTask(int id, int requirementID, String description, String name, MyDate deadline, int estimatedTime) {
        for (int i = 0; i < tasks.size(); i++) {
            if (id == tasks.get(i).getId()) {
                tasks.remove(i);
                break;
            }
        }
        tasks.add(new Task(id, requirementID, description, name, deadline, estimatedTime));
    }
}
