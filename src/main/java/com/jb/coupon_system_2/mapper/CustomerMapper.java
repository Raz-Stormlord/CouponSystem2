package com.jb.coupon_system_2.mapper;import com.jb.coupon_system_2.data.dto.CustomerDto;import com.jb.coupon_system_2.data.entity.Customer;import org.mapstruct.Mapper;@Mapper(componentModel = "spring")public interface CustomerMapper {    Customer toEntity(CustomerDto dto);    CustomerDto toDto(Customer entity);}