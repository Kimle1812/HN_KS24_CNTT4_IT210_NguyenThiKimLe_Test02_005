package org.example.transport_management.repository;

import org.example.transport_management.model.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransportRepository extends JpaRepository<Vehicle, Long> {
    Page<Vehicle> findAll(Pageable pageable);
}
