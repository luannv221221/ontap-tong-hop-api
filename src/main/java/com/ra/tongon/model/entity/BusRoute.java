package com.ra.tongon.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bus_route")
public class BusRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_route_id")
    private int busRouteId;
    @Column(name = "start_point",nullable = false)
    private String startPoint;
    @Column(name = "end_point",nullable = false)
    private String endPoint;
    @Column(name = "trip_information",nullable = false)
    private String tripInformation;
    @Column(name = "driver_name",nullable = false,length = 70)
    private String driverName;
    @Column(name = "status",nullable = false)
    private Boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id", nullable = false,foreignKey = @ForeignKey(name = "fk_bus_route_buses"))
    private Bus bus;


}
