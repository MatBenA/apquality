package com.matbena.apquality.service;

import com.matbena.apquality.web.dto.BookingTypeDTO;

import java.util.List;

public interface BookingTypeService {
    BookingTypeDTO createBookingType(BookingTypeDTO bookingTypeDTO);

    List<BookingTypeDTO> findAllBookingTypes();

    BookingTypeDTO findBookingType(String name);

    BookingTypeDTO updateBookingType(BookingTypeDTO bookingTypeDTO);

    Boolean deleteBookingType(String name);
}
