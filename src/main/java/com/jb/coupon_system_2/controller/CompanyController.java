package com.jb.coupon_system_2.controller;import com.jb.coupon_system_2.data.dto.CouponDto;import com.jb.coupon_system_2.data.dto.Login;import com.jb.coupon_system_2.service.CompanyService;import com.jb.coupon_system_2.session.ClientSession;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.HttpHeaders;import org.springframework.http.HttpStatus;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.DeleteMapping;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.PutMapping;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RequestHeader;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RestController;import java.util.UUID;@RestController@RequestMapping("/api/company")public class CompanyController {    private final CompanyService companyService;    @Autowired    public CompanyController(CompanyService companyService) {        this.companyService = companyService;    }    @GetMapping("/all/{companyId}/{token}")    public ResponseEntity<CouponDto> findCoupon(            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,            @PathVariable UUID companyId) {        ClientSession session = ClientSession.getSession(token);        if(session==null || session.isAuthorizedAccess()) {            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();        }        CouponDto coupon = companyService.findCouponByCouponId(companyId);        return ResponseEntity.ok(coupon);    }    @PostMapping("/create/{companyId}/{token}")    public ResponseEntity<CouponDto> createCoupon(            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,            @PathVariable UUID companyId,            @RequestBody CouponDto couponDto) {        ClientSession session = ClientSession.getSession(token);        if(session==null || session.isAuthorizedAccess()) {            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();        }        CouponDto createdCoupon = companyService.createCoupon(companyId, couponDto);        return ResponseEntity.status(HttpStatus.CREATED).body(createdCoupon);    }    @DeleteMapping("/delete/{couponId}/{token}")    public ResponseEntity<Void> deleteCoupon(            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,            @PathVariable String couponId) {        ClientSession session = ClientSession.getSession(token);        if(session==null || session.isAuthorizedAccess()) {            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();        }        companyService.deleteCoupon(couponId);        return ResponseEntity.noContent().build();    }    @PutMapping("/update-amount/{couponId}/{token}")    public ResponseEntity<CouponDto> updateCouponQuantity(            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,            @PathVariable String couponId,            @RequestBody int newQuantity) throws ControllerAdvice.InvalidQuantityException {        ClientSession session = ClientSession.getSession(token);        if(session==null || session.isAuthorizedAccess()) {            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();        }        CouponDto updatedCoupon = companyService.updateCouponQuantity(couponId, newQuantity);        return ResponseEntity.status(HttpStatus.OK).body(updatedCoupon);    }    @PostMapping("/login")    public ResponseEntity<String> login(            @RequestBody Login login) {        String token = companyService.login(login);        return ResponseEntity.status(HttpStatus.CREATED).body(token);    }}