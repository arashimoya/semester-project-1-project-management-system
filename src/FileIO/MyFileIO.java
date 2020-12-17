package FileIO;

import java.io.*;
import java.util.ArrayList;

import Model.ProjectList;
import parser.*;

/**
 * class to save data to a binary file
 * @author Tymon
 */
public class MyFileIO {
    String fileName;

    /**
     * one argument constructor specifying the filename where the binary data should be saved
     * @param fileName the filename of the data
     */
    public MyFileIO(String fileName) {
        this.fileName = fileName;
    }

    /**
     * for saving object to a binary file
     * @param obj the object to be saved
     * @throws FileNotFoundException if the file was not found or could not be created
     * @throws IOException if the operation failed
     */
    public void writeToFile(Object obj) throws FileNotFoundException, IOException {
        ObjectOutputStream write = null;
        try {
            FileOutputStream out = new FileOutputStream(fileName);
            write = new ObjectOutputStream(out);
            write.writeObject(obj);
        } finally {
            if (write != null) {
                try {
                    write.close();
                } catch (IOException e) {
                    System.out.println("IO Error closing file " + fileName);
                }
            }
        }
    }

    /**
     * for loading object from file
     * @return the read object
     * @throws ClassNotFoundException if class could not been foud
     * @throws FileNotFoundException if the specified file was not found
     * @throws IOException if the operation failed
     */
    public Object readFromFile() throws ClassNotFoundException, FileNotFoundException, IOException {
        Object obj = null;
        ObjectInputStream readFromFile = null;
        try {
            FileInputStream fileInStream = new FileInputStream(fileName);
            readFromFile = new ObjectInputStream(fileInStream);
            try {
                obj = readFromFile.readObject();
            } catch (EOFException eof) {
                //Done reading
            }
        } finally {
            if (readFromFile != null) {
                try {
                    readFromFile.close();
                } catch (IOException e) {
                    System.out.println("IO Error closing file " + fileName);
                }
            }
        }

        return obj;
    }

}
