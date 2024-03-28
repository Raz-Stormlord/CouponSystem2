package com.jb.coupon_system_2.controller;

import com.jb.coupon_system_2.data.entity.Customer;
import com.jb.coupon_system_2.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CustomerPageController {

    private final CustomerService customerService;

    public CustomerPageController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/{id}")
    public String getCustomerDetails(@PathVariable("id") Long customerId, Model model) {
        Customer customer = customerService.getCustomerById(customerId); // Modify this method according to your service
        model.addAttribute("customer", customer);
        return "customer-details";
    }
}