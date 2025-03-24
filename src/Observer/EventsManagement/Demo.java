/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer.EventsManagement;

/**
 *
 * @author sayyam
 */

public class Demo {
    public static void main(String[] args) {
         Editor editor = new Editor();
        
        LogOpenListener logOL = new LogOpenListener("/path/to/log/file.txt");
        
        editor.events.subscribe("open", logOL);
        
        EmailNotificationListener eNL = new EmailNotificationListener("admin@example.com");
        
        editor.events.subscribe("save", eNL);
        
        SMSSupportListener sSL = new SMSSupportListener("03487190933");
        
        
        editor.events.subscribe("sendSMS", sSL);
        
        // Unsubsribe:
        editor.events.unsubscribe("open", logOL);
        editor.events.unsubscribe("save", eNL);

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       editor.sendMessage("Hey! I hope you're having a great day. Just wanted to reach out and see how things are going. Let me know if you need anything or just want to chat. Looking forward to catching up soon. Take care!");
    }
}
