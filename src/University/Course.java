package University;

import java.util.ArrayList;

/**
 * Course class
 * This Class has a course properties to make an objects.
 * 
 * @author Team-3
 */
public class Course {
	private String name;
	private int numOfSections =0;
	public ArrayList <Section> sections = new ArrayList<>();
	
	
	
    public Course (String Name) {
    	this.name = name;
    	
    }
    
   public Section addSection() {
	   numOfSections++;
	   Section sec = new Section(this.name,"TBA", numOfSections);
	   sections.add(sec);
	   return sec;
   }
   
   public void removeSection (Section sec) {
		   sections.remove(sec);
   }
   public String getName() {
	   return name;
   }
   public int getNumOfSections() {
	   return numOfSections;
   }
}
