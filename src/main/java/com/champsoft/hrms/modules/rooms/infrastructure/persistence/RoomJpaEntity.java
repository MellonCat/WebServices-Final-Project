package com.champsoft.hrms.modules.rooms.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class RoomJpaEntity {
    @Id
    public String id;

    @Column(name = "room_number", nullable = false, unique = true)
    public String roomNumber;

    @Embedded
    public RoomDetailsEmbeddable specs;

    @Column(nullable = false)
    public String status;
}
