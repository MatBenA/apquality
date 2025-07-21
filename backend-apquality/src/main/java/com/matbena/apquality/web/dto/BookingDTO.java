package com.matbena.apquality.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BookingDTO(LocalDateTime createdAt,
                         LocalDateTime updatedAt,
                         LocalDateTime bookedTime,
                         BigDecimal totalPrice,
                         String details,
                         String clientName,
                         String clientAddress,
                         String clientPhone,
                         String manager,
                         String bookingType,
                         BigDecimal extraFee,
                         ServiceDTO serviceList) {
}
