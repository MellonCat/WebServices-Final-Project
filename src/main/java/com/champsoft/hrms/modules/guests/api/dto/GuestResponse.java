package com.champsoft.hrms.modules.guests.api.dto;

public record GuestResponse(
        String id,
        String fullName,
        String address,
        String status) {}