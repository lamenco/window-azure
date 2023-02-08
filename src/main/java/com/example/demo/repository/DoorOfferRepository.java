package com.example.demo.repository;

import com.example.demo.models.entity.Door;
import com.example.demo.models.entity.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoorOfferRepository extends JpaRepository<Door,Long> {
    List<Door> findByUserUsername(String username);
}
