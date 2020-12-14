package Model;

import java.io.Serializable;
import java.util.Objects;

/**
 * A class representing a task report
 * @author adam
 * @version 1.0
 */
public class TaskReport implements Serializable {
  private int id;
  private TeamMember teamMember;
  private String report;
  private MyDate reportDate;
  private int timeSpent;

  /**
   * A 4-argument constructor replacing parameters listed below
   *
   * @param id         id of the taskReport
   * @param teamMember the team member reporting
   * @param report     report represented by String
   * @param reportDate date the report was sent
   */
  public TaskReport(int id, TeamMember teamMember, String report, MyDate reportDate, int timeSpent) {
    this.id = id;
    this.teamMember = teamMember;
    this.report = report;
    this.reportDate = reportDate;
    this.timeSpent = timeSpent;
  }

  /**
   * Gets ID of the report
   *
   * @return id
   */
  public int getId() {
    return id;
  }

  /**
   * Gets ID of team member
   *
   * @return teamMemberID
   */
  public TeamMember getTeamMember() {
    return teamMember;
  }

  /**
   * Gets the report
   *
   * @return report
   */
  public String getReport() {
    return report;
  }

  /**
   * gets the time spent
   * @return the time spent
   */
  public int getTimeSpent() {
    return timeSpent;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TaskReport that = (TaskReport) o;

    if (getId() != that.getId()) return false;
    if (getTeamMember() != null ? !getTeamMember().equals(that.getTeamMember()) : that.getTeamMember() != null)
      return false;
    if (getReport() != null ? !getReport().equals(that.getReport()) : that.getReport() != null) return false;
    return reportDate != null ? reportDate.equals(that.reportDate) : that.reportDate == null;
  }

  @Override
  public int hashCode() {
    int result = getId();
    result = 31 * result + (getTeamMember() != null ? getTeamMember().hashCode() : 0);
    result = 31 * result + (getReport() != null ? getReport().hashCode() : 0);
    result = 31 * result + (reportDate != null ? reportDate.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "TaskReport{" +
            "id=" + id +
            ", teamMember=" + teamMember +
            ", report='" + report + '\'' +
            ", reportDate=" + reportDate +
            '}';
  }
}
