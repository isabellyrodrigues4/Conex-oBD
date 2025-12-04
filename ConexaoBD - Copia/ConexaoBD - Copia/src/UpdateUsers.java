import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUsers {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "";

        try {
            // Conectar ao banco
            Connection conn = DriverManager.getConnection(url, user, password);

            // SQL para atualizar o usuário com id = 1
            String sql = "UPDATE users2 SET name = ?, email = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "Usuario Atualizado");
            stmt.setString(2, "atualizado@exemplo.com");
            stmt.setInt(3, 1); // ALTERA o registro com ID 1

            int rows = stmt.executeUpdate();

            System.out.println(rows + " registro(s) atualizado(s).");

            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dados!");
            e.printStackTrace();
        }
    }
}

