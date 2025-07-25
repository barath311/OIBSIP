package org.example.controller;

import org.example.dto.CancellationRequest;
import org.example.dto.ReservationRequest;
import org.example.entity.Reservation;
import org.example.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(@RequestBody ReservationRequest request) {
        String pnr = reservationService.bookReservation(request);
        return ResponseEntity.ok("Booked! PNR: " + pnr);
    }

    @PostMapping("/cancel")
    public ResponseEntity<?> cancelTicket(@RequestBody CancellationRequest request) {
        Reservation r = reservationService.cancelReservation(request.getPnr());
        return ResponseEntity.ok("Cancelled Ticket for: " + r.getPassengerName());
    }
}
