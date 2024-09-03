package db;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private static DBConnection instance;

    public List<Customer> customerList;
    private DBConnection(){
        this.customerList = new ArrayList<>();
    }
    public static DBConnection getInstance(){
        if(instance==null){
            instance = new DBConnection();
        }
        return instance;
    }
    public List<Customer> getConnection(){
        return customerList;
    }
}
