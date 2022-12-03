/*
 * Authors Nicholas Warren, Nate Paul
 * 
 * Holds Service information
 */



public class Service{
    private String serviceName;
    private String comments;
    private int serviceCode;
    private int servicePrice;
    private String serviceDate;
    private String serviceTime;
    private Provider provider;
    private Person recipient; 
    

    public void setName(String S){
        serviceName = S;
    }
    public void setCode(int c){
        serviceCode = c;
    }
    public void setPrice(int p){
        servicePrice = p;
    }
    public void setServiceDate(String d){
        serviceDate = d;
    }
    public void setServiceTime(String t) {
        serviceTime = t;
    }
    public void setProvider(Provider p){
        provider = p;
    }
    public void setRecipient(Member p){
        recipient = p;
    }
    public void setComment(String c){
        comments = c;
    }
    public String toString(){
        String string;
        string = this.serviceName + " " + this.serviceCode + " " + this.servicePrice;
        return string;
    }
    public String getServiceName(){
        return serviceName;
    }
    public int getServiceCode(){
        return serviceCode;
    }
    public int getServicePrice(){
        return servicePrice;
    }
    public String getServiceDate(){
        return serviceDate;
    }
    public String getServiceTime(){
        return serviceTime;
    }
    public Person getProvider(){
        return provider;
    }
    public Person getRecipient(){
        return recipient;
    }
    public String getComments(){
        return comments;
    }
}