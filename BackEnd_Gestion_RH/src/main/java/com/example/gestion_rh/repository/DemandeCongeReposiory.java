package com.example.gestion_rh.repository;

import com.example.gestion_rh.entities.DemandeConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeCongeReposiory extends JpaRepository<DemandeConge,Long> {
}
