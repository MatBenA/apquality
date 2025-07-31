package com.matbena.apquality.service;

import com.matbena.apquality.web.dto.BookingDTO;
import com.matbena.apquality.web.dto.BookingRequestDTO;

import java.util.List;

public interface BookingService {
    BookingDTO createBooking(BookingRequestDTO bookingRequestDTO);
    List<BookingDTO> findAllBookings(); //THEN ADD A FIND ALL BY FILTER
    BookingDTO findBooking(Long id);
    BookingDTO updateBooking(BookingDTO bookingDTO);
    Boolean deleteBooking(Long id);
}