package Model;

import FileIO.MyFileIO;
import FileIO.MyXmlParser;
import Model.ColourIT;
import Model.ProjectList;
import parser.ParserException;

import java.io.FileNotFoundException;
import java.io.IOException;


public class ColourITFileAdapter {
    MyFileIO mfio;
    MyXmlParser xmlp;
    String fileName;

    public ColourITFileAdapter(String binFileName, String xmlFileName) {
        mfio = new MyFileIO(binFileName);
        xmlp = new MyXmlParser(xmlFileName);
    }

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

    public void saveToXml (Object o) {
        try {
            xmlp.writeToXml(o);
        }
        catch (ParserException e) {
            System.out.println("Error while parsing");
        }
    }


}
