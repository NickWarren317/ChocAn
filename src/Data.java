/*Author: Nicholas Warren
 *
 * Holds all the data
 * 
 */

import java.beans.VetoableChangeListener;
import java.util.Vector;

public class Data{
    //singleton make sure there is only one instance of this class in the JVM.
    private static Data singleton = null;
    Terminal terminal = new Terminal();
    //Vectors of data
    private Vector<Member> servicedMembers = new Vector<Member>(); //members serviced in the week
    private Vector<Member> memberList = new Vector<Member>();
    private Vector<Provider> providerList = new Vector<Provider>();
    private Vector<Operator> operatorList = new Vector<Operator>();
    private Vector<Manager> managerList = new Vector<Manager>();
    private Vector<Service> serviceList = new Vector<Service>();
    //private contructor to ensure only one instance
    private Data(){

    }
    //returns the instance of the Data class
    public static Data getInstance(){
        if(singleton == null){
            singleton = new Data();
        }
        return singleton;
    }
    public void clearSevicedMembers(){
        servicedMembers.clear();
    }
    public boolean checkServicedMembers(){
        return servicedMembers.isEmpty();
    }
    //adds member to database
    public void addMember(Member m){
        memberList.add(m);
    }
    //retrieves member from database
    public Member getMember(int idx){
        return memberList.elementAt(idx);
    }
    public Member getServicedMember(int idx){
        return servicedMembers.elementAt(idx);
    }
    //adds Provider to database
    public void addProvider(Provider p){
        providerList.add(p);
    }
    //retrieves provider from database
    public Provider getProvider(int idx){
        return providerList.elementAt(idx);
    }
    //adds Operator to database
    public void addOperator(Operator o){
        operatorList.add(o);
    }
    //retrieves Operator from database
    public Operator getOperator(int idx){
        return operatorList.elementAt(idx);
    }
    //retrieves Service from database
    public Service getService(int idx){
        return serviceList.elementAt(idx);
    }
    public void addService(Service s){
        serviceList.add(s);
    }
    //adds Manager to database
    public void addManager(Manager m){
        managerList.add(m);
    }
    //adds member to servicedMembers
    public void addServicedMember(Member m){
        servicedMembers.add(m);
    }
    public Member getSevicedMember(int idx){
        return servicedMembers.elementAt(idx);
    }
    //retrieves manager from database
    public Manager getManager(int idx){
        return managerList.elementAt(idx);
    }
    //returns number of Members
    public int numMembers(){
        return memberList.size();
    }
    //returns number of Providers
    public int numProviders(){
        return providerList.size();
    }
    //returns number of Operators
    public int numOperators(){
        return operatorList.size();
    }
    //returns number of Managers 
    public int numManagers(){
        return managerList.size();
    }
    //returns number of Serviced Members for the week
    public int numServiced(){
        return servicedMembers.size();
    }
    //returns number of services in the system
    public int numServices(){
        return serviceList.size();
    }
    //deletes Member from system
    public boolean deleteMember(String name){
        String[] firstlast = name.split(" ");
        String first, last;
        first = firstlast[0];
        last = firstlast[1];
        for(int i = 0; i < memberList.size(); i++){
            if(memberList.elementAt(i).getFirstName().compareTo(first) == 0 && (memberList.elementAt(i).getLastName().compareTo(last) == 0)){
                memberList.removeElementAt(i);
                return true;
            }
        }
        return false;
    }
    //deletes Provider from system
    public boolean deleteProvider(String name){
        String[] firstlast = name.split(" ");
        String first, last;
        first = firstlast[0];
        last = firstlast[1];
        for(int i = 0; i < providerList.size(); i++){
            if(providerList.elementAt(i).getFirstName().compareTo(first) == 0 && (providerList.elementAt(i).getLastName().compareTo(last) == 0)){
                providerList.removeElementAt(i);
                return true;
            }
        }
        return false;
    }
    //deletes manager from system
    public boolean deleteManager(String name){
        String[] firstlast = name.split(" ");
        String first, last;
        first = firstlast[0];
        last = firstlast[1];
        for(int i = 0; i < managerList.size(); i++){
            if(managerList.elementAt(i).getFirstName().compareTo(first) == 0 && (managerList.elementAt(i).getLastName().compareTo(last) == 0)){
                managerList.removeElementAt(i);
                return true;
            }
        }
        return false;
    }
    //deletes operator from system
    public boolean deleteOperator(String name){
        String[] firstlast = name.split(" ");
        String first, last;
        first = firstlast[0];
        last = firstlast[1];
        for(int i = 0; i < operatorList.size(); i++){
            if(operatorList.elementAt(i).getFirstName().compareTo(first) == 0 && (operatorList.elementAt(i).getLastName().compareTo(last) == 0)){
                operatorList.removeElementAt(i);
                return true;
            }
        }
        return false;
    }
    //returns Member with same first and last name. EX. "Bob Burton" as input
    public Member findMember(String name){
        String[] firstlast = name.split(" ");
        String first, last;
        first = firstlast[0];
        last = firstlast[1];
        for(int i = 0; i < memberList.size(); i++){
            if(memberList.elementAt(i).getFirstName().compareTo(first) == 0 && (memberList.elementAt(i).getLastName().compareTo(last) == 0)){
                return memberList.elementAt(i);
            }
        }
        return null;
    }
    //returns Provider with same first and last name. EX. "Bob Burton" as input
    public Provider findProvider(String name){
        String[] firstlast = name.split(" ");
        String first, last;
        first = firstlast[0];
        last = firstlast[1];
        for(int i = 0; i < providerList.size(); i++){
            if(providerList.elementAt(i).getFirstName().compareTo(first) == 0 && (providerList.elementAt(i).getLastName().compareTo(last) == 0)){
                return providerList.elementAt(i);
            }
        }
        return null;
    }
    //returns Operator with same first and last name. EX. "Bob Burton" as input
    public Operator findOperator(String name){
        String[] firstlast = name.split(" ");
        String first, last;
        first = firstlast[0];
        last = firstlast[1];
        for(int i = 0; i < operatorList.size(); i++){
            if(operatorList.elementAt(i).getFirstName().compareTo(first) == 0 && (operatorList.elementAt(i).getLastName().compareTo(last) == 0)){
                return operatorList.elementAt(i);
            }
        }
        return null;
    }
    //returns Manager with same first and last name. EX. "Bob Burton" as input
    public Manager findManager(String name){
        String[] firstlast = name.split(" ");
        String first, last;
        first = firstlast[0];
        last = firstlast[1];
        for(int i = 0; i < managerList.size(); i++){
            if(managerList.elementAt(i).getFirstName().compareTo(first) == 0 && (managerList.elementAt(i).getLastName().compareTo(last) == 0)){
                return managerList.elementAt(i);
            }
        }
        return null;
    }
    //returns service searching by the code
    public Service findService(int code){
        for(int i = 0; i < serviceList.size(); i++){
            if(serviceList.elementAt(i).getServiceCode()  == code){
                return serviceList.elementAt(i);
            }
        }
        return null;
    }
    //returns service searching by the code
    public Member findMemberID(int code){
        for(int i = 0; i < memberList.size(); i++){
            if(memberList.elementAt(i).getID() == code){
                return memberList.elementAt(i);
            }
        }
        return null;
    }
}