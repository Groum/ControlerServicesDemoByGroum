package com.example.H2implementation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<TekWishEntity, Long> {
    // Any additional custom methods can be defined here
}

