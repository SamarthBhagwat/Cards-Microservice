package com.example.bankapplication.cards.repository;

import com.example.bankapplication.cards.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    Optional<Card> findByMobileNumber(String mobileNumber);
}
