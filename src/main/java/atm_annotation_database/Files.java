package atm_annotation_database;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Files implements Reader {
    private  String filename;

    public Files(String filename){
        this.filename = filename;
    }
    public Map<Integer, atm_annotation_database.Customer> readCustomers() throws IOException {
        Map<Integer, atm_annotation_database.Customer> customers = new HashMap<Integer, atm_annotation_database.Customer>();

        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNext()) {
            int user = in.nextInt();
            int pin = in.nextInt();
            double money = in.nextDouble();
            atm_annotation_database.Customer c = new atm_annotation_database.Customer(user, pin, money);
            customers.put(c.getCustomerNumber(), c);
        }
        in.close();
        return customers;
    }
}
