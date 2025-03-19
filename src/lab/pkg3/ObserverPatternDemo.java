/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab.pkg3;

/**
 *
 * @author sayyam
 */
public class ObserverPatternDemo {
   public static void main(String[] args) {
      Subject subject = new Subject();

      HexaObserver hexaObserver = new HexaObserver(subject);
      OctalObserver octalObserver = new OctalObserver(subject);
      BinaryObserver binaryObserver = new BinaryObserver(subject);

      System.out.println("First state change: 15");	
      subject.setState(15);
      
      System.out.println("\nDetaching OctalObserver...\n");
      subject.detach(octalObserver);
      
      subject.setState(12);
      
      System.out.println();
      
      System.out.println("Second state change: 10");	
      subject.setState(10);
   }
}
