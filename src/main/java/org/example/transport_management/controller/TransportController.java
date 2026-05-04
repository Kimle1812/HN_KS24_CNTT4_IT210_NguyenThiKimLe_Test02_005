package org.example.transport_management.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.transport_management.model.Vehicle;
import org.example.transport_management.service.ITransportService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TransportController {
    private final ITransportService transportService;

    @GetMapping({"", "/", "/vehicles"})
    public String index(Model model, @RequestParam(defaultValue = "1") int page) {
        int pageSize = 5;
        Page<Vehicle> vehiclePage = transportService.findPaginated(page, pageSize);
        model.addAttribute("listVehicle", vehiclePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", vehiclePage.getTotalPages());
        model.addAttribute("totalItems", vehiclePage.getTotalElements());
        return "list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("categories", transportService.findAllCategories());
        return "add";
    }

    @PostMapping("/add")
    public String addVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", transportService.findAllCategories());
            return "add";
        }
        transportService.save(vehicle);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        Vehicle vehicle = transportService.findById(id);
        if (vehicle != null) {
            model.addAttribute("vehicle", vehicle);
            model.addAttribute("categories", transportService.findAllCategories());
            return "edit";
        }
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String updateVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle,
                                BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", transportService.findAllCategories());
            return "edit";
        }
        transportService.save(vehicle);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable("id") Long id) {
        transportService.deleteById(id);
        return "redirect:/";
    }
}