public class main {
    public static void main(String[] args) {

     Connectionfactory connection = new Connectionfactory("jdbc:postgresql://localhost:5432/postgrees_java", "postgres", "d4vi1234)");

     connection.connect_to_db();
    }
}
