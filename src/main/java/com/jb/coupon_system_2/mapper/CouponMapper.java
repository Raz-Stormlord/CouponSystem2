package com.jb.coupon_system_2.mapper;import com.jb.coupon_system_2.data.dto.CouponDto;import com.jb.coupon_system_2.data.entity.Coupon;import org.mapstruct.Mapper;import java.util.List;@Mapper(componentModel = "spring")public interface CouponMapper {    Coupon toEntity(CouponDto dto);    CouponDto toDto(Coupon entity);    List<CouponDto> toDtoList(List<Coupon> coupons);}