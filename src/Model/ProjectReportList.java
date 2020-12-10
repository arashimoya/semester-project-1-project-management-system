package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class ProjectReportList implements Serializable {
    private ArrayList<ProjectReport> projectReports;

    private static int idCounter;

    /**
     * no argument constructor initializing the project report list and the id counter
     */
    public ProjectReportList() {
        this.idCounter = 0;
        this.projectReports = new ArrayList<ProjectReport>();
    }

    /**
     * to search for a project report by id
     * @param id id to search for
     * @return the found project report
     */
    public ProjectReport getProjectReport(int id) {
        for (ProjectReport projectReport : projectReports) {
            if (projectReport.getID() == id) {
                return projectReport;
            }
        }
        return null;
    }

    /**
     * to get the full list of project reports
     * @return full list of project reports
     */
    public ArrayList<ProjectReport> getProjectReports() {
        return projectReports;
    }

    /**
     * to add a project to the list
     * @param projectReport the project report to be added
     * @throws ObjectAlreadyExistsException if the project report is already in the list
     */
    public void addProjectReport(ProjectReport projectReport) throws ObjectAlreadyExistsException {
        if (!projectReports.contains(projectReport)) {
            projectReports.add(projectReport);
        }
        else {
            throw new ObjectAlreadyExistsException();
        }
    }

    /**
     * to delete a project report from the list
     * @param projectReport the project report to be deleted
     * @throws CustomNotFoundException if the project was not found
     */
    public void deleteProjectReport(ProjectReport projectReport) throws CustomNotFoundException {
        if (projectReports.contains(projectReport)) {
            projectReports.remove(projectReport);
        } else {
            throw new CustomNotFoundException();
        }
    }

    /**
     * to create a new project report
     * @param scrumMaster scrum master that writes the project report
     * @param message  message of the project report
     * @return the new project report
     * @throws ObjectAlreadyExistsException if such project already exists
     */
    public ProjectReport createProjectReport(TeamMember scrumMaster, String message) throws ObjectAlreadyExistsException{
        ProjectReport newProjectReport = new ProjectReport(idCounter++, scrumMaster, message);
        if (!projectReports.contains(newProjectReport)) {
            projectReports.add(newProjectReport);
            return newProjectReport;
        } else {
            throw new ObjectAlreadyExistsException();
        }
    }
}
