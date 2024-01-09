package com.tabla.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tabla.proyecto.entity.Componente13;

@Repository("componente13Repository")
public interface Componente13Repository extends JpaRepository<Componente13, Long> {
}
