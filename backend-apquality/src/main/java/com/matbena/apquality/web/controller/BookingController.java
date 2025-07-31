package com.matbena.apquality.web.controller;

import com.matbena.apquality.service.BookingService;
import com.matbena.apquality.web.dto.BookingDTO;
import com.matbena.apquality.web.dto.BookingRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/create")
    public BookingDTO createBooking(@RequestBody BookingRequestDTO bookingDTO){
        return bookingService.createBooking(bookingDTO);
    }

    @GetMapping
    public List<BookingDTO> getAllBookings(){
        return bookingService.findAllBookings();
    }

    @GetMapping("/{id}")
    public BookingDTO getBookingById(@PathVariable Long id){
        return bookingService.findBooking(id);
    }

    @PutMapping("/update")
    public BookingDTO updateBooking(@RequestBody BookingDTO bookingDTO){
        return bookingService.updateBooking(bookingDTO);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteBooking(@PathVariable Long id){
        return bookingService.deleteBooking(id);
    }
}
