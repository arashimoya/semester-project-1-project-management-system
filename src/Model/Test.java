package Model;


import FileIO.MyFileIO;

public class Test {
    public static <RequirementNotFoundException> void main(String[] args) throws ObjectAlreadyExistsException {
        ColourITFileAdapter colourITFileAdapter = new ColourITFileAdapter("data.bin", "data.xml");

        ColourIT colourIT = new ColourIT();

        TeamMember teamMember1 = new TeamMember(0, "name1");
        TeamMember teamMember2 = new TeamMember(1, "name2");
        TeamMember teamMember3 = new TeamMember(3, "name3");
        TeamMember teamMember4 = new TeamMember(4, "name4");

        TeamMember teamMember5 = new TeamMember(5, "name5");
        TeamMember teamMember6 = new TeamMember(6, "name6");
        TeamMember teamMember7 = new TeamMember(7, "name7");
        TeamMember teamMember8 = new TeamMember(8, "name8");

        TeamMember teamMember9 = new TeamMember(9, "name9");
        TeamMember teamMember10 = new TeamMember(10, "name10");
        TeamMember teamMember11 = new TeamMember(11, "name11");
        TeamMember teamMember12 = new TeamMember(12, "name12");

        TeamMember teamMember13 = new TeamMember(13, "name13");
        TeamMember teamMember14 = new TeamMember(14, "name14");
        TeamMember teamMember15 = new TeamMember(15, "name15");
        TeamMember teamMember16 = new TeamMember(16, "name16");

        Customer customer1 = new Customer(0, "Alex");
        Customer customer2 = new Customer(1, "Dan");
        MyDate myDate1 = null;
        try {
            myDate1 = MyDate.today();
        } catch (IllegalDateException e) {
            e.printStackTrace();
        }
        Project project1 = new Project(0, "ProjectName1", teamMember1, teamMember2, teamMember3, myDate1, customer1, "This is a short description of project1");
        Project project2 = new Project(1, "ProjectName2", teamMember1, teamMember2, teamMember3, myDate1, customer2, "This is a short description of project2");

        colourIT.getProjectList().addProject(project1);
        colourIT.getProjectList().addProject(project2);

        Requirement requirement1 = new Requirement(0, 0, "someuserstorytext1", "somestatus1", "requirementname1", myDate1, false, 0, 20);
        Requirement requirement2 = new Requirement(1, 0, "someuserstorytext2", "somestatus2", "requirementname2", myDate1, true, 1, 25);
        Requirement requirement3 = new Requirement(2, 1, "someuserstorytext3", "somestatus3", "requirementname3", myDate1, true, 1, 15);
        Requirement requirement4 = new Requirement(3, 1, "someuserstorytext4", "somestatus4", "requirementname4", myDate1, false, 3, 40);


        Task task1 = new Task(0, 0, "Short description of task 1", "taskname1", myDate1, 5);
        Task task2 = new Task(1, 0, "Short description of task 2", "taskname2", myDate1, 10);
        Task task3 = new Task(2, 1, "Short description of task 3", "taskname3", myDate1, 15);
        Task task4 = new Task(3, 1, "Short description of task 4", "taskname4", myDate1, 20);
        Task task5 = new Task(4, 2, "Short description of task 5", "taskname5", myDate1, 25);
        Task task6 = new Task(5, 2, "Short description of task 6", "taskname6", myDate1, 30);
        Task task7 = new Task(6, 3, "Short description of task 7", "taskname7", myDate1, 35);
        Task task8 = new Task(7, 3, "Short description of task 8", "taskname8", myDate1, 40);

        project1.getRequirementList().addRequirement(requirement1);
        project1.getRequirementList().addRequirement(requirement2);
        project2.getRequirementList().addRequirement(requirement3);
        project2.getRequirementList().addRequirement(requirement4);

        try {
            project1.getRequirementList().getRequirement("requirementname1").getTaskList().addTask(task1);
            project1.getRequirementList().getRequirement("requirementname1").getTaskList().addTask(task2);
            project1.getRequirementList().getRequirement("requirementname2").getTaskList().addTask(task3);
            project1.getRequirementList().getRequirement("requirementname2").getTaskList().addTask(task4);
            project2.getRequirementList().getRequirement("requirementname3").getTaskList().addTask(task5);
            project2.getRequirementList().getRequirement("requirementname3").getTaskList().addTask(task6);
            project2.getRequirementList().getRequirement("requirementname4").getTaskList().addTask(task7);
            project2.getRequirementList().getRequirement("requirementname4").getTaskList().addTask(task8);
        } catch (CustomNotFoundException | ObjectAlreadyExistsException e) {
            e.printStackTrace();
        }

        colourIT.getTeamMemberList().addTeamMember(teamMember1);
        colourIT.getTeamMemberList().addTeamMember(teamMember2);
        colourIT.getTeamMemberList().addTeamMember(teamMember3);
        colourIT.getTeamMemberList().addTeamMember(teamMember4);

        colourIT.getTeamMemberList().addTeamMember(teamMember5);
        colourIT.getTeamMemberList().addTeamMember(teamMember6);
        colourIT.getTeamMemberList().addTeamMember(teamMember7);
        colourIT.getTeamMemberList().addTeamMember(teamMember8);

        colourIT.getTeamMemberList().addTeamMember(teamMember9);
        colourIT.getTeamMemberList().addTeamMember(teamMember10);
        colourIT.getTeamMemberList().addTeamMember(teamMember11);
        colourIT.getTeamMemberList().addTeamMember(teamMember12);

        colourIT.getTeamMemberList().addTeamMember(teamMember13);
        colourIT.getTeamMemberList().addTeamMember(teamMember14);
        colourIT.getTeamMemberList().addTeamMember(teamMember15);
        colourIT.getTeamMemberList().addTeamMember(teamMember16);

        project1.getTeamMemberList().addTeamMember(teamMember1);
        project1.getTeamMemberList().addTeamMember(teamMember2);
        project1.getTeamMemberList().addTeamMember(teamMember3);
        project1.getTeamMemberList().addTeamMember(teamMember4);
        project1.getTeamMemberList().addTeamMember(teamMember5);
        project1.getTeamMemberList().addTeamMember(teamMember6);
        project1.getTeamMemberList().addTeamMember(teamMember7);
        project1.getTeamMemberList().addTeamMember(teamMember8);

        project2.getTeamMemberList().addTeamMember(teamMember9);
        project2.getTeamMemberList().addTeamMember(teamMember10);
        project2.getTeamMemberList().addTeamMember(teamMember11);
        project2.getTeamMemberList().addTeamMember(teamMember12);
        project2.getTeamMemberList().addTeamMember(teamMember13);
        project2.getTeamMemberList().addTeamMember(teamMember14);
        project2.getTeamMemberList().addTeamMember(teamMember15);
        project2.getTeamMemberList().addTeamMember(teamMember16);

        requirement1.getTeamMembers().addTeamMember(teamMember1);
        requirement1.getTeamMembers().addTeamMember(teamMember2);
        requirement1.getTeamMembers().addTeamMember(teamMember3);
        requirement1.getTeamMembers().addTeamMember(teamMember4);

        requirement2.getTeamMembers().addTeamMember(teamMember5);
        requirement2.getTeamMembers().addTeamMember(teamMember6);
        requirement2.getTeamMembers().addTeamMember(teamMember7);
        requirement2.getTeamMembers().addTeamMember(teamMember8);

        requirement3.getTeamMembers().addTeamMember(teamMember9);
        requirement3.getTeamMembers().addTeamMember(teamMember10);
        requirement3.getTeamMembers().addTeamMember(teamMember11);
        requirement3.getTeamMembers().addTeamMember(teamMember12);

        requirement4.getTeamMembers().addTeamMember(teamMember13);
        requirement4.getTeamMembers().addTeamMember(teamMember14);
        requirement4.getTeamMembers().addTeamMember(teamMember15);
        requirement4.getTeamMembers().addTeamMember(teamMember16);

        task1.getTeamMemberList().addTeamMember(teamMember1);
        task1.getTeamMemberList().addTeamMember(teamMember2);

        task2.getTeamMemberList().addTeamMember(teamMember3);
        task2.getTeamMemberList().addTeamMember(teamMember4);

        task3.getTeamMemberList().addTeamMember(teamMember5);
        task3.getTeamMemberList().addTeamMember(teamMember6);

        task4.getTeamMemberList().addTeamMember(teamMember7);
        task4.getTeamMemberList().addTeamMember(teamMember8);

        task5.getTeamMemberList().addTeamMember(teamMember9);
        task5.getTeamMemberList().addTeamMember(teamMember10);

        task6.getTeamMemberList().addTeamMember(teamMember11);
        task6.getTeamMemberList().addTeamMember(teamMember12);

        task7.getTeamMemberList().addTeamMember(teamMember13);
        task7.getTeamMemberList().addTeamMember(teamMember14);

        task8.getTeamMemberList().addTeamMember(teamMember15);
        task8.getTeamMemberList().addTeamMember(teamMember16);

        colourITFileAdapter.save(colourIT);
        colourITFileAdapter.saveToXml(colourIT);

        System.out.println(colourIT);

    }
}

