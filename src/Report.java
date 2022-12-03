/*Author: Nate Paul
 *
 * A general report file
 * 
 */
import java.io.File;
import java.io.IOException;

public class Report{
    protected void compileReports(Person person, String date) {
        try {
            File myObj = new File(person.getFirstName() + person.getLastName() + date + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeFile(Person person, String date) {
        compileReports(person, date);
    }
}