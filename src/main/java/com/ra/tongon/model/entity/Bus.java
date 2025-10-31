package com.ra.tongon.model.entity;

import com.ra.tongon.validate.Unique;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "buses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Integer busId;
    @Column(name = "bus_name",length = 100,nullable = false,unique = true)
    private String busName;
    @Column(name = "registration_number",length = 30,nullable = false,unique = true)
    private String registrationNumber;
    @Column(name = "total_seats",nullable = false)
    private int totalSeats;
    @Column(name = "image_bus",length = 255)
    private String imageBus;
    @Column(name = "status",columnDefinition = "BIT DEFAULT 1",nullable = false)
    private Boolean status = true;
}
