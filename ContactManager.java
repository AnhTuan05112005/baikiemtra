import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private List<Contact> contacts;
    private FileHandler fileHandler;

    public ContactManager() {
        contacts = new ArrayList<>();
        fileHandler = new FileHandler();
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ trống.");
            return;
        }
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ": " + contacts.get(i));
            if ((i + 1) % 5 == 0) {
                System.out.println("Nhấn Enter để tiếp tục...");
                new Scanner(System.in).nextLine();
            }
        }
    }

    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhóm: ");
        String group = scanner.nextLine();
        System.out.print("Họ tên: ");
        String name = scanner.nextLine();
        System.out.print("Giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Contact newContact = new Contact(phoneNumber, group, name, gender, address, dateOfBirth, email);
        contacts.add(newContact);
        System.out.println("Đã thêm danh bạ thành công.");
    }

    public void readFromFile() {
        System.out.println("Bạn có chắc chắn muốn đọc từ file? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("Y")) {
            contacts = fileHandler.readContactsFromFile();
            System.out.println("Đọc danh bạ từ file thành công.");
        } else {
            System.out.println("Đã hủy thao tác.");
        }
    }

    public void writeToFile() {
        System.out.println("Bạn có chắc chắn muốn ghi vào file? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("Y")) {
            fileHandler.writeContactsToFile(contacts);
            System.out.println("Ghi danh bạ vào file thành công.");
        } else {
            System.out.println("Đã hủy thao tác.");
        }
    }
}
