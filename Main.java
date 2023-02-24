import java.util.*;
import java.lang.*;
public class Main
{
private static String empName = "";
private static int easyLives = 5;
private static int hardLives = 3;
private static double sallery = 7.25;
private static String jobTitle = "trainee";

public static void main(String[] args) {    //training simulator where the customers words are predetermined and employee want to train
	Scanner scan = new Scanner(System.in);
	String practiceStart = "";
	String password = " ";
	String imput = " ";
	boolean completedEasy = false;
	boolean completedHard = false; 
    
    System.out.println("Computer: Hope you are doing well... to begin the training session please type in your name ");
    empName = scan.nextLine();
    try {
    System.out.println("Computer: Processing...");
    Thread.sleep(2000);
    }
    catch (InterruptedException e) {
			System.out.println("Thread is interrupted");
	} 
	
    System.out.println("Computer: Since you are just starting off, your wage will be set to $7.25");
    Employee empHolder = new Employee(empName, jobTitle, sallery);
    System.out.println("Computer: Great... now that you are all in the system we will start with your training.");

    //Easy Test
    System.out.println("Computer: In this simulation, you will be opening the shop and greeting customers...");
    System.out.println("This simulation will continue until a day is completed or you loose all your lives."); //regardless, if you end and you lost all your lives, next level wont be activated 
    System.out.println("Please type start to begin...");
    practiceStart = scan.nextLine().toLowerCase();

    while (!practiceStart.equals("start")) {
      System.out.println("Computer: Take as much time as needed...  type start whenever your ready");
      practiceStart = scan.nextLine().toLowerCase();
    }     //checks if user wants to start easy
    if(practiceStart.equals("start")) {
       completedEasy = practiceEasy(); 
    }         //starts easy 
    
    
    if(completedEasy == false) {
    while(completedEasy == false) {
        System.out.println("Computer: Sadly you failed to complete the easy level and are unable to contine. \nComputer: To try the easy level again type easy, otherwise type end to terminate the simulation");
        imput = scan.nextLine().toLowerCase();
        if(imput.contains("easy"))
            completedEasy = practiceEasy();
        else { 
            System.out.println("Game has ended");
            System.exit(0);
        }
    }      
    }  //makes sure they complete the easy level before moving on
    
    
  System.out.println("Computer: Since you completed the easy level it is time to move onto the hard one. \nComputer: Your job title is now shift supervisor and you pay is now $9.25 ");
  jobTitle = "Shift Supervisor"; sallery += 2;
  practiceStart = ""; //reset string to use in another start sequence;    
  System.out.println("Computer: Please type start to begin the hard level");
  practiceStart = scan.nextLine().toLowerCase();
    while (!practiceStart.equals("start")) {
      System.out.println("Computer: Take as much time as needed...  type start whenever your ready");
      practiceStart = scan.nextLine().toLowerCase();
    }   //makes sure user enters start 

    if(practiceStart.equals("start")) {
        completedHard = practiceHard();
    } //Starts Hard 

if(completedHard == false) {
    while(completedHard == false) {
        System.out.println("Computer: Sadly you failed to complete the hard level and are unable to complete the training. \nComputer: To try the hard level again type hard, otherwise type end to terminate the simulation");
        System.out.println("Computer: If you are interrested in retrying the easy level, please type easy");
        imput = scan.nextLine().toLowerCase();
        if(imput.contains("hard"))
            completedEasy = practiceHard();
        else if(imput.contains("easy"))
            practiceEasy();
        else { 
            System.out.println("Game has ended");
            System.exit(0);
        }
    }      
    }  




} //End of main bracket 

//Start of easy methods
public static boolean practiceEasy() {
Employee empEasy = new Employee(empName, jobTitle, sallery);
Scanner scan = new Scanner(System.in);
String greetings, imput, choices;
String custName = "";
int choice; 
Boolean regular = null;
boolean notValid = false;
Rules ruleEasy = new Rules("easy");
Shop easy = new Shop("Simulation easy"); 
easyCustomer john = new easyCustomer(custName, regular);


    if(easyLives > 0) {
        System.out.println("Computer: The time is 6:30 a.m., type 1 to open shop or type 2 if you think it is too early.");
        choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("Computer: Correct choice");
                easy.addPeople();
                easy.changeShop();
                }
            else if (choice == 2) {
                System.out.println("Computer: Incorrect choice, we open at 6:30 am");
                System.out.println("Refer to rule 1: " + ruleEasy.getRules(0));
                easyLives--;
                System.out.println("You have " + easyLives + " lives left");
                easy.addPeople();
                easy.changeShop();
                System.out.println("Since this is the easy level, we will open up for you");
                }
            else if (choice != 2 || choice != 3) {
                System.out.println("Computer: Since you dont know, you will lose a life. ");
                easyLives--;
            }
    System.out.println("Computer: Since we are a small town café we like to greet the customers...");
    System.out.print("Computer: Your task is to greet the customers and ask all the necessay infomation needed. ");
    System.out.println("If you need a refresher on the infomation needed, please type yes, otherwise type no.");
    choices = scan.nextLine();
    choices = scan.nextLine();

        if (choices.equals("yes") || choices.equals("yep")) {
            System.out.println(ruleEasy.getRules(1));
        }
    
    if(easy.hasPer() == true) {
        System.out.println("Computer: Remember what infomation you need to ask for, you only have 8 chances to do so.");
        System.out.print("Computer: For this senario, you will be talking to the customer all by your self. ");
        System.out.println("Type your greetings below to start the conversation...");
        
        greetings = scan.nextLine();
        

        if (greetings.contains("what") || greetings.contains("its too early") || greetings.indexOf("ughhh") > 0) {
            easyLives--;
            System.out.println("Computer: Your greetings were too rude... you have " + easyLives + " lives left");
        }
    System.out.println(john.getEasyGreetings());
    int easySentenceLimit = 7;
    while ((easySentenceLimit > 0)) {
    imput = scan.nextLine(); 
    easySentenceLimit--;
    
    if(imput.contains("name")) {
    System.out.println("Customer: My name is john");    
        custName = "john";
    }
    else if(imput.contains("regular")) {
    System.out.println("Customer: No im not a regular");
        regular = false;
    }
    else  {
    System.out.println(john.getResponse(imput));
    
    }
    if(!custName.isEmpty() && regular != null)
    break;
    
    }
    notValid = empEasy.checkIfValid(easyLives,"Easy");
    if(notValid == true)
        return false;
    
    if((easySentenceLimit <= 0) && (custName.equals(null) || regular == null)) {
        System.out.println("Computer: you didnt ask for all the necessary infomation needed");
        easyLives--;
        System.out.println("Computer: You have " + easyLives + " lives left");
    } 
    else
        System.out.println("Computer: You collected all the necessary infomation");
    notValid = empEasy.checkIfValid(easyLives, "Easy");
    if(notValid == true)
        return false;

    System.out.println("John: Well im ready to order but I don't know what different coffee types are available... can you help?");
    System.out.println("Computer: Your next task is to give infomation about each bean, please match up the correct flavour profiles with the correct beans");
    boolean isflavoursCorrect = connectBeans(john);
    if(isflavoursCorrect == false) {
        return false;
    }
    else {
        empEasy.getBeanFlavours();
    
    
    System.out.println("John: Wow the dark roast sounds wonderful, ill take a grande dark roast, thanks!");
    System.out.println("John: Thank you for the drink, I will make sure to come here again, bye!");
    System.out.println("Computer: Please type a farewell message");
    imput = scan.nextLine();
    notValid = empEasy.checkIfValid(easyLives,"Easy");
    if(notValid == true)
        return false;;
    try {
    System.out.println();
    Thread.sleep(1500);
    }
    catch (InterruptedException e) {
			System.out.println("Thread is interrupted");
    
    }
    
    }
    }
}
if(easyLives < 0) {
System.out.println("Computer: You failed, please try again.");
    return false;
}
System.out.println("Computer: Congratulations you passed the easy level!");
return true;

} // end of public easy 
public static boolean connectBeans(Customer e) {
    Scanner scan = new Scanner(System.in);
 String answer = ""; boolean notValid = false;
 boolean darkAnswer = false;
 boolean mediumAnswer = false;
 boolean lightAnswer = false; 
 boolean blondeAnswer = false;
    String [] beans = {"dark", "medium", "light", "blonde"};
    String [] flavourNotes = {"bold and deep", "smooth frutty and nutty notes", "mellow and light", "smooth with hints of caramel"};
    String [][] connections = new String[4][2];
    Employee emp = new Employee(empName, jobTitle, sallery);
    System.out.println("Computer: What flavour notes come from dark beans? ");
    answer = scan.nextLine().toLowerCase();
    while(darkAnswer == false) {
    if(answer.contains("bold") || answer.contains("deep") || answer.equals(flavourNotes[0])) {
        System.out.println("Computer: Correct Answer...");
        connections[0][0] = beans[0];
        connections[0][1] = flavourNotes[0];
        darkAnswer = true;
    }
    else if(answer.equals("")) {
        System.out.println("Computer: Please enter something");
        answer = scan.nextLine().toLowerCase();
    }
    else {
        System.out.println("Computer: Incorect Answer... Try again");
        if(e.getLevel().contains("Easy")) {
        easyLives--;
        notValid = emp.checkIfValid(easyLives, "Easy");
            if(notValid == true)
                return false;
        }
        if(e.getLevel().contains("Hard")) {
            hardLives--;
            notValid = emp.checkIfValid(hardLives, "Hard");
            if(notValid == true)
                return false;
            
        }
        answer = scan.nextLine().toLowerCase();
    }
    }
    System.out.println("Computer: Great... now what flavour notes come from medium roast beans? ");
    answer = scan.nextLine().toLowerCase();
    while(mediumAnswer == false) {
    if(answer.contains("frutty") || answer.contains("nutty") || answer.contains("smooth") || answer.equals(flavourNotes[1])) {
        System.out.println("Computer: Correct Answer...");
        connections[1][0] = beans[1];
        connections[1][1] = flavourNotes[1];
        mediumAnswer = true;
    }
    else if(answer.equals("")) {
        System.out.println("Computer: Please enter something");
        answer = scan.nextLine().toLowerCase();
    }
    else {
        System.out.println("Computer: Incorect Answer... Try again");
        if(e.getLevel().contains("Easy")) {
        easyLives--;
        notValid = emp.checkIfValid(easyLives, "Easy");
            if(notValid == true)
                return false;
        }
        if(e.getLevel().contains("Hard")) {
            hardLives--;
            notValid = emp.checkIfValid(hardLives, "Hard");
            if(notValid == true)
                return false;
            
        }
        answer = scan.nextLine().toLowerCase();
    }
    }
    System.out.println("Computer: Great... now what flavour notes come from light roast beans? ");
    answer = scan.nextLine().toLowerCase();
    while(lightAnswer == false) {
    if(answer.contains("mellow") || answer.contains("light") || answer.equals(flavourNotes[2])) {
        System.out.println("Computer: Correct Answer...");
        connections[2][0] = beans[2];
        connections[2][1] = flavourNotes[2];
        lightAnswer = true;
    }
    else if(answer.equals("")) {
        System.out.println("Computer: Please enter something");
        answer = scan.nextLine().toLowerCase();
    }
    else {
        System.out.println("Computer: Incorect Answer... Try again");
        if(e.getLevel().contains("Easy")) {
        easyLives--;
        notValid = emp.checkIfValid(easyLives, "Easy");
            if(notValid == true)
                return false;
        }
        if(e.getLevel().contains("Hard")) {
            hardLives--;
            notValid = emp.checkIfValid(hardLives, "Hard");
            if(notValid == true)
                return false;
            
        }
        answer = scan.nextLine().toLowerCase();
    }
    }
    System.out.println("Computer: Great... now what flavour notes come from blonde roast beans? ");
    answer = scan.nextLine().toLowerCase();
    while(blondeAnswer == false) {
    if(answer.contains("smooth") || answer.contains("caramel") || answer.equals(flavourNotes[3])) {
        System.out.println("Computer: Correct Answer...");
        connections[3][0] = beans[3];
        connections[3][1] = flavourNotes[3];
        blondeAnswer = true;

    }
    else if(answer.equals("")) {
        System.out.println("Computer: Please enter something");
        answer = scan.nextLine().toLowerCase();
    }
    else {
        System.out.println("Computer: Incorect Answer... Try again");
        if(e.getLevel().contains("Easy")) {
        easyLives--;
        notValid = emp.checkIfValid(easyLives, "Easy");
            if(notValid == true)
                return false;
        }
        if(e.getLevel().contains("Hard")) {
            hardLives--;
            notValid = emp.checkIfValid(hardLives, "Hard");
            if(notValid == true)
                return false;
            
        }
        answer = scan.nextLine().toLowerCase();
    }
    }
    
return true;
} //end of Connect Beans 
//End of easy methods

//Start of hard methods
public static boolean practiceHard() {
Employee empHard = new Employee(empName, jobTitle, sallery);
Scanner scan = new Scanner(System.in);
String greetings, imput, choices;
ArrayList<String> givenDrinks = new ArrayList<String>();
ArrayList<String> orderdDrinks = new ArrayList<String>();
String testMenu = "";
String orderDrink; 
int choice, customerAmount;
int menuKnowledge = 0;
int hardSentenceLimit = 0;
boolean notValid = false;
boolean name = false;
boolean isRegular = false;
Rules ruleHard = new Rules("hard");
Shop hard = new Shop("Simulation hard"); 
ArrayList<hardCustomer> currentCustomers = new ArrayList<hardCustomer>();

System.out.println("Computer: Welcome to the hard simulation");
System.out.println("Computer: The amount of customers in this simulation will be randomly decided");
customerAmount = (int)((Math.random() * 3) + 3);
for(int x = 0; x < customerAmount; x++) {
  if(x == 0) {
      hardCustomer cust0;
      cust0 = getRandomHardCustomer();
      currentCustomers.add(cust0);
  }
  else if(x == 1) {
      hardCustomer cust1;
      cust1 = getRandomHardCustomer();
      currentCustomers.add(cust1);
  }
  else if(x == 2) {
      hardCustomer cust2;
      cust2 = getRandomHardCustomer();
      currentCustomers.add(cust2);
  }
  else if(x == 3) {
      hardCustomer cust3;
      cust3 = getRandomHardCustomer();
      currentCustomers.add(cust3);
  }
  else if(x == 4) {
      hardCustomer cust4;
      cust4 = getRandomHardCustomer();
      currentCustomers.add(cust4);
  }
  
}
System.out.println("Computer: Your current Customers are ");

for(int x = 0; x < currentCustomers.size(); x++) {
System.out.print(currentCustomers.get(x).getHardCustomerInfo());
}
System.out.println("Computer: In this simulation you will be working with " + currentCustomers.size() + " customers of varying difficulity"); 
System.out.println("Conputer: The simulation will begin now, please welcome all the customers \t Remember to not be rude and to get all necessary infomation");


for(int j = 0; j < currentCustomers.size(); j++) {
    System.out.println("Computer: Please greet customer " + (j + 1) ); 
greetings = scan.nextLine();
System.out.println("Customer " + (j + 1) + ": "  + currentCustomers.get(j).getHardGreetings());   
hardSentenceLimit = 0;

while(hardSentenceLimit < 4) {
    
    imput = scan.nextLine().toLowerCase(); 
    if(imput.contains("regular") || imput.contains("usual")) {
        if(name == false)
        System.out.println("Customer " + (j + 1) +": " + currentCustomers.get(j).getRegStatus());
        if(name == true)
        System.out.println(currentCustomers.get(j).getActName() + ": " + currentCustomers.get(j).getRegStatus());
        
        isRegular = true;
    }
    else if(imput.contains("name")) {
        System.out.println(currentCustomers.get(j).getActName() + ": " + currentCustomers.get(j).getName()); 
        name = true;
    }
    else 
        if(name == false)
        System.out.println("Customer " + (j + 1) +": " + currentCustomers.get(j).getRandomResponse());
        if(name == true)
        System.out.println(currentCustomers.get(j).getActName() + ": " + currentCustomers.get(j).getRandomResponse());

    
    if (imput.contains("wrong") || imput.contains("its too early") || imput.contains("ughhh") || imput.contains("wow")) {
            hardLives--;
            System.out.println("Computer: Your greetings were too rude... you have " + hardLives + " lives left");
        notValid = empHard.checkIfValid(hardLives, "Hard");
        if(notValid == true)
         return false;
        }
    
    if(name == true && isRegular == true)
        break;
    hardSentenceLimit++;
}
if(name != true || isRegular != true) {
    System.out.println("Computer: You didn't get all the necessary infomation from the customer");
    hardLives--;
    System.out.println("Computer: You have " + hardLives + " lives left");
    notValid = empHard.checkIfValid(hardLives, "Hard");
        if(notValid == true)
         return false;
    
}
name = false; isRegular = false;
}

System.out.println("Computer: Now that you have everyones name and status, tell them the daily menu and collect their orders\nComputer: You have to name at least three items on the menu if asked, type done when you are finished telling the customer the menu \n   Computer: If you need a refresher please type \"menu\" otherwise type continue");
System.out.println("Computer: When typing the menu, please only type one drink per line");
hard.createMenu();
imput = scan.nextLine().toLowerCase();
if(imput.contains("menu"))
    System.out.println("Today's Menu:\n" + hard.getMenu());  

System.out.println("Computer: Please ask the customer's what they want to drink and make sure you remeber their orders");
for(int g = 0; g < currentCustomers.size(); g++) {
if(g != 0)
    System.out.println("Computer: Please ask the next customer what they want");

imput = scan.nextLine().toLowerCase();
testMenu = currentCustomers.get(g).getOrder();
menuKnowledge = 0;
System.out.println(currentCustomers.get(g).getActName() + ": " + testMenu);
if(testMenu.contains("Affogato"))
    orderdDrinks.add("affogato");
else if(testMenu.contains("vanilla"))
    orderdDrinks.add("caffè latte");
else if(testMenu.contains("Americano"))
    orderdDrinks.add("americano");
    
if(testMenu.contains("menu")) {
imput = scan.nextLine().toLowerCase();
while(!imput.equals("done")) {
        if(imput.contains("affogato") ||imput.contains("americano") || imput.contains("caffe latte") || imput.contains("caffè latte") || imput.contains("caffe mocha") || imput.contains("cafè mocha") || imput.contains("cappuccino") || imput.contains("doppio")) {
            menuKnowledge++;
            givenDrinks.add(imput);
        }
        else if(!(imput.contains("affogato") ||imput.contains("americano") || imput.contains("caffe latte") || imput.contains("caffè latte") || imput.contains("caffe mocha") || imput.contains("cafè mocha") || imput.contains("cappuccino") || imput.contains("doppio"))) {
            hardLives--;
            System.out.println("Computer: That drink was not on the menu \n\t You have " + hardLives + " lives left");
            notValid = empHard.checkIfValid(hardLives, "Hard");
            if(notValid == true)
                return false;
          
        }
    imput = scan.nextLine();    

    }
    if(menuKnowledge < 3) {
    hardLives--;
    System.out.println("Computer: You didn't know enough drinks and lost a life");

    if(hardLives > 0)
    System.out.println("Computer: You have " + hardLives + " lives left");
    if(hardLives <= 0) {
    notValid = empHard.checkIfValid(hardLives, "Hard");
    if(notValid == true)
        return false;
    }
    

    }
orderDrink = currentCustomers.get(g).getRandomDrink(givenDrinks);
System.out.println(currentCustomers.get(g).getActName() + ": Ill take a " + orderDrink);
orderdDrinks.add(g, orderDrink);


}


}
System.out.println("Computer: Next you need to accomplish is to match up the drink orders with the people that ordered them");
for(int x = 0; x < currentCustomers.size(); x++) {
System.out.println("Computer: What is " + currentCustomers.get(x).getActName() + "'s drink order?");
imput = scan.nextLine().toLowerCase(); 
if(imput.contains(orderdDrinks.get(x)))
    System.out.println("Computer: Correct");
else if (!imput.contains(orderdDrinks.get(x))) {
    System.out.println("Computer: That is incorrect, the correct answer is " + orderdDrinks.get(x));
    hardLives--;
    
    
System.out.println("Computer: Your last task will be a recap from the previous level, please match the beans with their flavour profiles");
boolean isflavoursCorrect = connectBeans(currentCustomers.get(0));
    if(isflavoursCorrect == false) {
        return false;
    }
    else {
        empHard.getBeanFlavours();
    }
    if(hardLives > 0)
    System.out.println("Computer: You have " + hardLives + " lives left");
    if(hardLives <= 0) {
    notValid = empHard.checkIfValid(hardLives, "Hard");
    if(notValid == true)
        return false;
    }
    
}
}


if(hardLives <= 0)
return false;
return true; 

} //End of class Practice hard
public static hardCustomer getRandomHardCustomer() {
    String [] names = {"Karen", "Olivia", "Emma", "Ava", "Sohpia", "Liam", "Noah", "Oliver", "Elijah", "Charlie"};
    String [] difficulity = {"Easy", "Medium", "Hard"};
    boolean isReg = false;
    Random rand = new Random();
    int regulars = rand.nextInt(2);
    int nameChoice = rand.nextInt(9);
    int difficulityChoice = rand.nextInt(3);
    if (regulars == 0)
        isReg = false;
    else if (regulars == 1) 
        isReg = true;
    hardCustomer cust = new hardCustomer(names[nameChoice], isReg, difficulity[difficulityChoice]);
    return cust;
    
     
} //End of getHardCustomer
//End of hard methods 


} //End of class main 
	
	



	

