package com.example.demo.repository;

import com.example.demo.models.entity.Chambers;
import com.example.demo.models.enums.ChamberEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChamberRepository extends JpaRepository<Chambers,Long> {
    Optional<Chambers> findByChamber(ChamberEnum chamber);
}
