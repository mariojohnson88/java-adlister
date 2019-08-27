import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    Connection connection;

    public MySQLAdsDao() {
        try {
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUser(),
                    Config.getPassword()
            );
            System.out.println("Connection to database made.");
        } catch (SQLException ex) {
            System.out.println("Connection failed");
            ex.printStackTrace();
        }
    }


    @Override
    public List<Ad> all() throws SQLException {
        List<Ad> ads = new ArrayList<>();
        String selectQuery = "SELECT * FROM ads";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(selectQuery);
        while (rs.next()) {
            long id = rs.getLong("id");
            long userId = rs.getLong("user_id");
            String title = rs.getString("title");
            String description = rs.getString("description");
            ads.add(new Ad(id, userId, title, description));
        }
        return ads;
    }


    @Override
    public Long insert(Ad ad) throws SQLException {
        String insertQuery =
                String.format("INSERT INTO ads(user_id, title, description) VALUES ('%d', '%s', '%s')",
                ad.getUserId(), ad.getDescription(), ad.getTitle());
        System.out.println(insertQuery);
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            System.out.println("Inserted a new record! New id: " + rs.getLong(1));
            return rs.getLong(1);
        }
        return null;
    }
}
