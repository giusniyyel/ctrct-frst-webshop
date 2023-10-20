package com.giusniyyel.ctrctfrstwebshop.infrastructure.adapter;

import com.giusniyyel.ctrctfrstwebshop.domain.dto.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerCrudRepository extends CrudRepository<CustomerEntity, Integer> {}
