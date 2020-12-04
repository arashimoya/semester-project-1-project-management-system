package Model;

import java.util.ArrayList;

public class ProjectReportList {
    private ArrayList<ProjectReport> projectReports;

    private int idCounter;

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

    public void addProjectReport(ProjectReport projectReport) {
        boolean isThere = false;
        for (ProjectReport existingProjectReport : projectReports) {
            if (existingProjectReport.equals(projectReport))
                isThere = true;
        }
        if (isThere == false) {
            projectReports.add(projectReport);
        } else {
            //change
            System.out.println("project is already added");
        }
    }

    public void deleteProjectReport(int id) throws CustomNotFoundException {
        boolean isThere = false;
        for (ProjectReport projectReport : projectReports) {
            if (projectReport.getID() == id) {
                projectReports.remove(projectReport);
                isThere = true;
            }
        }
        if (!isThere)
            throw new CustomNotFoundException();
    }

    public void createProjectReport(ScrumMaster scrumMaster, String message) {
        projectReports.add(new ProjectReport(idCounter++, scrumMaster, message));
    }
}
