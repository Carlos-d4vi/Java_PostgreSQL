import java.sql.Connection;
import java.sql.DriverManager;

public class Connectionfactory {

    private static String dbUrl;
    private static String dbUser;
    private static String dbPassword;

    public Connectionfactory(String url, String user, String password){
        dbUrl = url;
        dbUser = user;
        dbPassword = password;
    }

    public Connection connect_to_db(){
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);

            if (connection != null){
                System.out.println("connected");
            }else{
                System.out.println("failed");
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }
}
