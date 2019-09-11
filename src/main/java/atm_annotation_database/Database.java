package atm_annotation_database;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
@Component
@Primary
public class Database implements Reader{

    Map<Integer, Customer> customers = new HashMap<Integer, Customer>();

    public Map<Integer, Customer> readCustomers() throws IOException {
        try {
            // setup
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:atm_database.db";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                String query = "Select * from database";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    int user = resultSet.getInt(1);
                    int pin = resultSet.getInt(2);
                    double money = resultSet.getDouble(3);
                    Customer c = new Customer(user,pin,money);
                    customers.put(c.getCustomerNumber(), c);
                }
                conn.close();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return  customers;
    }
}
