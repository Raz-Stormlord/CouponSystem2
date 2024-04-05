package com.jb.coupon_system_2.data.entity;import org.springframework.boot.autoconfigure.domain.EntityScan;import java.time.LocalDate;import java.util.HashSet;import java.util.Set;import java.util.UUID;import jakarta.persistence.Column;import jakarta.persistence.Entity;import jakarta.persistence.GeneratedValue;import jakarta.persistence.GenerationType;import jakarta.persistence.Id;import jakarta.persistence.JoinColumn;import jakarta.persistence.ManyToMany;import jakarta.persistence.ManyToOne;import lombok.AllArgsConstructor;import lombok.Builder;import lombok.Getter;import lombok.NoArgsConstructor;import lombok.Setter;@Entity@NoArgsConstructor@AllArgsConstructor@Builder@Getter@Setter@EntityScanpublic class Coupon {    @Id    @GeneratedValue(strategy = GenerationType.UUID)    private UUID couponId;    @Column(nullable = false)    private String name;    @Column(nullable = false, columnDefinition = "INT")    private int quantity;    @Column(nullable = false)    private LocalDate expirationDate;    @Column(nullable = false)    private int price;    @Column(nullable = false)    private String image;    @Column(nullable = false)    private String description;    @ManyToOne    @JoinColumn(name = "company_id", nullable = false)    private Company company;    @ManyToMany(mappedBy = "purchasedCoupons")    private Set<Customer> customers = new HashSet<>();}