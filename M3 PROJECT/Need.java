public class Need{
  private String name;
  private int number;
  private static String[][] needList = new String[4][2];
  
  public Need(String name, int number){
    this.name = name;
    this.number = number;
  }
  
  public static void initializeNeeds(){
    Need energy = new Need("Energy",75);
    Need hunger = new Need("Hunger",40);
    Need boredness = new Need("Boredness",5);
    Need hygiene = new Need("Hygiene",40);
    needList = new String[][]{{energy.name,""+energy.number},{boredness.name,""+boredness.number}, 
                              {hunger.name,""+hunger.number},{hygiene.name,""+hygiene.number}};
  }
  
  //Setters that increases or decreases the need levels.
  public static void setEnergy(int number) throws InterruptedException{
    int needLevel = Integer.valueOf(needList[0][1]);
    int changedLevel = needLevel + number;
    if(changedLevel <= 0)
      Adventure.noEnergy();
    if(changedLevel > 101)
      changedLevel = 100;
    needList[0][1] = changedLevel + "";
  }
  public static void setBoredness(int number) throws InterruptedException{
    int needLevel = Integer.valueOf(needList[1][1]);
    int changedLevel = needLevel + number;
    if(changedLevel >= 100)
      Adventure.extremeBoredness();
    if(changedLevel < -1)
      changedLevel = 0;
    needList[1][1] = changedLevel + "";
  }
  public static void setHunger(int number) throws InterruptedException{
    int needLevel = Integer.valueOf(needList[2][1]);
    int changedLevel = needLevel + number;
    if(changedLevel <= 0)
      Adventure.badEndHunger();
    if(changedLevel > 100){
      Adventure.puke();
      changedLevel = 70;
    }
    needList[2][1] = changedLevel + "";
  }
  public static void setHygiene(int number){
    int needLevel = Integer.valueOf(needList[3][1]);
    int changedLevel = needLevel + number;
    if(changedLevel > 100)
      changedLevel = 100;
    needList[3][1] = changedLevel + "";
  }
  
  public static int getEnergy(){
    return Integer.valueOf(needList[0][1]);
  }
  public static int getBoredness(){
    return Integer.valueOf(needList[1][1]);
  }
  public static int getHunger(){
    return Integer.valueOf(needList[2][1]);
  }
  public static int getHygiene(){
    return Integer.valueOf(needList[3][1]);
  }
  
  //Traverses the 2D array of needList to show the needs' levels in row-major order.
  public static void showNeeds(){
    int outerCount = 1;
    int innerCount = 1;
    for(String[] name: needList){
      for(String need: name){
        if(innerCount < 2)
          System.out.print(need + ": ");
        else
          System.out.print(need + " ");
        innerCount ++;
      }
      innerCount = 1;
      System.out.print("| ");
      outerCount++;
    }
  }
  
}