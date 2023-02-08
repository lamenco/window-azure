package com.example.demo.repository;

import com.example.demo.models.entity.Colors;
import com.example.demo.models.enums.ColorsEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColorRepository extends JpaRepository<Colors,Long> {
    Optional<Colors> findByColor(ColorsEnum color);
}
