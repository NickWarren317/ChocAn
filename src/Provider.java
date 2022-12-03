/*
 * Author: Nicholas Warren, Nate Paul
 * 
 * 
 * Holds Provider Functionalities
 * 
 */

import java.util.Vector;

public class Provider extends Person{
    private Data database = Data.getInstance();
    
    private DiskRecord diskRecord = DiskRecord.getInstance();

    private Terminal terminal = new Terminal();
    //holds members serviced throughout the week
    private Vector<Member> membersServiced = new Vector<Member>();
    //holds services provided throught the week, indexes correspond to the member
    private Vector<Service> servicesProvided = new Vector<Service>();
    //holds services offered by this provider
    private Vector<Service> availableServices = new Vector<Service>();


    //validates member id card via scan
    boolean validateMemeberID(){
        Member member;
        terminal.prompt("Enter Member Number: ");
        member = scanMemberID(terminal.inputInt());
        if(member == null){
            terminal.prompt("INVALID!");
            return false;
        }
        terminal.prompt("VALIDATED!");
        return true;
    }
    //enters the provider terminal
    void enterProviderTerminal(){
        //attempted passwords
        int numAttempts = 0;
        String userAttempt;
        String passAttempt;
        
        //prompt username and password entry
        terminal.prompt("Welcome " + this.getFirstName() +"!");
        while(numAttempts < 4){
            terminal.prompt("Username: ");
            userAttempt = terminal.inputString();
            terminal.prompt("Password: ");
            passAttempt = terminal.inputString();
            //verify credentials
            if(verifyProvider(userAttempt, passAttempt)) break;
            terminal.prompt("Invalid Credentials! \n You have " +  (3-numAttempts) + " more attempts");
            numAttempts++;
        }
        if(numAttempts > 3) return;
        //open menu
        int selection = -1;
        while(selection != 3){
        terminal.prompt("Please select a function");
        terminal.prompt("1-- Scan MemberID and Record Service");
        terminal.prompt("2-- Request Service Directory");
        terminal.prompt("3-- Exit Terminal");
 
        selection = terminal.inputInt();
        switch (selection){
            case 1: //record service
                if(!validateMemeberID()) break;
                String date = "";
                boolean serviceConfirm = false;
                int serviceCode;
                int confirm = -1;
                int memberCode;
                Member member;
                String comments;
                Service service = null;

                while (serviceConfirm == false) {
                    terminal.prompt("What is the service code?");
                    serviceCode = terminal.inputInt();

                    service = database.findService(serviceCode);
                    if (service == null) {
                        terminal.prompt("That is an invalid service code.");
                        break;
                    }
                    terminal.prompt("What is the date service has been provided? MM-DD-YYYY");
                    service.setServiceDate(terminal.inputString());
                    terminal.prompt(service.getServiceName() + " is the Selected Service");
                    terminal.prompt("To confirm type 1\nTo deny type 0\n To leave type 2");
                    confirm = terminal.inputInt();
                    
                    if (confirm > 2) {
                        terminal.prompt("invalid command");
                    }

                    if (confirm == 1) {
                        serviceConfirm = true;
                    }
                    if(confirm == 0){
                    }
                }

                if (confirm == 2) {
                    break;
                } 

                terminal.prompt("What is the member ID?");
                memberCode = terminal.inputInt();
                member = database.findMemberID(memberCode);
                service.setRecipient(member);
                service.setProvider(this); 
                this.servicesProvided.add(service);
                this.membersServiced.add(member);
                member.addService(service);
                

                terminal.prompt("Any comments? If not type \"No Comment\"");
                comments = terminal.inputString();
                service.setComment(comments);
                this.servicesProvided.add(service);
                diskRecord.diskRec(date, this.getID(), member.getID(), service.getServiceCode(), comments);

                terminal.prompt("Service is logged.");
            
                break;
            case 2:
                terminal.prompt("Available Services:");
                for(int i = 0; i < database.numServices(); i++){
                    terminal.prompt(database.getService(i).toString());
                }
                terminal.prompt("Enter anything to continue");
                terminal.inputString();
                break;
            case 3:
                return;
            default: 
                terminal.prompt("Invalid Input!");
                return;
        }
    }


    }
    //verifies the provider's credentials.
    public boolean verifyProvider(String user, String pass){
        if(user.compareTo(this.getUser()) == 0 && pass.compareTo(this.getPass()) == 0){
            return true;
        }
        return false;
    }
    //adds service and member to list
    void serviceMember(Member m, Service s){
        membersServiced.add(m);
        servicesProvided.add(s);
    }
    void addService(Service s){ //move to operator/manager
        availableServices.add(s);
    }
    //scans and returns member with id
    Member scanMemberID(int id){
        return database.findMemberID(id);
    }
    //used for report compilation
    Vector<Member> getServicedMembers(){
        return membersServiced;
    }
    //used for report compilation
    Vector<Service> getServicesProvided(){
        return servicesProvided;
    }
    //returns the avaible services for the provider
    Vector<Service> requestDirectory(){
        return availableServices;
    }
}
