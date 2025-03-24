# **Observer Pattern with Dynamic Subscription Management - Part 1**

## **Overview**  
This project demonstrates the **Observer Design Pattern**, where multiple observers receive updates from a `Subject` whenever its state changes. The system is designed to allow **dynamic observer attachment and detachment**, ensuring only active observers are notified.

## **How It Works**  

1. The `Subject` class maintains a list of observers and notifies them when its state changes.  
2. Observers implement the `Observer` class and define how they react to state updates.  
3. The **new `detach(Observer o)` method** allows observers to be unsubscribed dynamically.  
4. The `ObserverPatternDemo` class demonstrates adding, removing, and updating observers.  

### **Events Handled:**
- Observers are notified when the `Subject` state changes.
- Observers can be **attached** (subscribed) or **detached** (unsubscribed).
- Only **active observers** receive updates.

### **Modified Components:**
1. **Added `detach(Observer o)` Method in `Subject`**  
   - This method allows removing an observer dynamically.
2. **Updated Observer Classes (`HexaObserver`, `BinaryObserver`, `OctalObserver`)**  
   - These observers now check if they are attached before subscribing.  
3. **Modified `ObserverPatternDemo`**  
   - Demonstrates observer attachment, detachment, and notifications.

---

## **Implementation Details**  

### **1. `Subject.java` (Manages Observers)**
```java
import java.util.ArrayList;
import java.util.List;

public class Subject {
   private List<Observer> observers = new ArrayList<>();
   private int state;

   public int getState() {
      return state;
   }

   public void setState(int state) {
      this.state = state;
      notifyAllObservers();
   }

   public void attach(Observer observer) {
      observers.add(observer);
   }
   
   public void detach(Observer observer) {
      observers.remove(observer); // Unsubscribes the observer
   }

   public void notifyAllObservers() {
      for (Observer observer : observers) {
         observer.update(); // Notify only active observers
      }
   }
}
```
- **New Feature:** `detach(Observer o)` method allows dynamic observer removal.
- **State Change:** Calls `notifyAllObservers()` when the state is updated.

---

### **2. `Observer.java` (Base Observer Class)**
```java
public abstract class Observer {
   protected Subject subject;
   public abstract void update();
}
```
- Acts as a blueprint for all observer types.

---

### **3. `HexaObserver.java` (Hexadecimal Representation)**
```java
public class HexaObserver extends Observer {
    
    public HexaObserver() {
        System.out.println("You are not subscribed to any subject.");
    }

    public HexaObserver(Subject subject) {
        this.subject = subject;
        if (this.subject != null)
            this.subject.attach(this);
        else
            System.out.println("You are not subscribed to any subject.");
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
```
- If `subject` is `null`, prints a warning message.
- Converts state to a **hexadecimal** string.

---

### **4. `BinaryObserver.java` (Binary Representation)**
```java
public class BinaryObserver extends Observer {
    
    public BinaryObserver() {
        System.out.println("You are not subscribed to any subject.");
    }

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        if (this.subject != null)
            this.subject.attach(this);
        else
            System.out.println("You are not subscribed to any subject.");
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
```
- Converts state to a **binary** string.

---

### **5. `OctalObserver.java` (Octal Representation)**
```java
public class OctalObserver extends Observer {
    
    public OctalObserver() {
        System.out.println("You are not subscribed to any subject.");
    }

    public OctalObserver(Subject subject) {
        this.subject = subject;
        if (this.subject != null)
            this.subject.attach(this);
        else
            System.out.println("You are not subscribed to any subject.");
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}
```
- Converts state to an **octal** string.

---

### **6. `ObserverPatternDemo.java` (Demonstrating the Pattern)**
```java
public class ObserverPatternDemo {
   public static void main(String[] args) {
      Subject subject = new Subject();

      HexaObserver hexaObserve2 = new HexaObserver(); // Not attached
      HexaObserver hexaObserver = new HexaObserver(subject);
      OctalObserver octalObserver = new OctalObserver(subject);
      BinaryObserver binaryObserver = new BinaryObserver(subject);

      System.out.println("First state change: 15");
      subject.setState(15); // All observers receive this update
      
      System.out.println("\nDetaching OctalObserver...\n");
      subject.detach(octalObserver); // OctalObserver unsubscribed
      
      subject.setState(12); // Only active observers notified

      System.out.println("\nSecond state change: 10");
      subject.setState(10); // Only active observers notified
   }
}
```
### **Key Features in `ObserverPatternDemo`:**
1. **Observers are added dynamically.**
2. **An observer (`OctalObserver`) is detached at runtime.**
3. **Only active observers receive updates.**

---

## **Expected Output**
```
You are not subscribed to any subject.
First state change: 15
Hex String: F
Octal String: 17
Binary String: 1111

Detaching OctalObserver...

Hex String: C
Binary String: 1100

Second state change: 10
Hex String: A
Binary String: 1010
```
### **Explanation:**
1. Initially, all observers (`HexaObserver`, `OctalObserver`, `BinaryObserver`) are notified when the state is set to `15`.  
2. `OctalObserver` is **detached**, so it no longer receives updates.  
3. The state is updated again (`12` and `10`), but only `HexaObserver` and `BinaryObserver` are notified.  

---

## **Conclusion**  
### **Enhancements in This Version:**
✅ **Dynamic Observer Subscription & Unsubscription:**  
- Observers can be attached or detached at runtime.  

✅ **Ensuring Only Active Observers Receive Updates:**  
- The system prevents unnecessary notifications.  

✅ **Improved Maintainability & Flexibility:**  
- Observers can be managed dynamically, making the system adaptable.  

By implementing **`detach(Observer o)`**, we enhance the **Observer Pattern**, ensuring it supports **real-time observer management.** 🚀



# **Observer Pattern Implementation - Part 2**  

## **Overview**  
This project demonstrates the **Observer Design Pattern**, where multiple listeners are notified of events triggered by an `Editor` class. The pattern allows decoupling between event publishers and subscribers, making the system more flexible and scalable.  

## **How It Works**  

1. The `Editor` class acts as the **publisher**, notifying subscribers when a file is opened, saved, or an SMS is sent.  
2. The `EventManager` class manages event subscriptions and notifications.  
3. Various listener classes implement the `EventListener` interface to respond to these events.  
4. Listeners can **subscribe** or **unsubscribe** from different events dynamically.  

### **Events Handled:**
- **open** → Notifies when a file is opened.  
- **save** → Notifies when a file is saved.  
- **sendSMS** → Notifies when an SMS is sent.  

### **Listeners:**
- **EmailNotificationListener** → Sends an email notification when a file is saved.  
- **LogOpenListener** → Logs file events when a file is opened.  
- **SMSSupportListener** → Sends an SMS message when triggered.  

## **Newly Added: `SMSSupportListener` & `sendSMS` Event**  

### **What is `SMSSupportListener`?**  
- `SMSSupportListener` is a newly introduced event listener that simulates sending an SMS notification when the `sendSMS` event occurs.  
- It checks whether the **message length exceeds 160 characters**. If it does, it prevents the message from being sent.  
- If the message is within the limit, it **simulates sending** the SMS to a given phone number.  

### **Implementation of `SMSSupportListener.java`**
```java
public class SMSSupportListener implements EventListener {
    public String phoneNo;
    
    public SMSSupportListener(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    public void update(String eventType, File file) {
        if (file.getName().length() > 160) {
            System.out.println("Message not sent.\nPlease enter an SMS with less than 160 characters.");
            return;
        } 
        System.out.println("Your message '" + file.getName() + "' is successfully sent to\n\tPhone number: " + phoneNo);
    }
}
```

---

## **Usage Example**  

In `Demo.java`, different listeners subscribe to `open`, `save`, and `sendSMS` events.  
Here, we **register `SMSSupportListener`** for the `sendSMS` event, allowing SMS notifications when a message is sent.  

```java
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();

        LogOpenListener logOL = new LogOpenListener("/path/to/log/file.txt");
        editor.events.subscribe("open", logOL);

        EmailNotificationListener eNL = new EmailNotificationListener("admin@example.com");
        editor.events.subscribe("save", eNL);

        // Registering SMSSupportListener
        SMSSupportListener sSL = new SMSSupportListener("03456789123");
        editor.events.subscribe("sendSMS", sSL);

        // Unsubscribe from some events
        editor.events.unsubscribe("open", logOL);
        editor.events.unsubscribe("save", eNL);

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Sending an SMS message
        editor.sendMessage("Hey! I hope you're having a great day. Just wanted to reach out and see how things are going. Let me know if you need anything or just want to chat. Looking forward to catching up soon. Take care!");
    }
}
```

---

## **Expected Output**
```
Save to log /path/to/log/file.txt: Someone has performed open operation with the following file: test.txt
Email to admin@example.com: Someone has performed save operation with the following file: test.txt
Message not sent.
Please enter an SMS with less than 160 characters.
```
(If the SMS message is within the limit, it would print:)
```
Your message 'Hello! How are you?' is successfully sent to
    Phone number: 03456789123
```

---

## **Conclusion**  
This implementation enhances the **Observer Pattern** by introducing a **new event (`sendSMS`)** and its corresponding listener, `SMSSupportListener`.  
- The system is **flexible** as subscribers can be added or removed dynamically.  
- The **message length validation** in `SMSSupportListener` prevents exceeding SMS limits.  
- The **unsubscribe functionality** allows dynamic event handling based on user needs.  

With these improvements, the project now supports **file operations notifications and SMS messaging within an event-driven architecture**.
