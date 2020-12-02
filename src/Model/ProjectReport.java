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

    public String getMessage() {
        return message;
    }

    public ScrumMaster getScrumMaster() {
        return scrumMaster;
    }

    public MyDate getDate() {
        return date;
    }

    public int getId() {
        return id;
    }




}
