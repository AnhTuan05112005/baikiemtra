import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_PATH = "data/contacts.csv";

    public List<Contact> readContactsFromFile() {
        List<Contact> contacts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine(); // Bỏ qua dòng tiêu đề

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 7) {
                    Contact contact = new Contact(
                            values[0], // Số điện thoại
                            values[1], // Nhóm
                            values[2], // Họ tên
                            values[3], // Giới tính
                            values[4], // Địa chỉ
                            values[5], // Ngày sinh
                            values[6]  // Email
                    );
                    contacts.add(contact);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return contacts;
    }

    public void writeContactsToFile(List<Contact> contacts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bw.write("Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email");
            bw.newLine();

            for (Contact contact : contacts) {
                bw.write(String.join(",",
                        contact.getPhoneNumber(),
                        contact.getGroup(),
                        contact.getName(),
                        contact.getGender(),
                        contact.getAddress(),
                        contact.getDateOfBirth(),
                        contact.getEmail()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}

