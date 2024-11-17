import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddAPerson {
    public static void creatAPerson () {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter height: ");
        float height = scanner.nextFloat();

        System.out.print("Enter weight: ");
        float weight = scanner.nextFloat();

        String sql = "INSERT INTO persons (email, name, age, height, weight) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = ConexaoSQLite.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.setFloat(4, height);
            stmt.setFloat(5, weight);

            stmt.executeUpdate();
            System.out.println("Person added successfully!");

        } catch (Exception e) {
            System.out.println("Error while inserting data: " + e.getMessage());
        }
    }
}
