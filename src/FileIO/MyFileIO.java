package FileIO;

import java.io.*;
import java.util.ArrayList;

import Model.ProjectList;
import parser.*;

public class MyFileIO {
    String fileName;

    public MyFileIO(String fileName) {
        this.fileName = fileName;
    }

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
