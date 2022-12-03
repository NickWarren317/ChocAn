/*Author: Nate Paul
 *
 * A report that is meant for the provider
 * 
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class ProviderReport extends Report{
    private Provider provider;
    private Vector<Service> pastServices;
    private String date;
    private int totalConsults;
    private int totalFee = 0;

    public ProviderReport(Provider provider, Vector<Service> pastServices, String date) {
        this.provider = provider;
        this.pastServices = pastServices;
        this.date = date;
        totalConsults = pastServices.size();

        for (int i = 0; i < pastServices.size(); i++) {
            totalFee += pastServices.get(i).getServicePrice();
        }
    }

    public Provider getProvider() {
        return provider;
    }

    public Vector<Service> getPastServices() {
        return pastServices;
    }
    
    public int getTotalConsults() {
        return totalConsults;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void writeFile() {
        this.compileReports(provider, date);
        try {
            FileWriter myWriter = new FileWriter(provider.getFirstName() + provider.getLastName() + date + ".txt");
            myWriter.write(provider.getFirstName() + " " + provider.getLastName() + "\n" + 
                provider.getID() + "\n" + provider.getAddress() + "\n" + provider.getCity()
                + "\n" + provider.getState() + "/n" + provider.getZipCode() + "\n\n");
            
            for (int i = 0; i < totalConsults; i++) {
                myWriter.write(pastServices.get(i).getServiceDate() + "\n" + pastServices.get(i).getServiceTime() +
                "\n" + pastServices.get(i).getRecipient().getFirstName() + " " + 
                pastServices.get(i).getRecipient().getLastName() + "\n" +
                pastServices.get(i).getRecipient().getID() + "\n" + pastServices.get(i).getServiceCode() + "\n"
                + pastServices.get(i).getServicePrice() + "\n\n");
            }
            myWriter.write("Total number of Consultations: " + totalConsults + "/nTotal fee: " + totalFee);
            myWriter.close();
        }
        catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}

//is provider ID same as provider number???
//I think so