/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg3;

/**
 *
 * @author sayyam
 */
public class HexaObserver extends Observer{
    
    public HexaObserver(){
        System.out.println("You are not subscribed to any subject.");
    }

   public HexaObserver(Subject subject){
      this.subject = subject;
      if(this.subject != null)
           this.subject.attach(this);
      else
           System.out.println("You are not subscribed to any subject.");
   }

   @Override
   public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
   }
}
