import java.util.function.Consumer;

public class SmartHomeLighting {
    public static void main(String[] args) {
        Consumer<String> motionTrigger = (location) -> System.out.println("Motion detected in " + location + " - Turning ON lights.");
        Consumer<String> timeTrigger = (time) -> System.out.println("It's " + time + " - Activating evening lights.");
        Consumer<String> voiceTrigger = (command) -> System.out.println("Voice Command: " + command + " - Adjusting lights accordingly.");

        motionTrigger.accept("Living Room");
        timeTrigger.accept("8:00 PM");
        voiceTrigger.accept("Dim Lights");
    }
}