package com.giusniyyel.ctrctfrstwebshop.domain.dto;

import com.giusniyyel.ctrctfrstwebshop.domain.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "customer", schema = "webshop")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstname;

    private String lastname;

    private Gender gender;

    private String email;

    @Column(name = "dateofbirth")
    private Date dateOfBirth;

    @Column(name = "currentaddressid")
    private Integer currentAddressId;

    private Date created;

    private Date updated;
}
