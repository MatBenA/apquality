package com.matbena.apquality.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record BookingDTO(Long id,
                         LocalDateTime createdAt,
                         LocalDateTime updatedAt,
                         LocalDateTime bookedTime,
                         BigDecimal totalPrice,
                         String details,
                         String clientName,
                         String clientAddress,
                         String clientPhone,
                         String state,
                         SelectOptionDTO manager,
                         BookingTypeDTO bookingType,
                         List<SalonServiceDTO> salonServiceList) {
}
