public class Rules {
   private String [] easyRules = {"We open at 6:30", "You need to make sure to ask for a customers name and if they are a regular"};
   private String diffiulty;

    public Rules(String diffiulty) {
        this.diffiulty = diffiulty;
        
    }
    
    public void getAllRules() {
        if(diffiulty.equals("easy")) {
            for(int i = 0; i < easyRules.length; i++) 
                System.out.println(easyRules[i]);
        }
        
        
    }
    public String getRules (int x) {
        if(diffiulty.equals("easy")) {
            return easyRules[x];
        }
        
    else return "The diffiulty you entered was not a valid level";
    
            
    }
        
    
    
    
}