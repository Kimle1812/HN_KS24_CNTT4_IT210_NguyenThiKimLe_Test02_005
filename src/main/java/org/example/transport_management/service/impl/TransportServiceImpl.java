package org.example.transport_management.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.transport_management.model.ServiceCategory;
import org.example.transport_management.model.Vehicle;
import org.example.transport_management.repository.IServiceCategoryRepository;
import org.example.transport_management.repository.ITransportRepository;
import org.example.transport_management.service.ITransportService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransportServiceImpl implements ITransportService {
    private final ITransportRepository transportRepository;
    private final IServiceCategoryRepository categoryRepository;

    @Override
    public Page<Vehicle> findPaginated(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return transportRepository.findAll(pageable);
    }

    @Override
    public List<Vehicle> findAll() {
        return transportRepository.findAll();
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return transportRepository.save(vehicle);
    }

    @Override
    public Vehicle findById(Long id) {
        return transportRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        transportRepository.deleteById(id);
    }

    @Override
    public List<ServiceCategory> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public ServiceCategory findCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}