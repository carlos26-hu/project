package config;

public class DataBaseConfig {
    public class DatabaseConfig {


        public static final String DB_USER ="jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=" +
                "UTC&allowMultiQueries=true";
        public static final String DB_Storage = "jdbc:mysql://localhost:3306/storage?useSSL=false&serverTimezone=" +
                "UTC&allowMultiQueries=true";
        public static final String USER = "root";
        public static final String PASSWORD = "Test123!";



    }
}
