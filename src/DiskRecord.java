/*Author: Landon Bostic
 *
 * EFT report
 * 
 */

import java.util.Vector;
import java.io.FileWriter;
import java.io.IOException;

public class DiskRecord extends Report{
    private static DiskRecord singleton = null;
    
    private DiskRecord() {
       ; 
    }

    public static DiskRecord getInstance(){
        if(singleton == null){
            singleton = new DiskRecord();
        }
        return singleton;
    }

    public void diskRec(String Date, int providerNum, int memberNum, int serviceCode, String comments) {
        ;
    }

    public void writeFile() {
        //attemps to write each members services received for the week
        try {
            Data database = Data.getInstance();
            Vector<Member> memberList = new Vector<Member>();
            for(int i = 0;i<database.numServiced();i++){
            memberList.add(database.getSevicedMember(i));
        }
            FileWriter myWriter = new FileWriter("EFT.txt");
            for (int i = 0; i < memberList.size(); i++) {
                Vector<Service> services = new Vector<Service>();
                services=memberList.elementAt(i).getServices();
                for (int j = 0; j < services.size(); j++){
                    myWriter.write("Provider Name: " + services.elementAt(j).getProvider().getFirstName() + " " + services.elementAt(j).getProvider().getLastName() + " | Provider ID: " 
                    + services.elementAt(j).getProvider().getID() + " | Service Charge: " + services.elementAt(j).getServicePrice() + "\n\n");
                    
                }
            }
            myWriter.close();
        }
        //detects any errors
        catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}
