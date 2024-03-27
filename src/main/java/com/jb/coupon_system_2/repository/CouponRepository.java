package com.jb.coupon_system_2.repository;import com.jb.coupon_system_2.data.entity.Coupon;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.stereotype.Repository;import java.time.LocalDate;import java.util.List;import java.util.Optional;import java.util.UUID;@Repositorypublic interface CouponRepository extends JpaRepository<Coupon, UUID> {    Optional<Coupon> findCouponByName(String name);    List<Coupon> findByExpirationDate(LocalDate expirationDate);}