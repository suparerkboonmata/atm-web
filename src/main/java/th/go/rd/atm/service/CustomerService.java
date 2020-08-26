package th.go.rd.atm.service;

import org.springframework.stereotype.Service;
import th.go.rd.atm.model.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private ArrayList<Customer> customerList;

    @PostConstruct
    public void postConstruct(){
        this.customerList = new ArrayList<Customer>();
    }

    public void createCustomer(Customer customer){
        //... hash pin ....
        customerList.add(customer);

    }

    public List<Customer> getCustomer(){
        return new ArrayList<Customer>(this.customerList);
    }



}
