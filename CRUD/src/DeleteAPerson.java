import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteAPerson {
    public static void delete() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID of the person you want to delete: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM persons WHERE id = ?";

        try (Connection conexao = ConexaoSQLite.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Person deleted successfully!");
            } else {
                System.out.println("No person found with ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error while deleting person: " + e.getMessage());
        }
    }
}
