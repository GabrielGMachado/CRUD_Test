import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class EditAPerson {

    public static void editPerson() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the ID of the person you want to edit: ");
        int id = scanner.nextInt();

        System.out.print("Enter new name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        System.out.print("Enter new age: ");
        int age = scanner.nextInt();

        System.out.print("Enter new height: ");
        float height = scanner.nextFloat();

        System.out.print("Enter new weight: ");
        float weight = scanner.nextFloat();

        String sql = "UPDATE persons SET name = ?, email = ?, age = ?, height = ?, weight = ? WHERE id = ?";

        try (Connection conexao = ConexaoSQLite.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, age);
            stmt.setFloat(4, height);
            stmt.setFloat(5, weight);
            stmt.setInt(6, id);

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Person updated successfully!");
            } else {
                System.out.println("No person found with ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error while updating person: " + e.getMessage());
        }
    }
}
