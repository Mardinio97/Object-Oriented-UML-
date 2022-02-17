package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * The type File handler.
 */
public class FileHandler {


    /**
     * Instantiates a new File handler.
     */
    public FileHandler() {

    }


    /**
     * Write to file.
     *
     * @param string the string
     * @throws FileNotFoundException the file not found exception
     */
    public void writeToFile(String string) throws FileNotFoundException {

        File file = new File("output.txt");
        FileOutputStream fo = new FileOutputStream(file, true);
        PrintWriter pw = new PrintWriter(fo);
        pw.println(string);
        pw.close();
        pw.flush();

    }

    /**
     * Write to file user.
     *
     * @param string the string
     * @throws FileNotFoundException the file not found exception
     */
    public void writeToFileUser(String string) throws FileNotFoundException {

        File file = new File("user.txt");
        FileOutputStream fo = new FileOutputStream(file, true);
        PrintWriter pw = new PrintWriter(fo);
        pw.println(string);
        pw.close();
        pw.flush();

    }

    /**
     * File reader string.
     *
     * @return the string
     */
    public String fileReader() {
        String data = "";
        try {
            File myObj = new File("output.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + System.getProperty("line.separator");


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;


    }

    /**
     * File reader user string.
     *
     * @return the string
     */
    public String fileReaderUser() {
        String data = "";
        try {
            File myObj = new File("user.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + System.getProperty("line.separator");


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;


    }
}