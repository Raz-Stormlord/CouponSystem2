package com.jb.coupon_system_2.service;import com.jb.coupon_system_2.controller.ControllerAdvice;import com.jb.coupon_system_2.data.dto.CompanyDto;import com.jb.coupon_system_2.data.dto.CouponDto;import com.jb.coupon_system_2.data.dto.Login;import com.jb.coupon_system_2.data.entity.Coupon;import com.jb.coupon_system_2.mapper.CompanyMapper;import com.jb.coupon_system_2.mapper.CouponMapper;import com.jb.coupon_system_2.repository.CompanyRepository;import com.jb.coupon_system_2.repository.CouponRepository;import com.jb.coupon_system_2.session.ClientSession;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.Optional;import java.util.UUID;import lombok.RequiredArgsConstructor;@Service@RequiredArgsConstructorpublic class CompanyServiceImpl implements CompanyService {    @Autowired    private CompanyRepository companyRepository;    @Autowired    private  CouponRepository couponRepository;    @Autowired    private  CouponMapper couponMapper;    @Autowired    private  CompanyMapper companyMapper;    @Override    public CouponDto findCoupon(UUID id) {        return companyRepository.findCoupon(id)                .map(couponMapper::toDto)                .orElseThrow(() -> new ControllerAdvice.NoSuchCompanyException(String.format(                        "Error 400 - no match found for %s",                        id.toString())));    }    @Override    public CouponDto createCoupon(UUID companyId, CouponDto couponDto) {        String name = couponDto.getName();        Optional<Coupon> existingCoupon = couponRepository.findCouponByName(name);        if (existingCoupon.isPresent()) {            throw new ControllerAdvice.CouponAlreadyExistsException("Error 400 - coupon already exists");        }        Coupon newCoupon = couponMapper.toEntity(couponDto);        Coupon savedCoupon = couponRepository.save(newCoupon);        CouponDto savedCouponDto = couponMapper.toDto(savedCoupon);        return savedCouponDto;    }    @Override    public void deleteCoupon(String name) {        Optional<Coupon> existingCoupon = couponRepository.findCouponByName(name);        if (existingCoupon.isPresent()) {            couponRepository.delete(existingCoupon.get());        } else {            throw new ControllerAdvice.NoSuchCouponException("Error 400 - no match found for" + name);        }    }    @Override    public CouponDto updateCouponQuantity(String name,                                          int newQuantity) throws ControllerAdvice.InvalidQuantityException {        Optional<Coupon> optionalCoupon = couponRepository.findCouponByName(name);        if (optionalCoupon.isPresent()) {            Coupon coupon = optionalCoupon.get();            coupon.setQuantity(newQuantity);            if (newQuantity < 1) {                throw new ControllerAdvice.InvalidQuantityException("Error 400 - invalid quantity");            }            Coupon updatedCoupon = couponRepository.save(coupon);            return couponMapper.toDto(updatedCoupon);        } else {            throw new ControllerAdvice.NoSuchCouponException("Error 400 - no match found for couponName: " + name);        }    }    @Override    public String login(Login login) {        CompanyDto c= companyRepository.findCompany(login.getUsername(), login.getPassword())                .map(companyMapper::toDto)                .orElseThrow(() -> new ControllerAdvice.NoSuchCompanyException(String.format(                        "Error 400 - no match found for %s",                        login.getUsername())));        String token = System.currentTimeMillis()+"";        ClientSession clientSession = ClientSession.createSession(token, c.getId(), ClientSession.ClientType.Comapny);        return token;    }}