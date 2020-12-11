package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Task objects
 *
 * @author adam
 * @version 1.0
 */

public class TaskList implements Serializable {

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
    public Task getTask(int id) throws CustomNotFoundException{
        for (Task task : tasks) {
            if (id == task.getId())
                return task;
        }
        throw new CustomNotFoundException();
    }

    public Task getTask(String name) throws CustomNotFoundException{
        for (Task task : tasks) {
            if (task.getName().equals(name))
                return task;
        }
        throw new CustomNotFoundException();
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
    public void addTask(Task task) throws ObjectAlreadyExistsException{
        if (!tasks.contains(task)) {
            tasks.add(task);
        }
        else {
            throw new ObjectAlreadyExistsException();
        }
    }

    /**
     * Removes a Task of chosen ID from the list
     *
     *
     */
    public void deleteTask(Task task) throws CustomNotFoundException{
        if (tasks.contains(task)) {
            tasks.remove(task);
        }
        else {
            throw new CustomNotFoundException();
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
    public Task createTask(int requirementID, String description, String name, MyDate deadline, int estimatedTime) throws ObjectAlreadyExistsException {
        Task newTask = new Task(idCounter, requirementID, description, name, deadline, estimatedTime);
        if (!tasks.contains(newTask)) {
            tasks.add(newTask);
            idCounter++;
            return newTask;
        } else {
            throw new ObjectAlreadyExistsException();
        }
    }

    /**
     * Removes and adds task of chosen ID from and to the list
     *
     * @param description   description of the task
     * @param name          name of the task
     * @param deadline      furthest date the task can be completed
     * @param estimatedTime estimated time of task completion
     */
    public void editTask(Task task, String status, String description, String name, MyDate deadline, int estimatedTime) throws CustomNotFoundException {
        if (tasks.contains(task)) {
            task.setStatus(status);
            task.setDescription(description);
            task.setName(name);
            task.setDeadline(deadline);
            task.setEstimatedTime(estimatedTime);
        } else
            throw new CustomNotFoundException();
    }

    public int getIdCounter() {
        return idCounter;
    }
}
