package com.giusniyyel.ctrctfrstwebshop.domain.dto;

import com.giusniyyel.ctrctfrstwebshop.domain.enums.Gender;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstname;

    private String lastname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateofbirth")
    private LocalDateTime dateOfBirth;

    @Column(name = "currentaddressid")
    private Integer currentAddressId;

    private LocalDateTime created;

    private LocalDateTime updated;
}
