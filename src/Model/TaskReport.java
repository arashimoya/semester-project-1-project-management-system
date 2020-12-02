package Model;

/**
 * A class representing a task report
 * @author scatman john
 * @version 1.0
 */
public class TaskReport {
  private int id;
  private int teamMemberID;
  private String report;
  private MyDate reportDate;

  /**
   * A 4-argument constructor replacing parameters listed below
   * @param id id of the taskReport
   * @param teamMemberID id of the team member reporting
   * @param report report represented by String
   * @param reportDate date the report was sent
   */
  public TaskReport(int id, int teamMemberID, String report, MyDate reportDate)
  {
    this.id=id;
    this.teamMemberID = teamMemberID;
    this.report = report;
    this.reportDate = reportDate;
  }

  /**
   * Gets ID of the report
   * @return id
   */
  public int getId()
  {
    return id;
  }

  /**
   * Gets ID of team member
   * @return teamMemberID
   */
  public int getTeamMemberID()
  {
    return teamMemberID;
  }

  /**
   * Gets report
   * @return report
   */
  public String getReport()
  {
    return report;
  }
}
