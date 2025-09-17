
import java.util.*;
import java.util.stream.Collectors;

public class HospitalDoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr. Smith", "Cardiology", true),
            new Doctor("Dr. Lee", "Neurology", false),
            new Doctor("Dr. Brown", "Orthopedics", true),
            new Doctor("Dr. Green", "Dermatology", true)
        );

        List<Doctor> weekendDoctors = doctors.stream()
            .filter(Doctor::isAvailableOnWeekend)
            .sorted(Comparator.comparing(Doctor::getSpecialty))
            .collect(Collectors.toList());

        weekendDoctors.forEach(System.out::println);
    }
}

class Doctor {
    private String name;
    private String specialty;
    private boolean availableOnWeekend;

    public Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    public String getSpecialty() { return specialty; }
    public boolean isAvailableOnWeekend() { return availableOnWeekend; }
    public String toString() { return name + " - " + specialty; }
}
