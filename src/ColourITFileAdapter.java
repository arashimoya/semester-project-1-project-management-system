import FileIO.MyFileIO;
import Model.ColourIT;
import Model.ProjectList;

import java.io.FileNotFoundException;
import java.io.IOException;

class ColourITFileAdapter {
    MyFileIO mfio;
    String fileName;

    public ColourITFileAdapter(String fileName) {
        mfio = new MyFileIO(fileName);
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
            System.out.println("IO Error writing to file");
        }
    }
}
