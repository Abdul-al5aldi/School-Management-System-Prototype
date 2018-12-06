package University;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Faculty class
 * This Class has a faculty properties to make an objects.
 * 
 * @author Team-3
 */
public class Faculty {

    private final static File facultyFile = new File("data/faculty.txt");
    String fullName;

    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String id;
    private String department;
    public ArrayList<Section> classes = new ArrayList<>();

    public Faculty() {
        title = "";
        firstName = "TBA";
        middleName = "";
        lastName = "";
    }

    public Faculty(String name, String ID, String department, ArrayList<Section> classes) { // to add from TXT file.

        this.title = name.substring(0, name.indexOf('.'));

        name = name.substring(name.indexOf('.') + 1, name.length());
        name = name.trim();

        int startSpace = name.indexOf(" ");
        int endSpace = name.lastIndexOf(" ");

        if (startSpace >= 0) {
            firstName = name.substring(0, startSpace);
            if (endSpace > startSpace) {
                middleName = name.substring(startSpace + 1, endSpace);
            }
            lastName = name.substring(endSpace + 1, name.length());
        }

        id = ID;

        this.department = department;

    }

    public Faculty(String name, String id, String department) { // New Faculty Member . . .

        this.title = name.substring(0, name.indexOf('.'));
        name = name.substring(name.indexOf('.') + 1, name.length());
        name = name.trim();

        int startSpace = name.indexOf(" ");
        int endSpace = name.lastIndexOf(" ");

        if (startSpace >= 0) {
            firstName = name.substring(0, startSpace);
            if (endSpace > startSpace) {
                middleName = name.substring(startSpace + 1, endSpace);
            }
            lastName = name.substring(endSpace + 1, name.length());
        }

        this.id = id;
        this.department = department;

        University.faculty.add(this);
        University.number_Of_Faculty++;
        writeToFile();
    }

    public String getID() {
        return this.id;
    }

    private boolean setAsInstructor(Section sec) {
        classes.add(sec);
        return true;
    }

    private boolean removeAsInstructor(Section sec) {
        classes.remove(sec);
        return true;
    }

    public String toString() {
        //return ("Name: " + title + ". " + firstName + " " + middleName + " " + lastName + ", ID: " + id + ", Department: " + department);
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return title + ". " + firstName + " " + middleName + " " + lastName;
    }

    public String getSimpleName() {
        return firstName + " " + lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getId() {
        return id;
    }

    private void writeToFile() {

        try {
            FileWriter fw = new FileWriter(facultyFile, true);
            PrintWriter out = new PrintWriter(fw);

            // write index
            out.println(title + "." + firstName + " " + middleName + " " + lastName);
            out.println(id);
            out.println(department);
            out.println("0");

            // write crns for sections for sections arrayList
            out.close();

        } catch (Exception e) {
            System.out.println("Exception at writeToFile method  - at Faculty class.");
        }
    }

    public boolean equals(Faculty f) {
        return (this.id.equals(f.id));
    }
}
