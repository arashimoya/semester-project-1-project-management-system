package Model;

import FileIO.MyFileIO;
import FileIO.MyXmlParser;
import Model.ColourIT;
import Model.ProjectList;
import parser.ParserException;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * class for data connection between the model, website and the GUI
 * @author Tymon
 *
 */
public class ColourITFileAdapter {
    MyFileIO mfio;
    MyXmlParser xmlp;
    String fileName;

    /**
     * two argument constructor specifying data file names
     * @param binFileName filename of the saved bin file
     * @param xmlFileName filename of the saved xml file
     */
    public ColourITFileAdapter(String binFileName, String xmlFileName) {
        mfio = new MyFileIO(binFileName);
        xmlp = new MyXmlParser(xmlFileName);
    }

    /**
     * to load colour it object from binary file
     * @return the colour it object
     */
    public ColourIT getColourIt() {
        ColourIT colourIT = null;

        try {
            colourIT = (ColourIT) mfio.readFromFile();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Error reading file");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found");
        }
        return colourIT;
    }

    /**
     * to save colour it object to a binary file
     * @param colourIT the colour it object to be saved
     */
    public void save(ColourIT colourIT) {
        try {
            mfio.writeToFile(colourIT);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Error writing to file");
            e.printStackTrace();
        }
    }

    /**
     * to save an object to an XML file so it can be loaded on a website
     * @param o the object to be saved
     */
    public void saveToXml (Object o) {
        try {
            xmlp.writeToXml(o);
        }
        catch (ParserException e) {
            System.out.println("Error while parsing");
        }
    }


}
