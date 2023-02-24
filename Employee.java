public class Employee {
    private String job;
    private double sallery;
    private String name;
    
    public Employee(String name, String job, double sallery){
        this.job = job;   this.sallery = sallery; this.name = name;
        
    }
    
    public String getName() {
        return name;
    }
    
    public void openShop() {
        System.out.println("Shop is now open");
    }
    
   public boolean checkIfValid(int lives, String difficulity) {
   if(lives <= 0) {
      if(difficulity.equals("Hard")) {
       System.out.println("Computer: You have failed the hard practice");
       return true;
      }
      else if(difficulity.equals("Easy")) {
          System.out.println("Computer: You have failed the easy practice");
      }
   }
   return false;
   }
    
   public void getBeanFlavours() {
    String [] beans = {"dark", "medium", "light", "blonde"};
    String [] flavourNotes = {"bold and deep", "smooth frutty and nutty notes", "mellow and light", "smooth with hints of caramel"};
    String [][] connections = new String[4][2];
    
    connections[0][0] = beans[0];
    connections[0][1] = flavourNotes[0];
    connections[1][0] = beans[1];
    connections[1][1] = flavourNotes[1];  
    connections[2][0] = beans[2];
    connections[2][1] = flavourNotes[2];
    connections[3][0] = beans[3];
    connections[3][1] = flavourNotes[3];
    System.out.println("The main flavours we offer are...");
    for(int k = 0; k < connections.length - 1; k++) 
        for(int i = 0; i < connections[0].length - 1; i++)
            System.out.println("A " + connections[k][i] + " roast which is " + connections[k+1][i+1] + ",");
   }
    
    
    
    
}