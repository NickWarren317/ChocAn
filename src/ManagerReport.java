/*Author: Nate Paul
 *
 * A report that is meant for the manager
 * 
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class ManagerReport extends Report{
    private Vector<Provider> providers;
    private Manager manager;
    private String date;
    private Data database = Data.getInstance();
    
    public ManagerReport(Vector<Provider> providers, Manager manager, String date) {
       this.providers = providers;
       this.manager = manager;
       this.date = date;
    }

    public void writeFile() {
        this.compileReports(manager, date);
        try {
            FileWriter myWriter = new FileWriter(manager.getFirstName() + manager.getLastName() + date + ".txt");
            int grandT = 0;
            int grandC = 0;

            for (int i = 0; i < database.numProviders(); i++) {
                Provider temp = database.getProvider(i);
                grandC += temp.getServicedMembers().size();
                int total = 0;
                myWriter.write("Number of Consults: " + temp.getServicesProvided().size() + 
                "\nFee to be paid: ");
                for (int j = 0; j < temp.getServicesProvided().size(); j++) {
                    total += temp.getServicesProvided().get(j).getServicePrice();
                    grandT += total;
                }
                myWriter.write(total + "\n\n");
            }
            myWriter.write("Total number of Consultations: " + grandC + "/nTotal fee: " + grandT);
            myWriter.close();
        }
        catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}
