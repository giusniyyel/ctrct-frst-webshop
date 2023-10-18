package com.giusniyyel.ctrctfrstwebshop.domain.dto;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customerid")
    private Integer customerId;

    private String firstname;

    private String lastname;

    private String address1;

    private String address2;

    private String city;

    private String zip;

    private LocalDateTime created;

    private LocalDateTime updated;
}
