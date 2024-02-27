
package labs;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
    private String registrationNumber;
    private String ownerName;
    private String ticketNumber; 

    public Car(String registrationNumber, String ownerName, String ticketNumber) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.ticketNumber = ticketNumber; 
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    @Override
    public String toString() {
        return "Машин{" +
                "Машины дугаар='" + registrationNumber + '\'' +
                ", Эзэмшигчийн нэр='" + ownerName + '\'' +
                ", Тасалбарийн дугаар='" + ticketNumber + '\'' +
                '}';
    }

}

class ParkingLot<T, U> {
    private List<T> parkedCars;
    private List<U> parkingTickets;

    public ParkingLot() {
        this.parkedCars = new ArrayList<>();
        this.parkingTickets = new ArrayList<>();
    }

    public void parkCar(T car, U ticket) {
        parkedCars.add(car);
        parkingTickets.add(ticket);
    }

    public void removeCar(U ticket) {
        int index = parkingTickets.indexOf(ticket);
        if (index != -1) {
            parkedCars.remove(index);
            parkingTickets.remove(index);
            System.out.println("Зогсоолоос машин гаргалаа.");
        } else {
            System.out.println("Байхгүй тасалбар.Дахин оруулна уу");
        }
    }

    public void displayParkedCars() {
        System.out.println("Машин байршууллаа");
        for (T car : parkedCars) {
            System.out.println(car);
        }
    }

    public int getNumberOfParkedCars() {
        return parkedCars.size();
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot<Car, String> parkingLot = new ParkingLot<>();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nЦэс:");
            System.out.println("1. Машин зогсоох");
            System.out.println("2. Машин гаргах");
            System.out.println("3. Зогсоолд байгаа машин харуулах");
            System.out.println("4. Зогсоол нэмэх");
            System.out.println("5. Гарах");
            System.out.print("Сонголтоо оруул");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Машины мэдээллээ оруул (Машины дугаар, Эзэмшигчийн нэр):");
                    String regNumber = scanner.next();
                    String ownerName = scanner.next();
                    String ticketNumber = "Тасалбар" + (parkingLot.getNumberOfParkedCars() + 1);
                    Car car = new Car(regNumber, ownerName, ticketNumber);
                    parkingLot.parkCar(car, ticketNumber);
                    System.out.println( ticketNumber+"");
                    break;
                case 2:
                    System.out.println("Гаргах машины дугаарыг оруул:");
                    String ticketToRemove = scanner.next();
                    parkingLot.removeCar(ticketToRemove);
                    break;
                case 3:
                    parkingLot.displayParkedCars();
                    break;
                case 4:
                    System.out.println("Хэдэн зогсоол нэмэх вэ:");
                    int additionalSpaces = scanner.nextInt();
                    for (int i = 0; i < additionalSpaces; i++) {
                        String additionalTicketNumber = "Нэмэлт зогсоол" + (parkingLot.getNumberOfParkedCars() + 1);
                        parkingLot.parkCar(null, additionalTicketNumber);
                    }
                    System.out.println("Нэмэлт зогсоол амжилттай нэмэгдлээ");
                    break;
                case 5:
                    exit = true;
                    System.out.println("Гарч байна...........5");
                    break;
                default:
                    System.out.println("Буруу утга. Зөв утга оруул.");
            }
        }

        scanner.close();
    }
}
//15:09
