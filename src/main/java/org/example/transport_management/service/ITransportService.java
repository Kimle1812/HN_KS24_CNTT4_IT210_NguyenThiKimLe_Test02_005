package org.example.transport_management.service;

import org.example.transport_management.model.ServiceCategory;
import org.example.transport_management.model.Vehicle;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ITransportService {
    Page<Vehicle> findPaginated(int pageNumber, int pageSize);
    List<Vehicle> findAll();
    Vehicle save(Vehicle vehicle);
    Vehicle findById(Long id);
    void deleteById(Long id);
    List<ServiceCategory> findAllCategories();
    ServiceCategory findCategoryById(Long id);
}
