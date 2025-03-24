/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer.EventsManagement;

import java.io.File;

/**
 *
 * @author sayyam
 */
public  class SMSSupportListener implements EventListener {
    public String phoneNo;
    
    public SMSSupportListener(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    public void update(String eventType, File file) {
        
       if(file.getName().length() > 160) {
            System.out.println("Meassage not send.\nPlease enter SMS with less then 160 characters."); 
            return;
        } 
        
        System.out.println("Your message '" + file.getName() + "' is successfully send to\n\tPhone number: " + phoneNo);
        
    }
}
