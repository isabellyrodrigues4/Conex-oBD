import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = ""; // sua senha, se tiver

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizada com sucesso!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro na conexão!");
            e.printStackTrace();
        }
    }
}
