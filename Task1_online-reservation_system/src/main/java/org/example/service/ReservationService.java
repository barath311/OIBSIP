package org.example.service;
import org.example.entity.Reservation;
import org.example.repository.ReservationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.dto.CancellationRequest;
import org.example.dto.ReservationRequest;
import java.util.UUID;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public String bookReservation(ReservationRequest request) {
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(request, reservation);
        reservation.setPnr(UUID.randomUUID().toString().substring(0, 10).toUpperCase());
        reservationRepository.save(reservation);
        return reservation.getPnr();
    }

    public Reservation cancelReservation(String pnr) {
        Reservation reservation = reservationRepository.findByPnr(pnr)
                .orElseThrow(() -> new RuntimeException("PNR not found"));
        reservationRepository.delete(reservation);
        return reservation;
    }
}
