import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLJDBCTest {
    public static Connection connect() throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(
          Config.getUrl(),
          Config.getUser(),
          Config.getPassword()
        );
        return connection;
    }

    public static void main(String[] args) {
        try {
            Connection connection = connect();
            System.out.println("Connection Successful");
            Statement statement = connection.createStatement();
            String queryString = "SELECT * FROM albums";
            ResultSet results = statement.executeQuery(queryString);
                    if(results != null) {
                        System.out.println("Successful Connection");
                        System.out.println();
                        System.out.println("Here are the artists and album names:");
                        System.out.println();
                        while (results.next()) {
//                            System.out.println(results.getInt("id"));
                            System.out.println("Artist: " + results.getString("artist_name"));
                            System.out.println("Album: " + results.getString("record_name"));
                            System.out.println("Year released: " + results.getString("release_date"));
                            System.out.println();
                        }
                        System.out.println("No more albums to display");
                    } else
                        System.out.println("something exploded");
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }


}
