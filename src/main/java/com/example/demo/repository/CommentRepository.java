package com.example.demo.repository;

import com.example.demo.models.entity.Comment;
import com.example.demo.models.entity.Model;
import com.example.demo.models.enums.ModelEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByModelOrderByCreated(String model);
//    @Query("select s, u from Song s join s.users u on u.id = :id")
    @Query("SELECT c FROM Comment c where c.model.model = :model")
    Optional<List<Comment>> findCommentsByModel_Model(ModelEnum model);
 }
