import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class SelectUsers {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "";

        try {
            // Conectar ao banco
            Connection conn = DriverManager.getConnection(url, user, password);

            // Criar comando SQL
            String sql = "SELECT * FROM users2"; // use users se quiser

            Statement stmt = conn.createStatement();

            // Executar e obter resultados
            ResultSet rs = stmt.executeQuery(sql);

            // Mostrar registros
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                System.out.println("ID: " + id + ", Nome: " + name + ", Email: " + email);
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao consultar dados!");
            e.printStackTrace();
        }
    }
}
