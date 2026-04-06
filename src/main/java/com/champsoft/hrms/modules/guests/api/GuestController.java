package com.champsoft.hrms.modules.guests.api;

import com.champsoft.hrms.modules.guests.api.dto.*;
import com.champsoft.hrms.modules.guests.api.mapper.GuestApiMapper;
import com.champsoft.hrms.modules.guests.application.service.GuestCrudService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private final GuestCrudService service;

    public GuestController(GuestCrudService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateGuestRequest req) {
        var g = service.create(req.fullName(), req.address());
        return ResponseEntity.ok(GuestApiMapper.toResponse(g));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        return ResponseEntity.ok(GuestApiMapper.toResponse(service.getById(id)));
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(
                service.list().stream().map(GuestApiMapper::toResponse).toList()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody @Valid UpdateGuestRequest req) {
        var g = service.update(id, req.fullName(), req.address());
        return ResponseEntity.ok(GuestApiMapper.toResponse(g));
    }

    @PostMapping("/{id}/activate")
    public ResponseEntity<?> activate(@PathVariable String id) {
        var g = service.activate(id);
        return ResponseEntity.ok(GuestApiMapper.toResponse(g));
    }

    @PostMapping("/{id}/suspend")
    public ResponseEntity<?> suspend(@PathVariable String id) {
        var g = service.suspend(id);
        return ResponseEntity.ok(GuestApiMapper.toResponse(g));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}