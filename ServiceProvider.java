
package proj1ComSys;


import java.util.ArrayList;

public class ServiceProvider {    
  private int p_id=500; 
  private static int count;//(must be unique and between 500 and 600)     
  private String p_name;         
  private double voiceCallCost;         
  private double messagingCost;      
  private double internetCost;         
  private int discountRatio;      
  private ArrayList<Subscriber>subscribersList;
 //For exit option
    private int totalCallTime;
    private int totalMessages;
    private double totalInternetUsage;

public ServiceProvider(String p_name, double voiceCallCost, double messagingCost, double internetCost,int discountRatio){
    this.p_name=p_name;
    this.voiceCallCost=voiceCallCost;
    this.messagingCost=messagingCost;
    this.internetCost=internetCost;
    this.discountRatio=discountRatio;
    p_id+=count;
    count++;
    subscribersList=new ArrayList<>();
}

public double calculateVoiceCallCost(int minute, Subscriber caller) { 
    int a=caller.getAge();
 if(minute<5 && 10<a && a<18){
     return 0;
  }
 else if(minute>5 && 10<a && a<18 || a>=65){
     return minute*voiceCallCost-(minute*voiceCallCost)*discountRatio/100;  
 }
  else{
    return minute*voiceCallCost;
  }
  
}

public double calculateMessagingCost(int quantity, Subscriber sender, Subscriber receiver){
    int a=sender.getAge();
    if(quantity<10 && 10<a && a<18){
    return 0;
}

    else if(subscribersList.contains(receiver)&&subscribersList.contains(sender)){          
        return (quantity*messagingCost)-(quantity*messagingCost)*discountRatio/100;
    }
    else{
    return quantity*messagingCost;
}
}

public double calculateInternetCost(double amount){
Subscriber s=new Subscriber();
    int a=s.getAge();
    if(5<10 && 10<a && a<18){
    return 0;
}
    else{
    return amount*internetCost;
}
}

 public boolean addSubscriber(Subscriber s){
     return getSubscribersList().add(s);
 }
 
 public boolean removeSubscriber(Subscriber s){
    return getSubscribersList().remove(s); 
 }
  
 public void addTotalCallTime(int totalCallTime) {
        this.totalCallTime += totalCallTime;
    }
  public int getTotalCallTime() {
        return totalCallTime;
    }

 
 public void addTotalMessages(int totalMessages) {
        this.totalMessages += totalMessages;
    }
 
    public int getTotalMessages() {
        return totalMessages;
    }
 public void addTotalInternetUsage(double totalInternetUsage) {
        this.totalInternetUsage += totalInternetUsage;
    }
 
    public double getTotalInternetUsage() {
        return totalInternetUsage;
    }
 
    public int getP_id() {
        return p_id;
    }


    public String getP_name() {
        return p_name;
    }


    public double getVoiceCallCost() {       
        return voiceCallCost;
    }


    public double getMessagingCost() {
        return messagingCost;
    }


    public double getInternetCost() {
        return internetCost;
    }


    public int getDiscountRatio() {
        return discountRatio;
    }

    public ArrayList<Subscriber> getSubscribersList() {
        return subscribersList;
    }
}
  
