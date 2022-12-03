/*Author: Nate Paul
 *
 * A report that is meant for the member
 * 
 */

import java.util.Vector;
import java.io.FileWriter;
import java.io.IOException;

public class MemberReport extends Report{
    private Member member;
    private Vector<Service> pastServices;
    private String date;

    public MemberReport(Member member, Vector<Service> pastServices, String date) {
        this.member = member;
        this.pastServices = pastServices;
        this.date = date;
    }

    public Member getMember() {
        return member;
    }

    public Vector<Service> getPastServices() {
        return pastServices;
    }
    public void writeFile() {
        this.compileReports(member, date);
        try {
            FileWriter myWriter = new FileWriter(member.getFirstName() + member.getLastName() + date + ".txt");
            myWriter.write(member.getFirstName() + " " + member.getLastName() + "\n" + 
                member.getID() + "\n" + member.getAddress() + "\n" + member.getCity()
                + "\n" + member.getState() + "/n" + member.getZipCode() + "\n\n");
            
            for (int i = 0; i < member.servicesRecieved.size(); i++) {
                myWriter.write(pastServices.get(i).getServiceDate() + "\n" + pastServices.get(i).getProvider().getFirstName()
                + " " + pastServices.get(i).getProvider().getLastName() + " " + pastServices.get(i).getServiceName());
            }
            myWriter.close();
        }
        catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}