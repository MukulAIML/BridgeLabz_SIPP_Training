
// 1. Smart Device Control Interface
interface SmartDevice {
    void turnOn();
    void turnOff();
}

class Light implements SmartDevice {
    public void turnOn() { System.out.println("Light turned on"); }
    public void turnOff() { System.out.println("Light turned off"); }
}

class AC implements SmartDevice {
    public void turnOn() { System.out.println("AC turned on"); }
    public void turnOff() { System.out.println("AC turned off"); }
}

class TV implements SmartDevice {
    public void turnOn() { System.out.println("TV turned on"); }
    public void turnOff() { System.out.println("TV turned off"); }
}

public class DefiningInterfaces1 {
    public static void main(String[] args) {
        SmartDevice device = new Light();
        device.turnOn();
        device.turnOff();
    }
}
