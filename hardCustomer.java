import java.util.ArrayList;
public class hardCustomer extends Customer {
    
    private String difficulity;
    private int randNum;
    private String [] easyGreetings = {"Thanks for welcoming me ", "Nice to meet you", "Hi", "Im ready to order", "I can't wait to get my coffee", "Wow this place looks nice!"}; 
    private String [] medGreetings = {"Hey", "Hopefully this place is better than last time", "Just give me coffee","I need coffee before I can be nice", "Are you new?", "Can I have someone else?" }; 
    private String [] hardGreetings = {"So far this place sucks", "coffee...now", "Get me a coffee", "Waiter... come here","Get me a different waiter", "I demand a dicount" }; 

    
    public hardCustomer(String name, boolean regular, String difficulity) {
        super(name, regular);
        this.difficulity = difficulity;        
    }
    
    public String getHardGreetings() {
        randNum = (int)(Math.random() * 6);
        if(difficulity.equals("Hard")) 
            return hardGreetings[randNum];
        
        else if(difficulity.equals("Medium")) {
            return medGreetings[randNum];
        }
        return easyGreetings[randNum];
    }
    
    public String getLevel() {
        return "Hard Level Customer";
    }
    public String getHardCustomerInfo() {
            return "Name: " + name + "\t Difficulity: " + difficulity + "\n";
       
    }
    public String getRegStatus() {
        if(difficulity.equals("Hard")) {
            if(regular == true) 
            return "How do you not know that I am a regular, you must be new.";
        }
        else if(difficulity.equals("Medium")) {
            if(regular == true)
                return "I come here almost every day so of course I am a regular";
        }
        else if(difficulity.equals("Easy")) {
            if(regular == true)
                return "Yes I am a regular";
        }
    return "No I am not a regular";
    }
    
    public String getActName() {
        return name; 
    }
    public String getName() {
    if(difficulity.equals("Hard"))
        return "Wow, how do you not know that my name is " + name + ". You must be really incompetent";
    
        return "My name is " + name; 
    }

    public String getRandomResponse() {
    String response;
        if(difficulity.equals("Hard")) {
            response = getRandomHardResponse();
            return response;
        }
        response = getRandomNormResponse();
        return response;
    }
    private String getRandomNormResponse() {
		int chooseResponse = (int)(Math.random() * 6);
		String response = "";
		
		if (chooseResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (chooseResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (chooseResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (chooseResponse == 3)
		{
			response = "You don't say.";
		}
    else if (chooseResponse == 4) {
      response = "Wow";
    }
    else if (chooseResponse == 5) {
      response = "That is interesting";
    }

		return response;
	}
	private String getRandomHardResponse() {
	    int chooseResponse = (int)(Math.random() * 6);
		String response = "";
		
		if (chooseResponse == 0)
		{
			response = "Useless";
		}
		else if (chooseResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (chooseResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (chooseResponse == 3)
		{
			response = "You are irritating";
		}
    else if (chooseResponse == 4) {
      response = "Wow, you must not know what you are doing";
    }
    else if (chooseResponse == 5) {
      response = "Just give me my coffee";
    }

		return response;
	
	}
	
	
	public String getOrder() {
	    if (difficulity.equals("Hard")) {
	        if(regular == false)
	            return "Well what is on the menu?";
	       return "How do you not know my order, it is a Caffè Latte with 2 shots of vanilla and skim milk";
	    }
	    if(difficulity.equals("Medium")) {
	        if(regular == false)
	            return "What is on the menu?";
	   return "Im a regular so you should know my order... It is a Affogato";
	        
	    }
	    if(difficulity.equals("Easy")) {
	       if(regular == false) 
	            return "Could you please tell me what is on the menu?";
	   return "My go to drink is Americano";
	    }
	   
	return "Not a valid difficulity";
	}
    public String getRandomDrink(ArrayList<String> array)  {
        int randomNum = (int)(Math.random() * array.size());
        return array.get(randomNum);
    }


}