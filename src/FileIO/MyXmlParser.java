package FileIO;

import Model.ColourIT;
import Model.ProjectList;
import parser.*;
import java.sql.Time;

import java.io.File;

public class MyXmlParser {

    private String fileName;

    public MyXmlParser (String fileName) {
        this.fileName = fileName;
    }

    public void writeToXml (Object o) throws ParserException {
        XmlJsonParser parser = new XmlJsonParser();
        File file = parser.toXml(o, this.fileName);
    }

}
