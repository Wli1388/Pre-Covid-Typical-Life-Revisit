import java.util.*;

public class Event{
  private String name;
  private static ArrayList<Event> events = new ArrayList<Event>();
  private static Scanner choice = new Scanner(System.in);
  
  public Event(){
  }
  
  static Event dogPoop = new Event();
  static Event bigMan = new Event();
  static Event homelessPerson = new Event();
  static Event none = new Event();
  
  public static void createEvents(){
    events.add(bigMan);events.add(dogPoop);events.add(homelessPerson);
  }
  
  public static void getEvent(){
    int random = (int)(Math.random()*100);
    Event theEvent = none;
    for(int index = 0; index < events.size(); index++){
      if(index*100/events.size() + 15 > random){
        theEvent = events.get(index);
        events.remove(index);
        break;
      }
    }
    if(theEvent == dogPoop)
      dogPoop();
    if(theEvent == bigMan)
      bigMan();
    if(theEvent == homelessPerson)
      homelessPerson();
  }
  
  public static void none(){}
  
  public static void dogPoop(){
    System.out.println("As you were on your way to your destination, you accidently stepped on dog poop. You are now less hygenic.");
    Need.setHygiene(-10);
    System.out.println();
  }
  
  public static void bigMan(){
    System.out.println("As you were on your way to your destination, you saw a big mean-looking guy coming your way. You...");
    System.out.println("1)Look down on the ground\n2)Look straight ahead\n3)Try to make eye contact");
    String option = choice.next();
    System.out.println();
    if(option.equals("1"))
      System.out.println("You looked down on the ground, afraid of the guy, until you passed each other.");
    else if(option.equals("2")){
      System.out.println("You looked straight ahead, unafraid of the guy, but also not looking for trouble.");
    }
    else if(option.equals("3")){
      System.out.println("You stared at the guy until he notices you staring and stares back until you passed each other. Do you...");
      System.out.println("1)Continue on your Way\n2)Look back");
      String stareMore = choice.next();
      if(option.equals("1"))
        System.out.println("You continued on your way, not knowing why you stared. Perhaps you were bold.");
      else if(option.equals("2"))
        System.out.println("You look back as you were walking and noticed that the guy was looking back as well. You continued to stare at each other until he disappeared in the distance");
    }
    else
      bigMan();
  }
  
  public static void homelessPerson(){
    System.out.println("As you were on your way to your destination, you encountered a homeless person asking for a dollar. You...");
    System.out.println("1)Give them a dollar\n2)Show your Wallet having No Cash(Only Works if you actually have no money)\n3)Refuse to give them a dollar");
    String option = choice.next();
    System.out.println();
    if(option.equals("1")){
      System.out.println("You made a trade offer: \nYou(Homeless Person) receives a dollar\nI(The Player) receive a good feeling");
      System.out.println("The homeless person made a counter offer: \nYou(The Player) receives 10 dollars\nHe receives a sense of appreciation");
      System.out.println("It turns out the homeless person was a youtuber doing a social experiment and you passed therefore getting the 10 dollars.");
      Adventure.setCash(10);
    }
    else if(option.equals("2")){
      if(Adventure.showCash() < 1){
        System.out.println("The homeless person pitied you and gave you 5 dollars");
        Adventure.setCash(5);
      }
      else{
        System.out.println("The homeless person looked confused, seeing your non-empty wallet. They took a dollar out of it and thanked you.");
        Adventure.setCash(-1);
      }
    }
    else if(option.equals("3"))
      System.out.println("The homeless person apologized for taking your time and continued on their way.");
    else
      homelessPerson();
  }

  
}