
// 2. Cloning Prototype Objects
class Prototype implements Cloneable {
    String type;
    Prototype(String type) { this.type = type; }
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class MarkerInterfaces2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p1 = new Prototype("Model-X");
        Prototype p2 = (Prototype)p1.clone();
        System.out.println("Cloned object: " + p2.type);
    }
}
