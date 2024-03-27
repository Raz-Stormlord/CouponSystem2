package com.jb.coupon_system_2.data.entity;import org.springframework.boot.autoconfigure.domain.EntityScan;import java.util.List;import java.util.UUID;import jakarta.persistence.Column;import jakarta.persistence.Entity;import jakarta.persistence.GeneratedValue;import jakarta.persistence.GenerationType;import jakarta.persistence.Id;import jakarta.persistence.JoinColumn;import jakarta.persistence.JoinTable;import jakarta.persistence.ManyToMany;import lombok.AllArgsConstructor;import lombok.Builder;import lombok.Getter;import lombok.NoArgsConstructor;import lombok.Setter;@Entity@NoArgsConstructor@AllArgsConstructor@Builder@Getter@Setter@EntityScanpublic class Customer {    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)    private UUID customerId;    @Column(nullable = false)    private String firstName;    @Column(nullable = false)    private String lastName;    @Column(nullable = false, unique = true)    private String email;    @Column(nullable = false)    private String password;    @Getter    @ManyToMany    @JoinTable(            name = "customer_coupon",            joinColumns = @JoinColumn(name = "customer_id"),            inverseJoinColumns = @JoinColumn(name = "coupon_id")    )    private List<Coupon> purchasedCoupons;}