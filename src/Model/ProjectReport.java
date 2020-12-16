package Model;

import java.io.Serializable;
import java.util.Objects;

/**
 * A class representing a project report
 *
 * @author Oliver
 * @version 1.0
 */
public class ProjectReport implements Serializable {
    private int id;
    private String message;
    private TeamMember scrumMaster;
    private MyDate date;

    /**
     * 3-argument constructor setting the parameters below and date variable to current date
     *
     * @param id          id of the project report
     * @param scrumMaster scrum master the report is sent to
     * @param message     message of the project report
     */
    public ProjectReport(int id, TeamMember scrumMaster, String message) {
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
     *
     * @return id
     */
    public int getID() {
        return id;
    }

    /**
     * Gets the message of the project report
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the scrum master the project report is sent to
     *
     * @return scrumMaster
     */
    public TeamMember getScrumMaster() {
        return scrumMaster;
    }

    /**
     * Gets the date of the project report
     *
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
        return id == that.id &&
                Objects.equals(message, that.message) &&
                Objects.equals(scrumMaster, that.scrumMaster) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, scrumMaster, date);
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
