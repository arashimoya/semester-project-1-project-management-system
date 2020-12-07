package Model;


public class Test {
    public static void main(String[] args) {
        ColourIT colourIT = new ColourIT();



        colourIT.getTeamMemberList().CreateTeamMember("Oliver Sperlik");
        TeamMember oliver = null;
        try {
            oliver = colourIT.getTeamMemberList().getTeamMember("Oliver Sperlik");
        } catch (CustomNotFoundException e) {
            System.out.println("...");
        }

        colourIT.getTeamMemberList().CreateTeamMember("Tymon Podlowski");
        TeamMember tymon = null;
        try {
            tymon = colourIT.getTeamMemberList().getTeamMember("Tymon Podlowski");
        } catch (CustomNotFoundException e) {
            System.out.println("...");
        }

        colourIT.getTeamMemberList().CreateTeamMember("Adam Arasimowicz");
        TeamMember adam = null;
        try {
            adam = colourIT.getTeamMemberList().getTeamMember("Adam Arasimowicz");
        } catch (CustomNotFoundException e) {
            System.out.println("...");
        }

        colourIT.getCustomerList().createCustomer("Allan");
        Customer customer = null;
        try {
            customer = colourIT.getCustomerList().getCustomer("Allan");
        }
        catch (CustomNotFoundException e)  {
            System.out.println("customer not found");
        }

        MyDate myDate = null;
        try {
            myDate = MyDate.today();
        }
        catch (IllegalDateException e) {
            System.out.println("kurwa");
        }
        colourIT.getProjectList().createProject("TestProject",tymon, oliver, adam, myDate, customer);

        ColourITFileAdapter colourITFileAdapter = new ColourITFileAdapter("data.bin", "projects.xml");
        colourITFileAdapter.save(colourIT);
        System.out.println(colourITFileAdapter.getColourIt());
        colourITFileAdapter.saveToXml(colourIT);
    }
}

