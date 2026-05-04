package org.example.transport_management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categorys")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServiceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên loại dịch vụ không được để trống")
    @Size(min = 3, max = 100, message = "Tên loại dịch vụ phải từ 3 đến 100 ký tự")
    private String name;

    @NotNull(message = "Giá cước mở cửa không được để trống")
    private Double baseFare;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles;
}
