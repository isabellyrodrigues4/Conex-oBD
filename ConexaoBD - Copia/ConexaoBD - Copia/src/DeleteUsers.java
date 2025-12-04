import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUsers {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "";

        try {
            // Conectar ao banco
            Connection conn = DriverManager.getConnection(url, user, password);

            // SQL para deletar o usuário com id = 2
            String sql = "DELETE FROM users2 WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 2); // <-- AQUI! Coloca o ID que você quer apagar

            int rows = stmt.executeUpdate();

            System.out.println(rows + " registro(s) deletado(s).");

            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar dados!");
            e.printStackTrace();
        }
    }
}
