public class Customer  {
    protected Boolean regular;
    protected String name;
    
    public Customer(String name, Boolean regular) {   //if they have been here before 
        this.regular = regular; this.name = name;
    }
    
    public String getName() {
        return name;
    }
    public String getLevel() {
        return "";
    }
    public String getRegStatus() {
        if (regular == true)
            return "I am a regular";
    return "I am not a regular";
    }
    
    public String toString() {
        return "Name: " + name + "Regular:" + regular;
    }
}