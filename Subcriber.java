
package proj1ComSys;

import java.util.Date;

public class Subscriber {
    private int s_id=1000000; //must be unique and between 1000000 - 9000000
    private String name;
    private int age;
    private boolean isActive=true; 
    private ServiceProvider s_provider;
    private Invoice invoice;  
    private static int count;
  //For exit option
    private int totalCallTime;
    private int totalMessages;
    private double totalInternetUsage;
    private double cost;

   public Subscriber(){
    this.age=age;
}  

   public Subscriber(String name, int age, ServiceProvider s_provider, double usageLimit){
    this.name=name;     
    this.age=age;
    this.s_provider=s_provider;
    usageLimit=usageLimit;
    s_id+=count;
    count++;
  
}
 public void updateStatus(Invoice i){     
  Date LastDay=new Date();
  LastDay=i.getLastDayToPay();
    if(new Date().getTime()-LastDay.getTime()<0){
        isActive=false;
    }
    else{
        isActive=true;
    }
}
public void makeVoiceCall(int minute, Subscriber receiver){
    if(isActive){  
        System.out.println("You called "+receiver+"for "+minute+"minutes");
    }
    else{
        System.out.println("Inactive subscribers can not make voice calls!!");
    }
      invoice.addCost(cost);
        s_provider.addTotalCallTime(minute);
        totalCallTime += minute;
        receiver.makeVoiceCall(minute, this);
}

public void sendMessage(int quantity, Subscriber receiver){
     if(isActive==true){   
        System.out.println("You messaged "+receiver+", "+quantity+"times");
    }
    else{
        System.out.println("Inactive subscribers can not message!!");
    }          
    s_provider.addTotalMessages(quantity);
        totalMessages += quantity;
        invoice.addCost(cost);
}

public void connectToInternet(double amount){
     if(isActive==true){   
        System.out.println("You are connected to the internet, "+amount+" MB transferred");
    }
    else{
        System.out.println("Inactive subscribers can not connect Internet!!");
    } 
   s_provider.addTotalInternetUsage(amount);
        totalInternetUsage += amount;
        invoice.addCost(cost);
}

public void changeServiceProvider(ServiceProvider s_provider){ /////Before changing it, the invoice must be paid.
    
    this.s_provider=s_provider;
  
}

    
    public int getS_id() {
        return s_id;
    }

    
    public String getName() {
        return name;
    }

    
    public int getAge() {
        return age;
    }

    public void setAge(int age){
    this.age=age;
}
   
    public boolean isIsActive() {
        return isActive;
    }

   
    public ServiceProvider getS_provider() {
        return s_provider;
    }

    
    public Invoice getInvoice() {
        return invoice;
    }


}

