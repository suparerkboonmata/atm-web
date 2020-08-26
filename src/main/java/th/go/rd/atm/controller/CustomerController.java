package th.go.rd.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;

@Controller
public class CustomerController {
    @RequestMapping("/customer")
    public String getCustomerPage(Model model){
        ArrayList<String> customers = new ArrayList<>();
        customers.add("Superman");
        customers.add("SuperGirl");
        customers.add("Batman");
        model.addAttribute("allCustomers", customers);
        return "customer";
    }
}
