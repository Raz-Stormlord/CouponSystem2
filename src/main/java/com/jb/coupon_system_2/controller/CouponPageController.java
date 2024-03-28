package com.jb.coupon_system_2.controller;

import com.jb.coupon_system_2.data.entity.Coupon;
import com.jb.coupon_system_2.service.CouponService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CouponPageController {

    private final CouponService couponService;

    public CouponPageController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/coupon-page")
    public String getCouponPage(Model model) {
        List<Coupon> coupons = couponService.getAllCoupons(); // Modify this method according to your service
        model.addAttribute("coupons", coupons);
        return "coupon-page";
    }
}