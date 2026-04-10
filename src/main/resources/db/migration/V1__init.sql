-- Flyway init schema (tables for rooms/guests/payments/bookings)
-- H2-compatible in-memory database

CREATE TABLE IF NOT EXISTS rooms (
    id VARCHAR(36) PRIMARY KEY,
    room_number VARCHAR(20) NOT NULL UNIQUE,
    room_type VARCHAR(20) NOT NULL,
    price_per_night DOUBLE NOT NULL,
    status VARCHAR(20) NOT NULL
    );

CREATE TABLE IF NOT EXISTS guests (
    id VARCHAR(36) PRIMARY KEY,
    full_name VARCHAR(120) NOT NULL,
    address VARCHAR(255),
    status VARCHAR(20) NOT NULL
    );

CREATE TABLE IF NOT EXISTS payments (
                                        id VARCHAR(36) PRIMARY KEY,
    amount DOUBLE NOT NULL,
    type VARCHAR(20) NOT NULL,
    card_number VARCHAR(32) NOT NULL,
    expiry_date VARCHAR(10) NOT NULL,
    status VARCHAR(20) NOT NULL
    );

CREATE TABLE IF NOT EXISTS bookings (
                                        id VARCHAR(36) PRIMARY KEY,
    room_id VARCHAR(36) NOT NULL,
    guest_id VARCHAR(36) NOT NULL,
    payment_id VARCHAR(36) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL,

    CONSTRAINT fk_bookings_room FOREIGN KEY (room_id) REFERENCES rooms(id),
    CONSTRAINT fk_bookings_guest FOREIGN KEY (guest_id) REFERENCES guests(id),
    CONSTRAINT fk_bookings_payment FOREIGN KEY (payment_id) REFERENCES payments(id)
    );

-- Helpful indexes for performance
CREATE INDEX IF NOT EXISTS idx_bookings_room_id ON bookings(room_id);
CREATE INDEX IF NOT EXISTS idx_bookings_guest_id ON bookings(guest_id);
CREATE INDEX IF NOT EXISTS idx_bookings_payment_id ON bookings(payment_id);

-- =========================
-- SAMPLE DATA
-- =========================

INSERT INTO rooms (id, room_number, room_type, price_per_night, status) VALUES
                                                                            ('room-1', '101', 'SINGLE', 120.0, 'AVAILABLE'),
                                                                            ('room-2', '102', 'DOUBLE', 150.0, 'AVAILABLE'),
                                                                            ('room-3', '103', 'SUITE', 250.0, 'AVAILABLE'),
                                                                            ('room-4', '104', 'SINGLE', 110.0, 'AVAILABLE'),
                                                                            ('room-5', '105', 'DOUBLE', 160.0, 'AVAILABLE');

INSERT INTO guests (id, full_name, address, status) VALUES
                                                      ('guest-1', 'John Smith', 'Brossard, QC', 'ACTIVE'),
                                                      ('guest-2', 'Sarah Johnson', 'Longueuil, QC', 'ACTIVE'),
                                                      ('guest-3', 'Michael Brown', 'Brossard, QC', 'ACTIVE'),
                                                      ('guest-4', 'Emily Davis', 'Montreal, QC', 'ACTIVE'),
                                                      ('guest-5', 'David Wilson', 'Longueuil, QC', 'ACTIVE');

INSERT INTO payments (id, amount, type, card_number, expiry_date, status) VALUES
                                                                              ('pay-1', 200.0, 'DEBIT', '4111151111111111', '12/26', 'COMPLETED'),
                                                                              ('pay-2', 300.0, 'DEBIT', '4111161111111111', '11/26', 'COMPLETED'),
                                                                              ('pay-3', 150.0, 'DEBIT', '4111171111111111', '10/26', 'PENDING'),
                                                                              ('pay-4', 500.0, 'CREDIT', '4111181111111111', '09/26', 'COMPLETED'),
                                                                              ('pay-5', 220.0, 'CREDIT', '4111191111111111', '08/26', 'COMPLETED');

INSERT INTO bookings (id, room_id, guest_id, payment_id, start_date, end_date, status) VALUES
                                                                                           ('book-1', 'room-1', 'guest-1', 'pay-1', DATE '2026-05-01', DATE '2026-05-05', 'CONFIRMED'),
                                                                                           ('book-2', 'room-2', 'guest-2', 'pay-2', DATE '2026-06-10', DATE '2026-06-15', 'CONFIRMED'),
                                                                                           ('book-3', 'room-3', 'guest-3', 'pay-3', DATE '2026-07-01', DATE '2026-07-03', 'CREATED'),
                                                                                           ('book-4', 'room-4', 'guest-4', 'pay-4', DATE '2026-08-12', DATE '2026-08-18', 'CONFIRMED'),
                                                                                           ('book-5', 'room-5', 'guest-5', 'pay-5', DATE '2026-09-20', DATE '2026-09-25', 'CREATED');