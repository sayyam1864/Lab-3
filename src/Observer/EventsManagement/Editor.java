/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer.EventsManagement;

/**
 *
 * @author sayyam
 */
import java.io.File;

public class Editor {
    public EventManager events; // this will manage different observers for different events
    // eg for 'save' event it will notify 2 user out of 5, for 'open'event notify 3 out of 5
    private File file;
    
     public Editor() {
        this.events = new EventManager("open", "save", "sendSMS");
    }

    public void openFile(String filePath) {
        file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
    
    public void sendMessage(String message) {
         file = new File(message);
        events.notify("sendSMS", file);
    }
}