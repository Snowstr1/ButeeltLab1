import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class buteelt2<T> {
    private List<T> SchoolLabs = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addLab(T newLab) {
        SchoolLabs.add(newLab);
    }

    public void removeLab(T vacatedLab) {
        SchoolLabs.remove(vacatedLab);
    }

    public void displayLabs() {
        System.out.println("Хичээл орж байгаа өрөө өрөөнүүд: " + SchoolLabs);
    }

    public static void main(String[] args) {
        buteelt2<String> labManager = new buteelt2<>();

        labManager.addLab("123");
        labManager.addLab("442");
        labManager.addLab("241");
        labManager.addLab("524");

        while (true) {
            labManager.displayLabs();

            System.out.println("\nMenu:");
            System.out.println("1. Хичээл орж байгаа өрөө нэмэх.");
            System.out.println("2. Хичээл орж дууссан өрөө.");
            System.out.println("3. Exit");

            System.out.print("Сонголтоо оруулна уу. (1-3): ");
            int choice = labManager.scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Өрөөний тоог оруулна уу : ");
                    String newRoom = labManager.scanner.next();

                    if (labManager.SchoolLabs.contains(newRoom)) {
                        System.out.println("Хичээл орж байна.");
                    } else {
                        labManager.addLab(newRoom);
                        System.out.println(newRoom + " өрөөг нэмлээ.");
                    }
                    break;

                case 2:
                    System.out.print("Хичээл орж дууссан өрөөны тоог оруулна уу: ");
                    String vacatedRoom = labManager.scanner.next();

                    if (labManager.SchoolLabs.contains(vacatedRoom)) {
                        labManager.removeLab(vacatedRoom);
                        System.out.println("Хичээл орж дууслаа " + vacatedRoom + ".");
                    } else {
                        System.out.println(vacatedRoom + " өрөө байхгүй байна.");
                    }
                    break;	

                case 3:
                    System.out.println("ГАРЧ БАЙНА!.....");
                    labManager.scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Зөв утга оруулна уу.");
            }
        }
    }
}
