
// 2. Data Export Feature
interface ReportExporter {
    void export();
    default void exportToJSON() {
        System.out.println("Exporting data to JSON...");
    }
}

class CSVExporter implements ReportExporter {
    public void export() { System.out.println("Exporting to CSV..."); }
}

class PDFExporter implements ReportExporter {
    public void export() { System.out.println("Exporting to PDF..."); }
}

public class DefaultMethods2 {
    public static void main(String[] args) {
        ReportExporter exporter = new CSVExporter();
        exporter.export();
        exporter.exportToJSON();
    }
}
