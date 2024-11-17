import java.sql.Connection;
import java.sql.Statement;

public class CreatDataBase {
    public static void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS persons (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                email TEXT NOT NULL,
                name TEXT NOT NULL,
                age INTEGER NOT NULL,
                height FLOAT NOT NULL,
                weight FLOAT NOT NULL
            );
        """;

        try (Connection conexao = ConexaoSQLite.conectar();
             Statement stmt = conexao.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}
