/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

/**
 *
 * @author sayyam
 */
public class BinaryObserver extends Observer{
    
    public BinaryObserver(){
        System.out.println("You are not subscribed to any subject.");
    }

   public BinaryObserver(Subject subject){
      this.subject = subject;
      if(this.subject != null)
           this.subject.attach(this);
      else
           System.out.println("You are not subscribed to any subject.");
   }

   @Override
   public void update() {
      System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) ); 
   }
}
