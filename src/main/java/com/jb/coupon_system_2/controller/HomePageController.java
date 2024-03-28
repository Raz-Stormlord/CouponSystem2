package com.jb.coupon_system_2.controller;

import com.jb.coupon_system_2.data.entity.Coupon;
import com.jb.coupon_system_2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomePageController {

    private final UserService userService;

    public HomePageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String getHomePage(Model model) {
        String userEmail = userService.getCurrentUserEmail(); // Get user email from the UserService
        List<Coupon> purchasedCoupons = userService.getPurchasedCoupons(); // Get purchased coupons from the UserService
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("purchasedCoupons", purchasedCoupons);
        return "home-page";
    }
}