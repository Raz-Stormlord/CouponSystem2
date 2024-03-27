package com.jb.coupon_system_2.controller;import com.jb.coupon_system_2.data.dto.CouponDto;import com.jb.coupon_system_2.data.dto.Login;import com.jb.coupon_system_2.service.CompanyService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.HttpStatus;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.DeleteMapping;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.PutMapping;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RestController;@RestController@RequestMapping("/api/company")public class CompanyController {    private final CompanyService companyService;    @Autowired    public CompanyController(CompanyService companyService) {        this.companyService = companyService;    }    @GetMapping("/findCoupon/{companyId}")    public ResponseEntity<CouponDto> findCoupon(            @PathVariable long companyId) {        CouponDto coupon = companyService.findCoupon(companyId);        return ResponseEntity.ok(coupon);    }    @PostMapping("/createCoupon/{companyId}")    public ResponseEntity<CouponDto> createCoupon(            @PathVariable long companyId,            @RequestBody CouponDto couponDto) {        CouponDto createdCoupon = companyService.createCoupon(companyId, couponDto);        return ResponseEntity.status(HttpStatus.CREATED).body(createdCoupon);    }    @DeleteMapping("/deleteCoupon/{couponName}")    public ResponseEntity<Void> deleteCoupon(            @PathVariable String couponName) {        companyService.deleteCoupon(couponName);        return ResponseEntity.noContent().build();    }    @PutMapping("/updateCouponQuantity/{couponName}/{newQuantity}")    public ResponseEntity<CouponDto> updateCouponQuantity(            @PathVariable String couponName,            @PathVariable int newQuantity) throws ControllerAdvice.InvalidQuantityException {        CouponDto updatedCoupon = companyService.updateCouponQuantity(couponName, newQuantity);        return ResponseEntity.ok(updatedCoupon);    }    @PostMapping("/login")    public ResponseEntity<String> login(            @RequestBody Login login) {        String token = companyService.login(login);        return ResponseEntity.status(HttpStatus.CREATED).body(token);    }}