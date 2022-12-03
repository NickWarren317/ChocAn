class Person{
    private Data database = Data.getInstance();
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private int ID;
    private String username;
    private String password;
    private boolean status;
    
    Person(){
        ID = (database.numManagers()+database.numMembers()+database.numOperators()+database.numProviders() + 100000000);
        status = true;
    }
    //returns the status of the Person
    public boolean getStatus(){
        return status;
    }
    //sets the status of the person
    public void setStatus(boolean b){
        status = b;
    }
    //returns the first name of the Person
    public String getFirstName(){
        return firstName;
    }
    //returns the last name of the Person
    public String getLastName(){
        return lastName;
    }
    //returns the address of the Person
    public String getAddress(){
        return address;
    }
    //returns the City of the Person
    public String getCity(){
        return city;
    }
    //returns the state of the Person
    public String getState(){
        return state;
    }
    //returns the ZipCode of the Person
    public int getZipCode(){
        return zipCode;
    }
    //returns the ID of the person
    public int getID(){
        return ID;
    }
    //returns the UserName of the Person
    protected String getUser(){
        return username;
    }
    //returns the Password of the Person
    protected String getPass(){
        return password;
    }
    //sets the FirstName of the Person
    void setFirstName(String firstname){
        firstName = firstname;
    }
    //sets the LastName of the Person
    void setLastName(String last){
        lastName = last;
    }
    //sets the Address of the Person
    void setAddress(String add){
        address = add;
    }
    //sets the City of the Person
    void setCity(String c){
        city = c;
    }
    //sets the State of the Person
    void setState(String s){
        state = s;
    }
    //sets the ZipCode of the Person
    void setZipCode(int zip){
        zipCode = zip;
    }
    //Sets the UserName of the Person
    void setUser(String u){
        username = u;
    }
    //sets the Password of the Person
    void setPassword(String p){
        password = p;
    }
}