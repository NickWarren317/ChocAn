/*
 * Author: Nicholas Warren
 * 
 * Holds member data and functions
 * 
 */



import java.util.Vector;


public class Member extends Person{
    public double currentBill = 0;
    Vector<Service> servicesRecieved = new Vector<Service>();
    private Terminal terminal = new Terminal();
    private Data database = Data.getInstance();
    //pays chocAn
    void payChocAn(){
    	double payment;
        while(true){
            terminal.prompt("Your current bill is: $" + currentBill);
            if(currentBill == 0){
                terminal.prompt("You dont owe anything, have a good day!");
                return;
            }
            terminal.prompt("How much would you like to pay?:");
            payment = terminal.inputInt();

            terminal.prompt("Please confirm the payment of " + payment + " dollars (Y/N).");
            String in = terminal.inputString();
            if(in.compareTo("Y") == 0){
                terminal.prompt("Your payment of $" + payment + " is being processed! Have a good day!");
                break;
            } else if(in == "N"){
                terminal.prompt("Would you like to exit or try again?");
                terminal.prompt("1--Retry");
                terminal.prompt("2--Exit");
                int c;
                c = terminal.inputInt();
                if(c == 2){
                    break;
                }
            } else if(in.compareTo("exit") == 0){
                break;
            } else {
                terminal.prompt("Invalid Input try again!");
            }
        }
    }
    //enters the member terminal
    void enterMemberTerminal(){
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
            if(!verifyMember(userAttempt, passAttempt)){
                terminal.prompt("Incorrent Username or Password! \n You have " + (3-numAttempts) + " remaining.");
            } else {
                break;
            }
            numAttempts++;
        }
        if(numAttempts > 3) return;
        terminal.prompt("Signed in!");
        int selection = -1;
        while(selection != 5){
        //prompt options
            terminal.prompt("Select a function");
            terminal.prompt("1--View Bill");
            terminal.prompt("2--Update Username or Password");
            terminal.prompt("3--View service list");
            terminal.prompt("4--View services recieved");
            terminal.prompt("5--Exit");

            selection = terminal.inputInt();

            switch(selection){
                case 1://view bill
                    terminal.prompt("Your current bill is $" + currentBill);
                    terminal.prompt("Enter anything to continue");
                    terminal.inputString();
                    break;
                case 2://update username or password
                    terminal.prompt("Make a Selection:");
                    terminal.prompt("1--Change Username");
                    terminal.prompt("2--Change password");
                    terminal.prompt("3--Return to Menu");
                    int selection2 = terminal.inputInt();
                    switch(selection2){
                        case 1://change username
                            terminal.prompt("Your current Username is: " + this.getUser());
                            terminal.prompt("Enter new username: ");
                            String newUser = terminal.inputString();
                            setUser(newUser);
                            break;
                        case 2://change password
                            terminal.prompt("Your current password is: " + this.getPass());
                            terminal.prompt("Enter new password: ");
                            String newPass = terminal.inputString();
                            setPassword(newPass);
                            break;
                        case 3://exit
                            break;
                        default:
                            terminal.prompt("Invalid Input!");
                            break;
                    }
                    break;
                    
                case 3://view service list
                    terminal.prompt("Available Services");
                    for(int i = 0; i < database.numServices(); i++){
                        terminal.prompt(database.getService(i).toString());
                    }
                    terminal.prompt("Enter anything to return");
                    terminal.inputString();
                    break;
                case 4://view services recieved
                    terminal.prompt("Services Recieved this week:");
                    for(int i = 0; i < servicesRecieved.size(); i++){
                        terminal.prompt(servicesRecieved.elementAt(i).toString() +" "+ servicesRecieved.elementAt(i).getServiceDate());
                    }
                    terminal.prompt("Enter anything to return");
                    terminal.inputString();
                    break;
                case 5://exit

                    break;
                default:
                    terminal.prompt("Invalid Input!");
                    break;
            }
        }
    }
    //verifies member credentials
    boolean verifyMember(String user, String pass){
        if(user.compareTo(this.getUser()) == 0 && pass.compareTo(this.getPass()) == 0){
            return true;
        }
        return false;
    }
    //adds service to member
    public void addService(Service s){
        servicesRecieved.add(s);
    }
    Vector<Service> getServices(){
        return servicesRecieved;
    }
}
