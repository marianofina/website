package com.eme.personalwebsite.repositories;

import com.eme.personalwebsite.models.MensajeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMensajeRepository extends JpaRepository<MensajeModel, Integer> {

}
