package Model;

import java.io.Serializable;

/**
 * A class representing a project report
 * @author kurwa
 * @version ?
 */
public class ProjectReport implements Serializable {
    private int id;
    private String message;
    private ScrumMaster scrumMaster;
    private MyDate date;

    /**
     * 3-argument constructor setting the parameters below and date variable to current date
     * @param id id of the project report
     * @param scrumMaster scrum master the report is sent to
     * @param message message of the project report
     */
    public ProjectReport(int id, ScrumMaster scrumMaster, String message) {
        this.id = id;
        this.scrumMaster = scrumMaster;
        this.message = message;
        try {
            this.date = MyDate.today();
        } catch (IllegalDateException e) {

        }
    }

    /**
     * Gets the id of the project report
     * @return id
     */
    public int getID() {
        return id;
    }

    /**
     * Gets the message of the project report
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the scrum master the project report is sent to
     * @return scrumMaster
     */
    public ScrumMaster getScrumMaster() {
        return scrumMaster;
    }

    /**
     * Gets the date of the project report
     * @return date
     */
    public MyDate getDate() {
        return date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectReport that = (ProjectReport) o;

        if (id != that.id) return false;
        if (getMessage() != null ? !getMessage().equals(that.getMessage()) : that.getMessage() != null) return false;
        if (getScrumMaster() != null ? !getScrumMaster().equals(that.getScrumMaster()) : that.getScrumMaster() != null)
            return false;
        return getDate() != null ? getDate().equals(that.getDate()) : that.getDate() == null;
    }


    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        result = 31 * result + (getScrumMaster() != null ? getScrumMaster().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "ProjectReport{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", scrumMaster=" + scrumMaster +
                ", date=" + date +
                '}';
    }
}
