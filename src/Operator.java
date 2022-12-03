/*
 * Author: Nicholas Warren
 * 
 * Operator functionalities are implemented here
 */
import java.util.Scanner;

public class Operator extends Person {
    Data database = Data.getInstance();
    Scanner input = new Scanner(System.in);
    Terminal terminal = new Terminal();
    
    void enterOperatorTerminal(){
        String userAttempt, passAttempt;
        int numAttempts = 0;
        //prompt for username and password
        terminal.prompt("Welcome " + this.getFirstName() +"!");
        while(numAttempts < 4){
            terminal.prompt("Username: ");
            userAttempt = terminal.inputString();
            terminal.prompt("Password: ");
            passAttempt = terminal.inputString();
            //verify credentials
            if(verifyOperator(userAttempt, passAttempt) && getStatus() == true) break;
            terminal.prompt("Incorrent Username or Password! \n You have " + (3-numAttempts) + " remaining.");
            numAttempts++;
        }
        if(numAttempts > 3) return;
        terminal.prompt("Signed in!");
        int selection = -1;
        //prompt operations
        while(selection != 8){
            terminal.prompt("Select a function:");
            terminal.prompt("1--Manage Members");
            terminal.prompt("2--Manage Providers");
            terminal.prompt("3--Manage Managers");
            terminal.prompt("4--Add Member");
            terminal.prompt("5--Add Provider");
            terminal.prompt("6--Add Manager");
            terminal.prompt("7--Add Serivice");
            terminal.prompt("8--Exit Terminal");
            selection = terminal.inputInt();

        switch(selection){
            case 1: //manage members
                manageMember();
                break;
                
            case 2: //manage providers
                manageProvider();
                break;
            case 3: //manage managers
                manageManager();
                break;
            case 4: //Add Member
                addMember();
                break;
            case 5:
                addProvider();
                break;
            case 6:
                addManager();
                break;
            case 7:
                addService();
                break;
            case 8:
                break;
            default:
                terminal.prompt("Invalid Input");
        }
      }
    }
    private void addService(){
        Service newService = new Service();
        terminal.prompt("Enter Service Name:");
        newService.setName(terminal.inputString());
        terminal.prompt("Enter Service Code:");
        newService.setCode(terminal.inputInt());
        terminal.prompt("Enter Service Price");
        newService.setPrice(terminal.inputInt());
        database.addService(newService);
        terminal.prompt("Service Added!");
    }
    private void manageMember(){
        String name;
        Member member;
        int selection = 0;
        while(selection != 4){
            if(database.numMembers() == 0){
                terminal.prompt("There are no Members!");
                return;
            }
            terminal.prompt("Enter Member's name: ");
            name = terminal.inputString();
            member = database.findMember(name);
            if(member == null){
                terminal.prompt(name + " not found.");
                terminal.prompt("Exiting Back");
                return;
            } 
            terminal.prompt("Select an Operation");
            terminal.prompt("1--Update information");
            terminal.prompt("2--Change Status");
            terminal.prompt("3--Delete " + name + " from System");
            terminal.prompt("4-- return");
            selection = terminal.inputInt();
            if(selection == 4) return;

            switch(selection){
                case 1:
                    updateInfo(member);
                    break;
                case 2:
                    int selection2;
                    terminal.prompt("Enter a selection");
                    terminal.prompt("1--Unsuspend");
                    terminal.prompt("2--Suspend");
                    terminal.prompt("3--Return");
                    selection2 = terminal.inputInt();
                    switch(selection2){
                        case 1:
                            member.setStatus(true);
                            break;
                        case 2:
                            member.setStatus(false);
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 3:
                    //add confirmation
                    deleteMember();
                    terminal.prompt("Member Deleted");
                    break;
            }
        }
    }
    private void manageProvider(){
        if(database.numProviders() == 0){
            terminal.prompt("There are no Providers! Add Some!");
            return;
        }
        String name;
        int selection;
        Provider provider;

        terminal.prompt("Enter Provider's name:");
        name = terminal.inputString();
        provider = database.findProvider(name);
        if(provider == null) {
            terminal.prompt(name + " not found.");
            return;
        }
        boolean exit = false;
        while(!exit){
            terminal.prompt("Select a function");
            terminal.prompt("1--Delete Member");
            terminal.prompt("2--Update " + name + "'s information");
            terminal.prompt("3--Exit to main menu");
            selection = terminal.inputInt();

            switch(selection){
                case 1:
                  terminal.prompt("Enter Provider's Full Name to Confirm deletion of " + name);
                  String name2 = terminal.inputString();
                  if(name.compareTo(name2) == 0){
                       database.deleteProvider(name2);
                      terminal.prompt(name2 + " has been deleted from the System");
                   } else {
                     terminal.prompt("Name not confirmed, exiting to Manage Provider menu");
                   }  
                   break;  
                 case 2:
                  updateInfo(provider);
                  break;
                 case 3:
                     exit = true;
                     break;
                 default:
                    terminal.prompt("Invalid Input, try again!");
          }
      }
    }
    private void manageManager(){
        if(database.numManagers() == 0){
            terminal.prompt("There are no Managers! Add some!");
            return;
        }
        String name;
        int selection;
        Manager manager;
        terminal.prompt("Enter Manager's name:");
        name = terminal.inputString();
        manager = database.findManager(name);
        if(manager == null){
            terminal.prompt(name + " not found.");
            return;
        }
        boolean exit = false;
        while(!exit){
         terminal.prompt("Select a function");
         terminal.prompt("1--Delete Manager");
         terminal.prompt("2--Update " + name + "'s information");
         terminal.prompt("3-- Exit to Main Menu");

         selection = terminal.inputInt();
          switch(selection){
             case 1:
                   terminal.prompt("Enter Manager's Full Name to Confirm deletion of " + name);
                    String name2 = terminal.inputString();
                  if(name.compareTo(name2) == 0){
                        database.deleteManager(name2);
                        terminal.prompt(name2 + " has been deleted from the System");
                  } else {
                     terminal.prompt("Name not confirmed, exiting to Manage Provider menu");
                  }
                  break;
            case 2:
                  updateInfo(manager);
                  break;
            case 3:
                     exit = true;
                     break;
            default:
                    terminal.prompt("Invalid Input, try again!");
            }
        }
    }
    public void updateInfo(Person p){
        int selection = 0;
        while(selection != 5){
            //prompt operations
            terminal.prompt("Select what needs to be changed");
            terminal.prompt("1-- Address");
            terminal.prompt("2-- ZipCode");
            terminal.prompt("3-- City");
            terminal.prompt("4-- State");
            terminal.prompt("5-- Exit back");
        
            selection = terminal.inputInt();
            switch(selection){
                case 1: //updating address
                    terminal.prompt("Current Address is " + p.getAddress());
                    terminal.prompt("Enter new address: ");
                    p.setAddress(terminal.inputString());
                    break;
                case 2: //updating Zipcode
                    terminal.prompt("Current ZipCode is " + p.getAddress());
                    terminal.prompt("Enter new Zipcode: ");
                    p.setZipCode(terminal.inputInt());
                    break;
                case 3: //updating City
                    terminal.prompt("Current City is " + p.getAddress());
                    terminal.prompt("Enter new City: ");
                    p.setCity(terminal.inputString());
                    break;
                case 4: //updating State
                    terminal.prompt("Current State is " + p.getAddress());
                    terminal.prompt("Enter new State: ");
                    p.setState((terminal.inputString()));
                    break;
                case 5: //exit menu
                    break;
                default:
                    terminal.prompt("Invalid input, try again!");
            }
        }
    }
    public void addMember(){
        Member newMember = new Member();
        //prompt for data entry
        terminal.prompt("Enter Member's Firstname:");
        newMember.setFirstName(terminal.inputString());
        terminal.prompt("Enter Member's Lastname:");
        newMember.setLastName(terminal.inputString());
        terminal.prompt("Enter Member's Address:");
        newMember.setAddress(terminal.inputString());
        terminal.prompt("Enter Member's City:");
        newMember.setCity(terminal.inputString());
        terminal.prompt("Enter Member's ZipCode:");
        newMember.setZipCode(terminal.inputInt());
        terminal.prompt("Enter Member's State:");
        newMember.setState(terminal.inputString());
        //set default username/password
        newMember.setUser(newMember.getFirstName() + newMember.getLastName()); //default username, member can change later
        newMember.setPassword(newMember.getCity() + newMember.getState() + newMember.getLastName()); //default password, member can change later
        database.addMember(newMember);
    }
    private void deleteMember(){
        String name;
        Member member;
        terminal.prompt("Enter Member's Full Name");
        name = terminal.inputString();
        member = database.findMember(name);
        if(member != null) {
            database.deleteMember(name);
        } else {
            terminal.prompt(name + "Not found");
            return;
        }
    }
    private void addManager(){
        Manager newMember = new Manager();
        //prompt for data entry
        terminal.prompt("Enter Manager's Firstname:");
        newMember.setFirstName(terminal.inputString());
        terminal.prompt("Enter Manager's Lastname:");
        newMember.setLastName(terminal.inputString());
        terminal.prompt("Enter Manager's Address:");
        newMember.setAddress(terminal.inputString());
        terminal.prompt("Enter Manager's City:");
        newMember.setCity(terminal.inputString());
        terminal.prompt("Enter Manager's ZipCode:");
        newMember.setZipCode(terminal.inputInt());
        terminal.prompt("Enter Manager's State:");
        newMember.setState(terminal.inputString());
        //set default username/password
        newMember.setUser(newMember.getFirstName() + newMember.getLastName()); //default username, member can change later
        newMember.setPassword(newMember.getCity() + newMember.getState() + newMember.getLastName()); //default password, member can change later
        database.addManager(newMember);
    }
    void addProvider(){
        Provider newMember = new Provider();
        //prompt for data entry
        terminal.prompt("Enter Provider's Firstname:");
        newMember.setFirstName(terminal.inputString());
        terminal.prompt("Enter Provider's Lastname:");
        newMember.setLastName(terminal.inputString());
        terminal.prompt("Enter Provider's Address:");
        newMember.setAddress(terminal.inputString());
        terminal.prompt("Enter Provider's City:");
        newMember.setCity(terminal.inputString());
        terminal.prompt("Enter Provider's ZipCode:");
        newMember.setZipCode(terminal.inputInt());
        terminal.prompt("Enter Provider's State:");
        newMember.setState(terminal.inputString());
        //set default username/password
        newMember.setUser(newMember.getFirstName() + newMember.getLastName()); //default username, member can change later
        newMember.setPassword(newMember.getCity() + newMember.getState() + newMember.getLastName()); //default password, member can change later
        database.addProvider(newMember);
    }
    void deleteProvider(){
        
    }
    void updateProvider(){
        
    }
    //verifies the credentials of the operator
    boolean verifyOperator(String user, String pass){
        if(user.compareTo(this.getUser()) == 0 && pass.compareTo(this.getPass()) == 0){
            return true;
        }
        return false;
    }
}
