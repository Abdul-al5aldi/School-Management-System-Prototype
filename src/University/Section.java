package University;

import com.jfoenix.controls.JFXButton;
import java.io.*;
import java.util.*;
import javafx.scene.control.Button;

/**
 * Section class
 * This Class has a section properties to make an objects.
 * 
 * @author Team-3
 */
public class Section {

    String courseName;
    String status;

    private final static File sectionsFile = new File("data/sections.txt");

    private int number;
    private Course course;
    private String CRN;
    private Faculty instructor;
    private ArrayList<Student> students;
    private String location;
    public String instructorID;
    private int maxNumberOfStudents;

    int getTime() {
        return 0;
    }

    public Section(int number, String courseName, String CRN, String instructorID, String location, int max, String status) { // When read from txt file.

        this.number = number;
        this.CRN = CRN;
        this.instructorID = instructorID;
        this.location = location;
        this.maxNumberOfStudents = max;
        this.courseName = courseName;
        this.status = status;

    }

    public Section(String courseName, String location, int max) { // When Adding new Section
        number = 6;
        this.courseName = courseName;
        this.location = location;
        maxNumberOfStudents = max;

        CRN = generateCRN();
        instructorID = "TBA";
        status = "Open";
        try {
            writeToFile();
        } catch (Exception e) {
            System.out.println("Exception at Section constructor.");
        }

    }

    private static String generateCRN() {
        Random r = new Random(System.currentTimeMillis());
        int x = 1000 + r.nextInt(2000);
        return "2" + x + "";
    }

    public int getNumber() {
        return number;
    }

    public void setInstructor(Faculty inst) {
        this.instructor = inst;
    }

    public void setLocation(String loc) {
        this.location = loc;
    }

    public String getLocation() {
        return location;
    }

    public void setStatus(String s) {
        this.status = s;
    }

    public String getStatus() {
        return status;
    }

    public void setMaxNumber(int num) {
        maxNumberOfStudents = num;
    }

    public int getMaxNumber() {
        return maxNumberOfStudents;
    }

    public boolean addStudent(Student stu) {

        students.add(stu);

        if (this.students.size() == this.maxNumberOfStudents) {
            this.status = "Closed";
        }

        return true;
    }

    public boolean removeStudent(Student stu) {

        students.remove(stu);

        if (this.students.size() < this.maxNumberOfStudents) {
            this.status = "Open";
        }

        return true;
    }

    public String getCRN() {
        return CRN;
    }

    private void writeToFile() throws IOException {
        FileWriter fw = new FileWriter(sectionsFile, true);
        PrintWriter out = new PrintWriter(fw);

        out.println(number);
        out.println(courseName);
        out.println(CRN);
        out.println(instructorID);
        out.println(location);
        out.println(maxNumberOfStudents);
        out.println(status);

        out.close();
    }

    public boolean equals(Section s) {
        return (this.CRN.equals(s.CRN));
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructorID() {
        return instructorID;
    }

    public void detInstructorID(String s) {
        instructorID = s;
    }

}
