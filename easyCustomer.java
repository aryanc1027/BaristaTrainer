import java.util.Random;
import java.lang.*;

public class easyCustomer extends Customer {
    
    private int randNum;
    private String [] greetings = {"Nice to meet you", "Pleased to meet you", "Hello", "Hi", "This is a nice coffee shop", "Lovely day we are having, nice to meet you"}; 

    public easyCustomer(String name, Boolean regular) {
        super(name,regular);
    }
    public String getEasyGreetings() {
        randNum = (int)(Math.random() * 6);
        return greetings[randNum];
    }
  
    public String getLevel() {
        return "Easy Customer";
    }
    
    public String getResponse(String statement) {
	
	String response = "";
	if (statement.contains(" no ")) {
		
		response = "Why so negative?";
	}
	else if (statement.contains("mother") || statement.contains("father") || statement.contains("sister") || statement.contains("brother") || statement.contains("family")) {
	
		response = "Tell me more about your family.";
	}
    else if ((statement.contains("dog")) || (statement.contains("cat")) || statement.contains("pets"))
    {
      response = "Tell me more about your pets";
    }
    
    else if ((statement.isEmpty() == true))
    {
      response = "Please say something";
    }
    else if ((statement.contains("yes"))) {
      response = "Im glad we agree";
    }
    else if ((statement.contains("talk"))) {
      response = "Sure let me order than we can talk more";
    }
    else if ((statement.contains("beans"))) {
      response = "I have actually never come here before so sure, tell me abou the beans you roast";
    }
    else if (statement.contains("hear") || statement.contains("know")) {
        response = "I heard about this place on yelp and wanted to check it out";
    }
    else if ((statement.contains("how"))) {
        response = "I am doing well, how about you?";
    }
		else
		{
			response = getRandomResponse();
		}
	return response;
	}
    
    private String getRandomResponse() {
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
}
    
    
