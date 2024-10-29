package case_study.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManagement pm = new ProductManagement();
        Scanner scanner = new Scanner(System.in);
        int choice = -1; // Khởi tạo giá trị khác -1 để vào vòng lặp

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Thoát");
            System.out.print("Chọn tùy chọn (1-5): ");

            while (!scanner.hasNextInt()) { // Kiểm tra đầu vào
                System.out.println("Vui lòng nhập một số nguyên từ 1 đến 5.");
                scanner.next(); // Dọn sạch đầu vào không hợp lệ
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (choice) {
                case 1:
                    System.out.println("Bạn đã chọn hiển thị danh sách sản phẩm.");
                    pm.displayProducts();
                    break;

                case 2:
                    System.out.println("Bạn đã chọn thêm sản phẩm.");
                    System.out.print("Nhập ID sản phẩm: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập danh mục sản phẩm: ");
                    String category = scanner.nextLine();
                    System.out.print("Nhập ngày hết hạn (YYYY-MM-DD): ");
                    LocalDate expiryDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Nhập số lượng: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập giá: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    Product product = new Product(id, name, category, expiryDate, quantity, price);
                    pm.addProduct(product);
                    break;

                case 3:
                    System.out.println("Bạn đã chọn cập nhật sản phẩm.");
                    System.out.print("Nhập chỉ số sản phẩm để cập nhật: ");
                    int updateIndex = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nhập ID sản phẩm mới: ");
                    String newId = scanner.nextLine();
                    System.out.print("Nhập tên sản phẩm mới: ");
                    String newName = scanner.nextLine();
                    System.out.print("Nhập danh mục sản phẩm mới: ");
                    String newCategory = scanner.nextLine();
                    System.out.print("Nhập ngày hết hạn mới (YYYY-MM-DD): ");
                    LocalDate newExpiryDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Nhập số lượng mới: ");
                    int newQuantity = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập giá mới: ");
                    double newPrice = Double.parseDouble(scanner.nextLine());

                    Product updatedProduct = new Product(newId, newName, newCategory, newExpiryDate, newQuantity, newPrice);
                    pm.updateProduct(updateIndex, updatedProduct);
                    break;

                case 4:
                    System.out.println("Bạn đã chọn xóa sản phẩm.");
                    System.out.print("Nhập chỉ số sản phẩm để xóa: ");
                    int deleteIndex = Integer.parseInt(scanner.nextLine());
                    pm.deleteProduct(deleteIndex);
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}
