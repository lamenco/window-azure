package com.example.demo.repository;

import com.example.demo.models.entity.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WindowOfferRepository extends JpaRepository<Window, Long> {
    List<Window> findByUserUsername(String username);
}
