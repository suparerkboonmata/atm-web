package th.go.rd.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.go.rd.atm.model.Customer;
import th.go.rd.atm.service.CustomerService;

@Controller
@RequestMapping("/customer")

public class CustomerController {

   private CustomerService customerservice;

   public CustomerController(CustomerService customerservice){
       this.customerservice = customerservice;
   }

    @GetMapping
    public String getCustomerPage(Model model){

        model.addAttribute("allCustomers", customerservice.getCustomer());
        return "customer";
    }

    @PostMapping
    public String registerCustomer(@ModelAttribute Customer customer, Model model){
        customerservice.createCustomer(customer);
        model.addAttribute("allCustomers",customerservice.getCustomer());
        return "redirect:customer";
    }
}
