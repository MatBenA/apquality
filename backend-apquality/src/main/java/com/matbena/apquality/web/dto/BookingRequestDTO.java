package com.matbena.apquality.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record BookingRequestDTO(LocalDateTime bookedTime,
                                String details,
                                String clientName,
                                String clientAddress,
                                String clientPhone,
                                String bookingType,
                                List<String> serviceList) {
}
