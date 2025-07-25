package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    private String passengerName;
    private String trainNumber;
    private String classType;
    private String fromPlace;
    private String toPlace;
    private LocalDate journeyDate;
}
