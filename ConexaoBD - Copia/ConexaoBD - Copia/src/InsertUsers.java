import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUsers {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "";

        try {
            // Conectar ao banco
            Connection conn = DriverManager.getConnection(url, user, password);

            // Comando SQL para inserir
            String sql = "INSERT INTO users2 (name, email) VALUES (?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "Novo Usuario");
            stmt.setString(2, "novo@exemplo.com");

            int rows = stmt.executeUpdate();

            System.out.println(rows + " registro(s) inserido(s) com sucesso!");

            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados!");
            e.printStackTrace();
        }
    }
}
