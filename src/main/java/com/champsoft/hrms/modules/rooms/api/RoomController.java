package com.champsoft.hrms.modules.rooms.api;

import com.champsoft.hrms.modules.rooms.api.dto.CreateRoomRequest;
import com.champsoft.hrms.modules.rooms.api.dto.UpdateRoomRequest;
import com.champsoft.hrms.modules.rooms.api.mapper.RoomApiMapper;
import com.champsoft.hrms.modules.rooms.application.service.RoomCrudService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomCrudService service;

    public RoomController(RoomCrudService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateRoomRequest req) {
        var room = service.create(req.roomNumber(), req.pricePerNight(), req.roomType());
        return ResponseEntity.ok(RoomApiMapper.toResponse(room));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        var room = service.getById(id);
        return ResponseEntity.ok(RoomApiMapper.toResponse(room));
    }

    @GetMapping
    public ResponseEntity<?> list() {
        var data = service.list().stream().map(RoomApiMapper::toResponse).toList();
        return ResponseEntity.ok(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody @Valid UpdateRoomRequest req) {
        var room = service.updateDetails(id, req.pricePerNight(), req.roomType());
        return ResponseEntity.ok(RoomApiMapper.toResponse(room));
    }

    @PostMapping("/{id}/occupy")
    public ResponseEntity<?> occupy(@PathVariable String id) {
        var room = service.occupy(id);
        return ResponseEntity.ok(RoomApiMapper.toResponse(room));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}