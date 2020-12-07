package FileIO;

import Model.ProjectList;
import parser.*;

import java.io.File;

public class MyXmlParser {

    private String fileName;

    public MyXmlParser (String fileName) {
        this.fileName = fileName;
    }

    public void writeToXml (ProjectList projectList) throws ParserException {
        XmlJsonParser parser = new XmlJsonParser();
        File file = parser.toXml(projectList, this.fileName);
    }

}
