package com.matbena.apquality.web.controller;

import com.matbena.apquality.service.BookingTypeService;
import com.matbena.apquality.web.dto.BookingTypeDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/booking-types")
public class BookingTypeController {

    private final BookingTypeService bookingTypeService;

    @PostMapping("/create")
    public BookingTypeDTO createBookingType(@RequestBody BookingTypeDTO bookingTypeDTO){
        return bookingTypeService.createBookingType(bookingTypeDTO);
    }

    @GetMapping
    public List<BookingTypeDTO> getAllBookingTypes(){
        return bookingTypeService.findAllBookingTypes();
    }

    @GetMapping("/{name}")
    public BookingTypeDTO getBookingTypeByName(@PathVariable String name){
        return bookingTypeService.findBookingType(name);
    }

    @PutMapping("/update")
    public BookingTypeDTO updateBookingType(@RequestBody BookingTypeDTO bookingTypeDTO){
        return bookingTypeService.updateBookingType(bookingTypeDTO);
    }

    @DeleteMapping("/delete/{name}")
    public Boolean deleteBookingType(@PathVariable String name){
        return bookingTypeService.deleteBookingType(name);
    }
}
