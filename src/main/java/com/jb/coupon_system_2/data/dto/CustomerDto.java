package com.jb.coupon_system_2.data.dto;import java.util.UUID;import lombok.Data;@Datapublic class CustomerDto {    private UUID customerId;    private String firstName;    private String lastName;    private String email;    private String password;}