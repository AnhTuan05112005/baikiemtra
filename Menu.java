import java.util.Scanner;

public class Menu {
    private ContactManager contactManager;

    public Menu() {
        contactManager = new ContactManager();
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Chương trình quản lý danh bạ");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Đọc từ file");
            System.out.println("4. Ghi vào file");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng tiếp theo

            switch (choice) {
                case 1:
                    contactManager.displayContacts();
                    break;
                case 2:
                    contactManager.addContact();
                    break;
                case 3:
                    contactManager.readFromFile();
                    break;
                case 4:
                    contactManager.writeToFile();
                    break;
                case 5:
                    System.out.println("Thoát khỏi chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}

