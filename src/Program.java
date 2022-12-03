import java.util.Scanner;


public class Program {
    static Data mainDatabase = Data.getInstance();
    static Terminal terminal = new Terminal();
    public static void main(String args[]){   
        //intitialize variables and first users
        generateUsers();
        int choice = -1;
        //allows for user terminal input
        Scanner input = new Scanner(System.in);
        //default first user
        Operator op = new Operator();
        op.setFirstName("Bob");
        op.setLastName("Burton");
        op.setUser("apple");
        op.setPassword("orange");
        mainDatabase.addOperator(op);
        //output welcome and options
        terminal.prompt("Welcome to the ChocAn Software!"); 
        while(choice != 5){
        terminal.prompt("Select an option");
        terminal.prompt("1-Member Sign-in");
        terminal.prompt("2-Provider Sign-in");
        terminal.prompt("3-Operator Sign-in");
        terminal.prompt("4-Manager Sign-in");
        terminal.prompt("5-Exit");
        choice = terminal.inputInt();
        //choose the proper stuffs
        String name;
        switch(choice){
            case 1: //member
                Member member;
                terminal.prompt("Member Selected!");
                terminal.prompt("Enter your full name:");
                name = terminal.inputString();
                member = mainDatabase.findMember(name);
                if(member != null && member.getStatus()){
                    mainDatabase.findMember(name).enterMemberTerminal();
                } else if(!member.getStatus()){
                    terminal.prompt("Suspended Account!");
                } else{   
                    terminal.prompt(name + " not found!");
                }
                break;
            case 2: //provider
                Provider provider;
                terminal.prompt("Provider Selected!");
                terminal.prompt("Enter your full name:");
                name = terminal.inputString();
                provider = mainDatabase.findProvider(name);
                if(provider != null && provider.getStatus()){
                    mainDatabase.findProvider(name).enterProviderTerminal();
                }else if(!provider.getStatus()){
                    terminal.prompt("Suspended Account!");
                } else {
                    terminal.prompt(name + " not found!");
                }
                break;
            case 3: //operator
                Operator operator;
                terminal.prompt("Operator Selected!");
                terminal.prompt("Enter your full name:");
                name = terminal.inputString();
                operator = mainDatabase.findOperator(name);
                if(name != null && operator != null && operator.getStatus()){
                    operator.enterOperatorTerminal();
                }  else if(!operator.getStatus()){
                    terminal.prompt("Suspended Account!");
                } else {
                    terminal.prompt(name + " not found!");
                }
                break;
            case 4: //manager
                Manager manager;
                terminal.prompt("Manager Selected!");
                terminal.prompt("Enter your full name:");
                name = terminal.inputString();
                manager  = mainDatabase.findManager(name);
                if(manager != null && manager.getStatus()){
                    mainDatabase.findManager(name).enterManagerTerminal();
                }  else if(!manager.getStatus()){
                    terminal.prompt("Suspended Account!");
                } else {
                    terminal.prompt(name + " not found!");
                }
                break;
            case 5:
                break;
            default:
                terminal.prompt("Invalid input, please select 1-4!");
                break;
            }
        }
      input.close();
    }
    //generates initial users
    public static void generateUsers(){
        Member member = new Member();
        Provider provider = new Provider();
        Manager manager = new Manager();
        Operator operator = new Operator();
        Service service = new Service();

        member.setFirstName("Nick");
        member.setLastName("Warren");

        member.setUser("apple");
        member.setPassword("orange");

        provider.setFirstName("Landon");
        provider.setLastName("Bostic");

        provider.setUser("banana");
        provider.setPassword("orange");

        manager.setFirstName("Wilson");
        manager.setLastName("King");

        manager.setUser("plum");
        manager.setPassword("pear");

        operator.setFirstName("Nate");
        operator.setLastName("Paul");

        operator.setUser("cherry");
        operator.setPassword("tomato");

        service.setCode(123);
        service.setName("Knee Surgery");
        service.setPrice(10000);

        mainDatabase.addService(service);
        mainDatabase.addMember(member);
        mainDatabase.addManager(manager);
        mainDatabase.addOperator(operator);
        mainDatabase.addProvider(provider);
    }
}


