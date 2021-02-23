package p01_intro;

public class Car {
    // class variables
    private String brand;
    private String plate;
    private int cc;
    private double miles;

    // Default Constructor
    public Car() {
        brand = "";
        plate = "";
        cc = 0;
        miles = 0;
    }

    // Constructor
    public Car(String brand, String plate) {
        this();
        this.brand = brand;
        this.plate = plate;
    }

    // All vars constructor
    public Car(String brand, String plate, int cc, double miles) {
        this(brand, plate);
        this.cc = cc;
        this.miles = miles;
    }

    public String getBrand() {
        return brand;
    }

    public String getPlate() {
        return plate;
    }

    public int getCc() {
        return cc;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    @Override
    public String toString() {
        if(brand.equals("")) {
            return "Car not defined yet";
        }
        return brand + ", plate:" + plate + ". Details(cc:" + cc + ", miles:" + miles + ")";
    }

    public static void main(String[] args) {
        Car a = new Car();
        Car b = new Car("VW", "ZXA9109");
        Car c = new Car("Toyota", "ZAN6712", 1300, 12087.4);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
