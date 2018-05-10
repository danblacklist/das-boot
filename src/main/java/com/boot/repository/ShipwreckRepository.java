package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.model.Shipwreck;

@Repository
public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long>{}
