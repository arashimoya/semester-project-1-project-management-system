$(function () {
    let requirementNameArray = [];
    let requirementStatusArray = [];
    let projectForm = $("#project-form");
    let customerName = $("#customer-name");
    let generatedData = $("#generated-data");
    let bannerTitle = $(".banner-title");
    let customerNameInput;

    function appendButton () {
    let appendButton = "<button id='returnButton'>Change customer</button>"
    generatedData.append(appendButton);
    let returnButton = $("#returnButton");
    returnButton.click(function(){
        localStorage.clear();
        window.location.href='projects.html';
    });
}

    function generateData ($project, xmlCustomerName) {
        let appendString;
        let projectDescription;
        let projectName;
        let bannerTitleText;
        let i;

        projectDescription = $project.children('description').text();
        projectName = $project.children('name').text();
        bannerTitleText = xmlCustomerName;
        bannerTitle.html(bannerTitleText);
        $project.find('requirements').each(function () {
            requirementNameArray.push($(this).children('name').text());
            requirementStatusArray.push($(this).find('status').text());
        });

        appendString = "";
        appendString += "<h2 class='project-name'>" + projectName + "</h2>"
        appendString += "<div class='project-description'>" + projectDescription + "</div>"
        appendString += "<table class='project-table'>\n" +
            "<tr>\n" +
            "<th>requirement</th>\n" +
            "<th>status</th>\n" +
            "</tr>\n" +
            "\n";
        i;
        for (i = 0; i < requirementNameArray.length; i++) {
            appendString += "<tr>\n" +
                "<td>" + requirementNameArray[i] + "</td>\n" +
                "<td>" + requirementStatusArray[i] + "</td>\n" +
                "</tr>\n" +
                "\n";
        }
        appendString += "</table>";
        generatedData.append(appendString);

    }

    if (localStorage.getItem("customerName") === null) {
        projectForm.submit(function () {
            customerNameInput = customerName.val();
            projectForm.hide();
            $.ajax({
                type: "GET",
                url: "test.xml",
                dataType: "xml",
                success: xmlParser
            });
            function xmlParser(xml) {
                let $project;
                let xmlCustomerName;
                let foundCount = 0;

                $(xml).find('projects').each(function () {
                    $project = $(this);
                    xmlCustomerName = $project.children('customer').children('name').text();
                    if (customerNameInput == xmlCustomerName) {
                        foundCount++;
                        generateData($project, xmlCustomerName);
                        localStorage.setItem("customerName", xmlCustomerName);
                    }
                });
                if (foundCount == 0) {
                    console.log("here");
                    generatedData.append("<p>No projects found for this customer</p>");
                }
                appendButton();
            }
            return false;
        });
    }

    else {
        projectForm.hide();
            $.ajax({
                type: "GET",
                url: "test.xml",
                dataType: "xml",
                success: xmlParser
            });
            function xmlParser(xml) {
                let $project;
                let xmlCustomerName;

                $(xml).find('projects').each(function () {
                    $project = $(this);
                    xmlCustomerName = $project.children('customer').children('name').text();
                    if (localStorage.getItem("customerName") == xmlCustomerName) {
                        generateData($project, xmlCustomerName);
                        localStorage.setItem("customerName", xmlCustomerName);
                    }
                });
                appendButton();
            }
        }
});
