import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewTheTable {
    public static void View () {
        String sql = "SELECT * FROM persons";


        try (Connection conexao = ConexaoSQLite.conectar();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Height: " + rs.getFloat("height"));
                System.out.println("Weight: " + rs.getFloat("weight"));
                System.out.println("----------------------------");
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar dados: " + e.getMessage());
        }
    }
}
