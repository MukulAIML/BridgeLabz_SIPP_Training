import java.lang.annotation.*;
import java.lang.reflect.*;

@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

class Software {
    @BugReport(description = "Null pointer issue")
    @BugReport(description = "Memory leak in loop")
    public void process() {}
}

public class BugReportDemo {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("process");
        BugReport[] reports = method.getAnnotationsByType(BugReport.class);
        for (BugReport r : reports) {
            System.out.println("Bug: " + r.description());
        }
    }
}