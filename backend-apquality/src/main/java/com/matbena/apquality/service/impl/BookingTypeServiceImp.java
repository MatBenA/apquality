package com.matbena.apquality.service.impl;

import com.matbena.apquality.domain.model.BookingType;
import com.matbena.apquality.domain.repository.BookingTypeRepository;
import com.matbena.apquality.service.BookingTypeService;
import com.matbena.apquality.web.dto.BookingTypeDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookingTypeServiceImp implements BookingTypeService {

    private final BookingTypeRepository bookingTypeRepository;

    @Override
    public BookingTypeDTO createBookingType(BookingTypeDTO bookingTypeDTO) {
        BookingType bookingType = new BookingType();
        bookingType.setName(bookingTypeDTO.name());
        bookingType.setExtraFee(bookingTypeDTO.extraFee());
        return entityToDto(bookingTypeRepository.save(bookingType));
    }

    @Override
    public List<BookingTypeDTO> findAllBookingTypes() {
        return bookingTypeRepository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public BookingTypeDTO findBookingType(String name) {
        return entityToDto(bookingTypeRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("BookingType not found for name: " + name)));
    }

    @Override
    public BookingTypeDTO updateBookingType(BookingTypeDTO bookingTypeDTO) {
        BookingType bookingType = bookingTypeRepository.findByName(bookingTypeDTO.name())
                .orElseThrow(() -> new EntityNotFoundException("BookingType not found for name: " + bookingTypeDTO.name()));

        bookingType.setName(bookingTypeDTO.name());
        bookingType.setExtraFee(bookingTypeDTO.extraFee());

        return entityToDto(bookingTypeRepository.save(bookingType));
    }

    @Override
    public Boolean deleteBookingType(String name) {
        try {
            if (!bookingTypeRepository.existsByName(name)) {
                return false;
            }
            bookingTypeRepository.deleteByName(name);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public BookingTypeDTO entityToDto(BookingType bookingType){
        return new BookingTypeDTO(bookingType.getName(), bookingType.getExtraFee());
    }
}
