package case_study.Product;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    private final String filePath = "src/case_study/file/product_list.csv";

    public List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filePath))) {
            String temp;
            // Bỏ qua dòng tiêu đề
            bufferedReader.readLine();
            while ((temp = bufferedReader.readLine()) != null) {
                String[] tempArr = temp.split(",");
                productList.add(new Product(
                        tempArr[0],
                        tempArr[1],
                        tempArr[2],
                        LocalDate.parse(tempArr[3]),
                        Integer.parseInt(tempArr[4]),
                        Double.parseDouble(tempArr[5])
                ));
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi không xác định: " + e.getMessage());
        }
        return productList;
    }

    // Thêm sản phẩm mới
    public void addProduct(Product product) {
        if (product != null && !isExistedProductCode(product.getId())) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.filePath, true))) {
                bufferedWriter.write(product.toFileString() + "\n");
                System.out.println("Product added successfully");
            } catch (IOException e) {
                System.out.println("Lỗi khi ghi file: " + e.getMessage());
            }
        } else {
            System.out.println("Sản phẩm đã tồn tại hoặc thông tin không hợp lệ.");
        }
    }

    // Cập nhật thông tin sản phẩm
    public void updateProduct(int index, Product newProduct) {
        List<Product> productList = this.getProductList();
        if (index >= 0 && index < productList.size()) {
            productList.set(index, newProduct);
            saveProductListToFile(productList);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Hiển thị danh sách sản phẩm
    public void displayProducts() {
        List<Product> productList = this.getProductList();
        System.out.println("Current product list:");
        for (Product product : productList) {
            System.out.println(productList.indexOf(product) + ". " + product);
        }
    }

    // Xóa sản phẩm
    public void deleteProduct(int index) {
        List<Product> productList = this.getProductList();
        if (index >= 0 && index < productList.size()) {
            productList.remove(index);
            saveProductListToFile(productList);
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Kiểm tra sản phẩm có tồn tại
    public boolean isExistedProductCode(String code) {
        for (Product product : getProductList()) {
            if (product.getId().equals(code)) {
                return true;
            }
        }
        return false;
    }

    // Lưu danh sách sản phẩm vào file
    private void saveProductListToFile(List<Product> productList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.filePath))) {
            bufferedWriter.write("ID,Name,Category,ExpiryDate,Quantity,Price\n"); // Ghi lại tiêu đề
            for (Product product : productList) {
                bufferedWriter.write(product.toFileString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}
