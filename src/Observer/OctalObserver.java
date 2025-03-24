/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

/**
 *
 * @author sayyam
 */
public class OctalObserver extends Observer{
    
    public OctalObserver(){
        System.out.println("You are not subscribed to any subject.");
    }

   public OctalObserver(Subject subject){
      this.subject = subject;
      if(this.subject != null)
           this.subject.attach(this);
      else
           System.out.println("You are not subscribed to any subject.");
   }

   @Override
   public void update() {
     System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) ); 
   }
}