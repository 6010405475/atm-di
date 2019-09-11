package atm_annotation_database;

import java.io.IOException;
import java.util.Map;

public interface Reader {
    public Map<Integer, Customer> readCustomers() throws IOException;
}
