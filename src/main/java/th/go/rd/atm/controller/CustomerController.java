package th.go.rd.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;

@Controller
public class CustomerController {
    @RequestMapping("/customer")
    public String getCustomerPage(Model model){
        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(1,"Superman",1111));
        customers.add(new Customer(2,"SuperGirl",2222));
        customers.add(new Customer(3,"Batman",3333));
        model.addAttribute("allCustomers", customers);
        return "customer";
    }
}
