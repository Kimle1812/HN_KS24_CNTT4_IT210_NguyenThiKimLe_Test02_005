package org.example.transport_management.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "vehicles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Biển số xe không được để trống")
    @Size(min = 5, max = 20, message = "Biển số xe phải từ 5 đến 20 ký tự")
    private String licensePlate;

    @NotBlank(message = "Tên tài xế không được để trống")
    private String driverName;

    @NotNull(message = "Năm sản xuất không được để trống")
    @Min(value = 1900, message = "Năm sản xuất không hợp lệ")
    private Integer manufactureYear;

    @NotNull(message = "Ngày đăng ký không được để trống")
    @PastOrPresent(message = "Ngày đăng ký không được là ngày trong tương lai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;

    private String vehicleImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ServiceCategory category;

    private Boolean isActive;
}
