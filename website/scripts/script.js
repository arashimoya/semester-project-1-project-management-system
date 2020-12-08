
$(function () {

    let projectForm = $("#project-form");
    let customerName = $("#customer-name");
    let generatedData = $("#generated-data");

    projectForm.submit(function(){

        let customerNameInput = customerName.val();
        let requirementNameArray = [];

        $.ajax({
            type: "GET",
            url: "test.xml",
            dataType: "xml",
            success: xmlParser
        });

        function xmlParser(xml) {
            $(xml).find('projects').each(function() {
               let $project = $(this);
               let xmlCustomerName = $project.find('customer').find('name').text();
               if (customerNameInput == xmlCustomerName) {
                   $project.find('requirements').each(function (){
                       requirementArray.push($(this).find('name').text());
                   });
               }
            });
        }
        generatedData.append("                  <table>\n" +
            "                    <tr>\n" +
            "                        <th>requirement</th>\n" +
            "                        <th>status</th>\n" +
            "                    </tr>\n" +
            "\n" +
            "                    <tr>\n" +
            "                        <td>requirement 1</td>\n" +
            "                        <td>ended</td>\n" +
            "                    </tr>\n" +
            "\n" +
            "                    <tr>\n" +
            "                        <td>requirement 2</td>\n" +
            "                        <td>started</td>\n" +
            "                    </tr>\n" +
            "\n" +
            "                    <tr>\n" +
            "                        <td>requirement 3</td>\n" +
            "                        <td>approved</td>\n" +
            "                    </tr>\n" +
            "\n" +
            "                    <tr>\n" +
            "                        <td>requirement 4</td>\n" +
            "                        <td>approved</td>\n" +
            "                    </tr>\n" +
            "\n" +
            "                </table>")
        return false;


    });
});
