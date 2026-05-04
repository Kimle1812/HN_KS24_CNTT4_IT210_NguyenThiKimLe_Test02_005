package org.example.transport_management.repository;

import org.example.transport_management.model.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceCategoryRepository extends JpaRepository<ServiceCategory, Long> {
}
