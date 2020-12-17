package FileIO;

import Model.ColourIT;
import Model.ProjectList;
import parser.*;
import java.sql.Time;

import java.io.File;

/**
 * class for parsing data to an xml file
 * @author Adam
 */
public class MyXmlParser {

    private String fileName;

    /**
     * one argument constructor specifying the file name for the XML data
     * @param fileName the filename where the data will be saved
     */
    public MyXmlParser (String fileName) {
        this.fileName = fileName;
    }

    /**
     * for saving an object to XML
     * @param o the object to be saved
     * @throws ParserException if the operation failed for any reason
     */
    public void writeToXml (Object o) throws ParserException {
        XmlJsonParser parser = new XmlJsonParser();
        File file = parser.toXml(o, this.fileName);
    }

}
