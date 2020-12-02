package Model;

public class ProjectReport {
    private int id;
    private String message;
    private ScrumMaster scrumMaster;
    private MyDate date;

    public ProjectReport (ScrumMaster scrumMaster, String message) {
        //add id
        this.scrumMaster = scrumMaster;
        this.message = message;
        try {
            this.date = MyDate.today();
        }
        catch (IllegalDateException e) {

        }
    }

    public int getID(){return id;}

    public String getMessage() {
        return message;
    }

    public ScrumMaster getScrumMaster() {
        return scrumMaster;
    }

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
