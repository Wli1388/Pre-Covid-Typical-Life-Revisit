import java.util.*;

public class Adventure{
  private static int cash = 5;
  private static int totalMinutes = 420;
  private static boolean afternoon = false;
  private static Scanner choice = new Scanner(System.in);
  
  
  public static int showCash(){
    return cash;
  }
  
  public static void setCash(int dollar){
    cash += dollar;
  }
  
  public static boolean testOfLuck(double num){
    if(num/30 > Math.random()){
      return true;
    }
    else
      return false;
  }
  
  public static void start() throws InterruptedException{
    text("Brrrinnnnng!");
    Thread.sleep(500);
    text("Brrrinnnnng!");
    Thread.sleep(500);
    text("You groan as you were woked up by your alarm clock. You look over and it reads 7:00.");
    Thread.sleep(5000);
    Need.initializeNeeds();
    Event.createEvents();
    wakingUpChoice1();
  }
  
  public static void wakingUpChoice1() throws InterruptedException{
    text("You don't know why your alarm rang, after all, today is Sunday and you don't have classes today. Do you...");
    text("1)Wake up\n2)Go back to Sleep");
    showNeedsandTime();
    createGroceryList();
    String option = "" + choice.next();
    if(option.equals("1"))
      wakeUp();
    else if(option.equals("2"))
      backToSleep();
    else
      wakingUpChoice1();
  }
  
  public static void backToSleep() throws InterruptedException{
    text("You decided to go back to sleep");
    text("You slept for 2 more hours and waked up on your own accord");
    Thread.sleep(4000);
    Need.setEnergy(30);
    timeChange(120);
    wakeUp();
  }
  
  public static void wakeUp() throws InterruptedException{
    text("What do you usually do when you wake up?");
    text("1)Stretch\n2)Leave your Bedroom\n3)Check your phone\n4)Lie on Bed");
    showNeedsandTime();
    String option = "" + choice.next();
    if(option.equals("1"))
      stretch();
    else if(option.equals("2"))
      homeHallway();
    else if(option.equals("3"))
      phoneCheck();
    else if(option.equals("4"))
      lieOnBed();
    else 
      wakeUp();
  }
  
  public static void stretch() throws InterruptedException{
    text("You stretched out your muscles for 5 minutes and felt more energized");
    Thread.sleep(3000);
    Need.setEnergy(4);
    timeChange(5);
    text("What do you do next?");
    text("1)Stay at your bedroom\n2)Check your phone\n3)Leave your bedroom");
    showNeedsandTime();
    String option = "" + choice.next();
    if(option.equals("1"))
      bedroom();
    else if(option.equals("2"))
      phoneCheck();
    else if(option.equals("3"))
      homeHallway();
    else 
      stretch();
  }
  
  public static void phoneCheck() throws InterruptedException{
    text("You scrolled through your phone checking for notifications and the daily news for 15 minutues");
    Thread.sleep(4000);
    Need.setBoredness(-9);
    timeChange(15);
    text("What do you do next?");
    text("1)Stay at your bedroom\n2)Leave your bedroom");
    showNeedsandTime();
    String option = "" + choice.next();
    if(option.equals("1"))
      bedroom();
    else if(option.equals("2"))
      homeHallway();
    else
      phoneCheck();
  }
  
  public static void lieOnBed() throws InterruptedException{
    text("You lied on bed for 5 minutes, not wanting to get up");
    Thread.sleep(2500);
    timeChange(5);
    text("What do you do next?");
    text("1)Stay at your bedroom\n2)Check your phone\n3)Leave your bedroom\n4)Stretch");
    showNeedsandTime();
    String option = "" + choice.next();
    if(option.equals("1"))
      bedroom();
    else if(option.equals("2"))
      phoneCheck();
    else if(option.equals("3"))
      homeHallway();
    else if(option.equals("4"))
      stretch();
    else 
      lieOnBed();
  }
  
  public static void bedroom() throws InterruptedException{
    text("You are in your bedroom. What do you do?");
    text("1)Check your phone\n2)Gaming Session\n3)Nap\n4)Daydream\n5)Leave");
    showNeedsandTime();
    String option = "" + choice.next();
    if(option.equals("1"))
      phoneCheck();
    else if(option.equals("2"))
      gaming();
    else if(option.equals("3"))
      nap();
    else if(option.equals("4"))
      daydream();
    else if(option.equals("5"))
      homeHallway();
    else
      bedroom();
  }
  
  public static void gaming() throws InterruptedException{
    text("You decided to play a game on your computer because you are part of the PC Master Race");
    Thread.sleep(4000);
    text("The game you decided to play is Typical Life Revisit(Name of Java Project) and lost yourself into the game for an hour.\n");
    Thread.sleep(5000);
    timeChange(60);
    Need.setBoredness(-40);
    bedroom();
  }
  
  public static void nap() throws InterruptedException{
    text("You decided to take a 30 minute nap");
    Thread.sleep(1000);
    timeChange(30);
    Need.setEnergy(14);
    bedroom();
  }
  
  public static void daydream() throws InterruptedException{
    text("You daydreamed about living your life in a fantasy world where everyday is not a montonous cycle");
    Thread.sleep(3000);
    timeChange(10);
    Need.setBoredness(-8);
    bedroom();
  }
  
  public static void bathroom() throws InterruptedException{
    text("You are in the bathroom. What do you do?");
    text("1)Brush your teeth\n2)Shower\n3)Bath\n4)Look in the Mirror\n5)Leave");
    showNeedsandTime();
    String option = "" + choice.next();
    if(option.equals("1"))
      brushTeeth();
    else if(option.equals("2"))
      shower();
    else if(option.equals("3"))
      takeBath();
    else if(option.equals("4"))
      mirror();
    else if(option.equals("5")){
      homeHallway();
    }
    else
      bathroom();
  }
  
  public static void brushTeeth() throws InterruptedException{
    text("You decided to brush your teeth for...");
    text("1)1 minute\n2)2 minutes\n3)3 minutes\n4)5 minutes");
    showNeedsandTime();
    String option = "" + choice.next();
    if(option.equals("1")){
      Need.setHygiene(2);
      timeChange(1);
    }
    else if(option.equals("2")){
      Need.setHygiene(5);
      timeChange(2);
    }
    else if(option.equals("3")){
      Need.setHygiene(6);
      timeChange(3);
    }
    else if(option.equals("4")){
      Need.setHygiene(7);
      timeChange(5);
    }
    else
      brushTeeth();
    text("You finished brushing your teeth.");
    Thread.sleep(1000);
    bathroom();
  }
  
  public static void shower() throws InterruptedException{
    text("What type of shower do you take?");
    text("1)Hot and Steamy Shower\n2)Cold and Freezing Shower");
    showNeedsandTime();
    String option = "" + choice.next();
    if(option.equals("1")) {
      Need.setHygiene(16);
      Need.setEnergy(-2);
      text("After your hot shower, you felt more tired.");
    }
    else if(option.equals("2")){
      Need.setHygiene(10);
      Need.setEnergy(4);
      text("After your cold shower, you felt more alert");
    }
    else
      shower();
    Thread.sleep(2000);
    timeChange(10);
    bathroom();
  }
  
  public static void takeBath() throws InterruptedException{
    text("You decided to take a bath but it took a long time for the tub to be filled up(You waited for 9 minutes)");
    text("You then slipped while getting into the bath and banged your head against the tub, effectively knocking you out for an hour");
    text("Maybe next time, avoid baths. You're better off taking a shower");
    Thread.sleep(17000);
    timeChange(69);
    bathroom();
  }
  
  public static void mirror() throws InterruptedException{
    text("You looked in the mirror and admired your own beauty");
    text("You did a variety of poses in front of the mirror and caught a twinkle in your smile");
    Thread.sleep(8000);
    Need.setBoredness(-5);
    timeChange(6);
    bathroom();
  }
  
  public static void kitchen() throws InterruptedException{
    text("You are in the kitchen. What do you do?");
    text("1)Cook and Eat\n2)Eat from fridge/cupboard\n3)Leave");
    showNeedsandTime();
    String option = "" + choice.next();
    if(option.equals("1"))
      cookEat();
    else if(option.equals("2"))
      eatRaw();
    else if(option.equals("3"))
      homeHallway();
    else
      kitchen();
  }
  
  public static void cookEat() throws InterruptedException{
    text("You decided to cook a meal for yourself");
    Thread.sleep(2000);
    if(testOfLuck(5))
      text("Despite your best efforts, the food came out burned and inedible"); 
    else{
      text("Though it took some time, you successfully cooked an edible and tasty meal");
      Need.setHunger(30);
    }
    Thread.sleep(3500);
    timeChange(15);
    kitchen();
  }
  
  public static void eatRaw() throws InterruptedException{
    text("You decided to have some quick snacks. Eating snacks all the time is not healthy and not very fulfilling." +  
           " You should cook some food instead");
    Thread.sleep(6000);
    Need.setHunger(3);
    timeChange(2);
    kitchen();
  }
  
  public static void homeHallway() throws InterruptedException{
    text("You are in your home's main hallway. You go...");
    text("1)To your Bedroom\n2)To the Bathroom\n3)To the Kitchen\n4)Outside");
    String option = "" + choice.next();
    if(option.equals("1"))
      bedroom();
    else if(option.equals("2"))
      bathroom();
    else if(option.equals("3"))
      kitchen();
    else if(option.equals("4"))
      homeYard();
  }
  
  public static void homeYard() throws InterruptedException{
    text("You are now in your home's empty front yard. You go...");
    text("1)Back Home\n2)To the Grocery Store(12 Minutes)\n3)To the Arcade(16 Minutes)\n4)To the Library(4 Minutes)\n5)To a Nearby Park(10 Minutes)\n");
    map();
    System.out.println();
    showNeedsandTime();
    String option = "" + choice.next();
    if(option.equals("1"))
      homeHallway();
    else if(option.equals("2")){
      if(testOfLuck(12))
        Event.getEvent();
      text("You spent 12 minutes to get to the grocery store");
      timeChange(12);
      grocery();
    }
    else if(option.equals("3")){
      if(testOfLuck(16))
        Event.getEvent();
      text("You spent 16 minutes to get to the arcade");
      timeChange(16);
      arcade();
    }
    else if(option.equals("4")){
      if(testOfLuck(4))
        Event.getEvent();
      text("You spent 4 minutes to get to the library");
      timeChange(4);
      library();
    }
    else if(option.equals("5")){
      if(testOfLuck(10))
        Event.getEvent();
      text("You spent 10 minutes to get to the park");
      timeChange(10);
      park();
    }
    else
      homeYard();
  }
  
  public static void map(){
    String[][] map = new String[][]{{"|________|","|_ARCADE_|","|________|","|________|","|________|","|________|","|________|","|________|"},
                                    {"|________|","|________|","|________|","|________|","|________|","|________|","|________|","|________|"},
                                    {"|________|","|________|","|________|","|________|","|________|","|________|","|________|","|_STORE__|"},
                                    {"|________|","|________|","|________|","|________|","|________|","|________|","|________|","|________|"},
                                    {"|________|","|________|","|________|","|__HOME__|","|________|","|LIBRARY_|","|________|","|________|"},
                                    {"|________|","|________|","|________|","|________|","|________|","|________|","|________|","|________|"},
                                    {"|__PARK__|","|________|","|________|","|________|","|________|","|________|","|________|","|________|"}};
  //Printing it out column-major order
    for(int colIndex = 0; colIndex < map[0].length; colIndex++){
      for(int rowIndex = 0; rowIndex < map.length; rowIndex++){
        System.out.print(map[rowIndex][colIndex]);
      }
      System.out.println();
    }
  }
  
  //Grocery Store List
  
  private static ArrayList groceryGoods = new ArrayList();
  
  public static void createGroceryList(){
    groceryGoods.add("PlainBagel"); groceryGoods.add(2);
    groceryGoods.add("HamSandwich"); groceryGoods.add(4);
    groceryGoods.add("ChocolateBar"); groceryGoods.add(1);
    groceryGoods.add("FruitSalad"); groceryGoods.add(4);
    groceryGoods.add("IceCream"); groceryGoods.add(2);
    groceryGoods.add("Fries"); groceryGoods.add(3);
    groceryGoods.add("ChickenDrumStick"); groceryGoods.add(5);
    groceryGoods.add("PizzaSlice"); groceryGoods.add(3);
  }
  public static void showGrocery() throws InterruptedException{
    for(int index = 0; index < groceryGoods.size(); index++){
      if(index % 2 == 0)
        System.out.print(groceryGoods.get(index) + ": ");
      else
        System.out.println("$ " + groceryGoods.get(index));
    }
  }
  
  public static void grocery() throws InterruptedException{
    Thread.sleep(2000);
    text("\nYou are now in front of the fragrant grocery store. You...");
    text("1)Go In\n2)Go to the Arcade(16 Minutes)\n3)Go to the Library(8 Minutes)\n4)Go to a nearby Park(26 Minutes)\n5)Go Back Home(12 Minutes)");
    showNeedsandTime();
    String option = choice.next();
    if(option.equals("1")){  
      text("The cashier there welcomes you and laid out the store's selections of goods");
      showGrocery();
      System.out.println();
      if(Need.getHygiene() < 30){
        text("After a few seconds, you can see the cashier pinching their nose as a result of your low hygiene");
      }
      text("Do you want to buy some food? Do note: the food you buy will be instantly eaten inside; You can't bring the food outside the store.");
      String buyFood = choice.next();
      if(!(buyFood.equalsIgnoreCase("Yes"))){
        text("You're in the grocery store to buy food right? Why else are you here?");
      }
      text("Pick a food item. Leave blank to leave the store.");
      String foodChoice = choice.next();
      for(int index = groceryGoods.size() - 2; index >= 0; index -= 2){
        if(foodChoice.equalsIgnoreCase((String)groceryGoods.get(index))){
          if((Integer)groceryGoods.get(index+1) < cash){
            Need.setHunger((Integer)groceryGoods.get(index+1)*5);
            cash -= ((Integer)groceryGoods.get(index+1));
            groceryGoods.remove(index);
            groceryGoods.remove(index);
          }
          else
            text("You can't afford the food item and you were promtly kicked out");
        }
      }
      grocery();
    }
    else if(option.equals("2")){
      if(testOfLuck(16))
        Event.getEvent();
      text("You spent 16 minutes to get to the arcade");
      timeChange(16);
      arcade();
    }
    else if(option.equals("3")){
      if(testOfLuck(8))
        Event.getEvent();
      text("You spent 8 minutes to get to the library");
      timeChange(8);
      library();
    }
    else if(option.equals("4")){
      if(testOfLuck(26))
        Event.getEvent();
      text("You spent 26 minutes to get to the park");
      timeChange(26);
      park();
    }
    else if(option.equals("5")){
      if(testOfLuck(12))
        Event.getEvent();
      text("You spent 12 minutes to go back home");
      timeChange(12);
      homeYard();
    }
    else
      grocery();
  }
  
  //Arcade Event
  
  private static int yourInt;
  private static boolean arcadeLotto = true;
  private static ArrayList<String> games = new ArrayList<String>();
  
  public static void arcadeLottery() throws InterruptedException{
    Thread.sleep(2000);
    if(Need.getHygiene() < 30)
      text("\nWhen you enter into the arcade, an employee wrinkles her nose and asks you for an integer from 1-49 to be entered into the Arcade Lottery");
    else
      text("\nWhen you enter into the arcade, an employee greets you and asks you for an integer from 1-49 to be entered into the Arcade Lottery");
    
    text("Whoever's number matches the winning number gets a prize of $180." +  
           " If 2 or more integers matches the winning integer, the prize will be split by the number of winners.");
    text("What number do you choose?");
    try{yourInt = choice.nextInt();}
    catch(Exception E){
     text("Since you tried to be funny and entered a non-integer, you are now unable to participate in the lottery.");
    }
    int winningInt = (int)(Math.random()*49+1);
    ArrayList<Integer> lottoInt = new ArrayList<Integer>();
   
    //Creating List of Random Integers
    lottoInt.add((int)(Math.random()*49+1));lottoInt.add((int)(Math.random()*49+1)); lottoInt.add((int)(Math.random()*49+1)); lottoInt.add((int)(Math.random()*49+1)); 
    lottoInt.add((int)(Math.random()*49+1)); lottoInt.add((int)(Math.random()*49+1)); lottoInt.add((int)(Math.random()*49+1)); lottoInt.add(yourInt);
    text("The winning integer is " + winningInt);
    text("Now lets take a look at the numbers that the particpants guess: ");
    System.out.println(lottoInt);
    text("Well, the list looks pretty messy so we'll arrange the numbers in ascending order");
    selectionSort(lottoInt);
    arcadeLotto = false;
    
    if(yourInt == winningInt){
      int numOfWinner = 1;
      for(int num: lottoInt){
        if(num == winningInt)
          numOfWinner++;
      }
      text("You won $" + 180/numOfWinner + " since there were " + numOfWinner + " winners. CONGRATS!!");
      cash += 180/numOfWinner;
   }
   else
    text("Looks like your number is not a winner. Better luck next time!");
  }
  
  public static String arcadeGameName(){
    games.add("Mortal Kombat");games.add("Pac-Man");
    games.add("Tetris");games.add("Terminator");
    games.add("Space Invade");games.add("Pinball");
    int random = (int)(Math.random() * 100);
    for(int index = 1; index < games.size()+1; index++){
      if((100*index)/games.size() > random)
        return (games.get(index-1));
    }
    return "Pinball";
  }
  
  public static void arcade() throws InterruptedException{
    text("\nYou are now in front of the flashy arcade. You...");
    text("1)Go In\n2)Go to the Grocery Store(16 Minutes)\n3)Go to the Library(20 Minutes)\n4)Go to a nearby Park(22 Minutes)\n5)Go Back Home(16 Minutes)");
    showNeedsandTime();
    String option = choice.next();
    if(option.equals("1")){
      if(arcadeLotto)
        arcadeLottery();
      text("\nYou can now play various games at the arcade. Each game costs $1 to play. Would you like to play a game?");
      String playGame = choice.next();
      if(playGame.equalsIgnoreCase("Yes")){
        if(cash >= 1){
          cash --;
          int timePlayed = (int)(Math.random()*10+1);
          timeChange(timePlayed);
          Need.setBoredness(-timePlayed/2);
          text("You played " + arcadeGameName() + " for " + timePlayed + " minutes until you lost.");
          text("After playing, you decided to leave the arcade. Of course, you can go back whenever you want.");
          Thread.sleep(8000);
        }
        else
          text("You don't have enough money and so you left the arcade");
      }
      else
        text("You decided to leave the arcade");
      arcade();
    }
    else if(option.equals("2")){
      if(testOfLuck(16))
        Event.getEvent();
      text("You spent 16 minutes to get to the grocery store");
      timeChange(16);
      grocery();
    }
    else if(option.equals("3")){
      if(testOfLuck(20))
        Event.getEvent();
      text("You spent 20 minutes to get to the library");
      timeChange(20);
      library();
    }
    else if(option.equals("4")){
      if(testOfLuck(22))
        Event.getEvent();
      text("You spent 22 minutes to get to the park");
      timeChange(22);
      park();
    }
    else if(option.equals("5")){
      if(testOfLuck(16))
        Event.getEvent();
      text("You spent 16 minutes to go back home");
      timeChange(16);
      homeYard();
    }
    else
      arcade();
  }
  
  public static void library() throws InterruptedException{
    text("\nYou are now in front of the quiet library. You...");
    text("1)Go In\n2)Go to the Arcade(20 Minutes)\n3)Go to the Grocery Store(8 Minutes)\n4)Go to a nearby Park(14 Minutes)\n5)Go Back Home(4 Minutes)");
    showNeedsandTime();
    String option = choice.next();
    if(option.equals("1")){
      text("Unfortunately, the library closes on the weekend so you can't go in.");
      Thread.sleep(4000);
      library();
    }
    else if(option.equals("2")){
      if(testOfLuck(20))
        Event.getEvent();
      text("You spent 20 minutes to get to the arcade");
      timeChange(20);
      arcade();
    }
    else if(option.equals("3")){
      if(testOfLuck(8))
        Event.getEvent();
      text("You spent 8 minutes to get to the grocery store");
      timeChange(8);
      grocery();
    }
    else if(option.equals("4")){
      if(testOfLuck(14))
        Event.getEvent();
      text("You spent 14 minutes to get to the park");
      timeChange(14);
      park();
    }
    else if(option.equals("5")){
      if(testOfLuck(4))
        Event.getEvent();
      text("You spent 4 minutes to go back home");
      timeChange(4);
      homeYard();
    }
    else
      library();
  }
  
  public static void park() throws InterruptedException{
    text("\nYou are now in front of the nature-smelling park. You...");
    text("1)Go In\n2)Go to the Arcade(22 Minutes)\n3)Go to the Grocery Store(26 Minutes)\n4)Go to the Library(14 Minutes)\n5)Go Back Home(10 Minutes)");
    showNeedsandTime();
    String option = choice.next();
    if(option.equals("1")){
      text("What do you do in the park?");
      text("1)Go for a Run\n2)Sit on a Bench and Reflect on your Life\n3)Try to Join the Park Picnic\n4)Leave");
      String parkChoice = choice.next();
      if(parkChoice.equals("1"))
        run();
      else if(parkChoice.equals("2"))
        reflect();
      else if(parkChoice.equals("3"))
        picnic();
      park();
    }
    else if(option.equals("2")){
      if(testOfLuck(22))
        Event.getEvent();
      text("You spent 22 minutes to get to the arcade");
      timeChange(22);
      arcade();
    }
    else if(option.equals("3")){
      if(testOfLuck(26))
        Event.getEvent();
      text("You spent 26 minutes to get to the grocery store");
      timeChange(26);
      grocery();
    }
    else if(option.equals("4")){
      if(testOfLuck(14))
        Event.getEvent();
      text("You spent 14 minutes to get to the library");
      timeChange(14);
      library();
    }
    else if(option.equals("5")){
      if(testOfLuck(10))
        Event.getEvent();
      text("You spent 10 minutes to go back home");
      timeChange(10);
      homeYard();
    }
    else
      park();
  }
  
  public static void run() throws InterruptedException{
    text("You ran around the park for 15 minutes to work on your cardio.");
    Need.setBoredness(-5);
    Need.setEnergy(-8);
    timeChange(15);
  }
  
  public static void reflect() throws InterruptedException{
    text("You sat on a park bench and reflected on your life. Are you happy with your life so far?");
    text("1)Yes\n2)No");
    String option = choice.next();
    if(option.equals("1")){
      text("You are happy with your life and so you reflect on your values and how you can maintain them to have a happy life in the future");
      timeChange(25);
    }
    else{
      text("You are not fully happy with your life and so you sit, deep in thought, and tried to find the problems preventing you from having a happy life.");
      text("You were so deep in thought, you did not notice the time and once you awaken from your thoughts, an hour had passed");
      timeChange(60);
    }
  }
  
  public static void picnic() throws InterruptedException{
    if(Need.getHygiene() < 30){
      text("When you get near the picnic site, you see people clearly sniffing the air");
      text("They turn to you and told you to get lost. They gag, clearly losing their appetite.");
      text("It seems your hygiene is too low. Maybe take a shower next time before taking part in a group event.");
    }
    else{
      text("You joined the group of people already at the picnic site and had fun talking and eating with them");
      Need.setHunger(18);
      timeChange(25);
    }
  }
  
  public static void selectionSort(ArrayList<Integer> list){
    int count = 0;
    for(int index = 0; index < list.size() - 1; index++){
      int minIndex = index;
      for(int num = index + 1; num < list.size(); num++){
        if(list.get(num) < list.get(minIndex)){
          minIndex = num; 
          count ++;
        }
      }
      if(index != minIndex){
        int temp = list.get(index); 
        list.set(index,list.get(minIndex));
        list.set(minIndex,temp);
        count ++;
      }
    }
    System.out.println(list + "\nWe used a computer to arrange the numbers and it took the computer " + count 
                      + " execution counts.");
  }
  
  public static void end() throws InterruptedException{
    text("Your previous choices will now be deleted so companies can't get your information");
    Thread.sleep(20000);
    System.exit(0);
  }
  
  public static void dayOver() throws InterruptedException{
    text("It is now 10:00 PM. You are forced to sleep in your bed, about to faced the dreaded day after the weekend: school");
    text("Thank you for playing. Your score is: " + (Need.getEnergy() + Need.getHunger() - Need.getBoredness() + Need.getHygiene() + cash));
    text("You can of course play again to get a higher score or to explore other parts of your life that you did not visit before. The choice is yours");
    end();
  }
  
  public static void badEndHunger() throws InterruptedException{
    text("Your hunger level is so low that you fainted from starvation");
    text("Try to take better care of yourself next time and EAT when you're hungry");
    text("Score: 0");
    end();
  }
  
  public static void noEnergy() throws InterruptedException{
    text("Your energy level is so low that you fell asleep on the floor for 4 hours and teleported to your bedroom");
    Need.setEnergy(65);
    bedroom();
  }
  
  public static void extremeBoredness() throws InterruptedException{
    text("You became so bored that your mind turned insane. You lost yourself in the world and wandered the world until you inevitably died");
    text("Score: 0");
    end();
  }
  
  public static void puke(){
    text("You overstuffed yourself and had to let out some content from your stomach");
    text("Try not to overeat next time");
  }
  
  //A faster way to printing strings
  public static void text(String text){
    System.out.println(text);
  }
  
  //Need Levels changes correspond with the change in time
  public static void timeChange(int minutes) throws InterruptedException{
    totalMinutes += minutes;
    Need.setEnergy(-minutes/7);
    Need.setBoredness(minutes/8);
    Need.setHunger(-minutes/5);
    Need.setHygiene(-minutes/10);
  }
  //Accurate way to show time in this fictional world. Game ends when time reaches certain point.
  public static void showTime() throws InterruptedException{
    String meridiem = " AM";
    int minute = (totalMinutes%60);    
    if(totalMinutes >= 600){
      totalMinutes = 0 + minute;
      afternoon = true;
    }
    int hour = totalMinutes/60;
    if(afternoon)
      meridiem = " PM";
    if(afternoon && totalMinutes >= 719){
      dayOver();
    }
    if(hour == 0)
      hour = 12;
    if(minute <= 9)
      text(hour + ":" + "0" + minute + meridiem);
    else
      text(hour + ":" + minute + meridiem);
  }
  
  //Convenient Method to Show Both Needs and Time in One Line
  public static void showNeedsandTime() throws InterruptedException{
    Need.showNeeds();
    System.out.print("Cash: $" + cash + " | ");
    showTime();
    System.out.println();
  }
  
}