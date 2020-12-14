$(function () {


    $.ajax({
        type: "GET",
        url: "test.xml",
        dataType: "xml",
        success: xmlParser
    });

    function xmlParser(xml) {
        let appendString = '<table id="team-table">\n' +
            '                    <tr>\n' +
            '                        <th>\n' +
            '                            Name\n' +
            '                        </th>';


        $(xml).find('ColourIT').children('teamMemberList').children('teamMembers').each(function () {
            let teamMember = $(this);
            appendString += '<tr>' +
                '<td>' +
                    teamMember.children('name').text() +
                '</td>' +
                '</tr>';
        });
        appendString += '                </table>';


        $('#team-content').html(appendString).par
        let tableHeight = parseInt($('#team-table').css('height'), 10);
        $('#team-content').css("height", tableHeight+100);
    }
});
