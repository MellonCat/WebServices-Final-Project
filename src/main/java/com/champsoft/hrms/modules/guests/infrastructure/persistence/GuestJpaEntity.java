package com.champsoft.hrms.modules.guests.infrastructure.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "guests")
public class GuestJpaEntity {

    @Id
    public String id;

    @Column(name = "full_name", nullable = false)
    public String fullName;

    @Column(name = "address")
    public String address;

    @Column(nullable = false)
    public String status;
}