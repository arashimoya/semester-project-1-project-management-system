package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class ProjectReportList implements Serializable {
    private ArrayList<ProjectReport> projectReports;

    private static int idCounter;

    public ProjectReportList() {
        this.idCounter = 0;
        this.projectReports = new ArrayList<ProjectReport>();
    }

    public ProjectReport getProjectReport(int id) {
        for (ProjectReport projectReport : projectReports) {
            if (projectReport.getID() == id) {
                return projectReport;
            }
        }
        return null;
    }

    public ArrayList<ProjectReport> getProjectReports() {
        return projectReports;
    }

    public void addProjectReport(ProjectReport projectReport) throws ObjectAlreadyExistsException {
        if (!projectReports.contains(projectReport)) {
            projectReports.add(projectReport);
        }
        else {
            throw new ObjectAlreadyExistsException();
        }
    }

    public void deleteProjectReport(ProjectReport projectReport) throws CustomNotFoundException {
        if (projectReports.contains(projectReport)) {
            projectReports.remove(projectReport);
        } else {
            throw new CustomNotFoundException();
        }
    }

    public ProjectReport createProjectReport(ScrumMaster scrumMaster, String message) throws ObjectAlreadyExistsException{
        ProjectReport newProjectReport = new ProjectReport(idCounter++, scrumMaster, message);
        if (!projectReports.contains(newProjectReport)) {
            projectReports.add(newProjectReport);
            return newProjectReport;
        } else {
            throw new ObjectAlreadyExistsException();
        }
    }
}
