
package connectDB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class ConnectDB {
    private static final String USER_NAME = "sa";
    private static final String PASSWORD = "123456789";
    private static final String DATABASE_NAME = "Data_DichVuDL";
    private static final String SERVER_NAME = "LAPTOP-OMSDORKT\\SQLEXPRESS";
    private static final String PORT = "1433";

    private static final String DATABASE_URL = "jdbc:sqlserver://" + SERVER_NAME 
                    + ":" + PORT + ";databaseName=" + DATABASE_NAME + ";integratedSecurity=true";

    private static Connection connection;
    private static ConnectDB instance = new ConnectDB();

    public static ConnectDB getInstance() {
            return instance;
    }

    public static boolean connect() {
            try
            {
                    connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
                    if(connection != null)
                    {
                            System.out.println("Connect Database Success");
                            DatabaseMetaData databaseMetaData = (DatabaseMetaData)connection.getMetaData();
                            System.out.println("Driver name: " + databaseMetaData.getDriverName());
                            System.out.println("Driver version: " + databaseMetaData.getDriverVersion());
                            System.out.println("Product name: " + databaseMetaData.getDatabaseProductName());
                            System.out.println("Product version: " + databaseMetaData.getDatabaseProductVersion());
                    }
                    return true;
            }
            catch(Exception ex)
            {
                    ex.printStackTrace();
                    return false;
            }
    }

    public static boolean disconnect() {
            try
            {
                    if(connection != null)
                            connection.close();
                    return true;
            }
            catch(Exception ex)
            {
                    ex.printStackTrace();
                    return false;
            }
    }

    public static Connection getConnection() {
            return connection;
    }
}
