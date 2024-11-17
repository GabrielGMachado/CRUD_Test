import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQLite {
    private static final String URL = "jdbc:sqlite:meu_banco.db";
    public ConexaoSQLite() {
    }

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:sqlite:meu_banco.db");
            return conexao;
        } catch (SQLException e) {
            return null;
        }
    }
}