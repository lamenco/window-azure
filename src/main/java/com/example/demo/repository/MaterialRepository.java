package com.example.demo.repository;

import com.example.demo.models.entity.Material;
import com.example.demo.models.enums.MaterialEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterialRepository extends JpaRepository<Material,Long> {
    Optional<Material> findByMaterial(MaterialEnum material);
}
