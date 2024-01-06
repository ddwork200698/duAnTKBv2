package com.doubleD.tkb.repos;

import com.doubleD.tkb.models.Objectm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObjectRepo extends JpaRepository<Objectm, Integer> {
    List<Objectm> findAll();
}
