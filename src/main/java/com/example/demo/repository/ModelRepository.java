package com.example.demo.repository;

import com.example.demo.models.entity.Model;
import com.example.demo.models.enums.ModelEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ModelRepository extends JpaRepository<Model,Long>{


    Optional<Model> findByModel(ModelEnum model);

}
