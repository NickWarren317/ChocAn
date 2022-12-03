import java.util.Vector;

/*Author: Nicholas Warren, Landon Bostic, Annya Evans
 *
 * Manager permissions and methods
 * 
 */
public class Manager extends Person{ 
    private Data database = Data.getInstance();
    private Terminal terminal = new Terminal();
    void billMember(Member member){
        Vector<Service> serviceRecord = member.getServices();
        int num = 0;
        for(int i = 0; i < serviceRecord.size(); i++){
            member.currentBill = member.currentBill + serviceRecord.elementAt(i).getServicePrice();
            num++;
        }
        if(num == 0){
            terminal.prompt("Member has no services to be payed for this week");
        } else {
            terminal.prompt("Member billed!");
        }
        return;
    }
    void enterManagerTerminal(){
        String userAttempt;
        String passAttempt;
        int selection = 0;
        int numAttempts = 0;
        //prompt username and password entry
        terminal.prompt("Welcome" + this.getFirstName());
        while(numAttempts < 4){
            if(numAttempts == 3) return;
            terminal.prompt("Username: ");
            userAttempt = terminal.inputString();
            terminal.prompt("Password: ");
            passAttempt = terminal.inputString();
            //verify credentials
            if(verifyManager(userAttempt, passAttempt)) break;
            terminal.prompt("Invalid Credentials! \n You have " +  (3-numAttempts) + " more attempts");
            numAttempts++;
        }
        if(numAttempts > 3) return;
        //Open Menu
        while(selection != 3){
        terminal.prompt("Select a function:");
        terminal.prompt("1--Bill Members");
        terminal.prompt("2--Generate Report (Manager)");
        terminal.prompt("3--Generate Report (Provider)");
        terminal.prompt("4--Generate Report (Member)");
        terminal.prompt("5--Generate Report (EFT)");
        terminal.prompt("6--Exit");
        selection = terminal.inputInt();

        String name;
        switch(selection){
            case 1:
                terminal.prompt("Enter Member's Full Name");
                name = terminal.inputString();
                Member member = database.findMember(name);
                if(member == null){
                    terminal.prompt(name + " not found!");
                    break;
                }
                billMember(member);
                break;
            case 2:
                terminal.prompt("Enter Member's Full Name");
                name = terminal.inputString();
                Member member1 = database.findMember(name);
                terminal.prompt("Enter Manager's Full Name");
                name = terminal.inputString();

                terminal.prompt("Enter Date");
                
                break;
            case 3:
                
            case 4:
            case 5:
                break;
            case 6:
                return;
            default:
                terminal.prompt("Invalid Input");
        }
      }
    }
    public boolean verifyManager(String user, String pass){
        if(user.compareTo(this.getUser()) == 0 && pass.compareTo(this.getPass()) == 0){
            return true;
        }
        return false;
    }
    void manualMemberReport(){
        //MemberReport.writeFile();
    }
    void manualProviderReport(){
        //ProviderReport.writeFile();
    }
    void manualEFTReport(){
        //DiskRecord.writeFile();
    }
}
