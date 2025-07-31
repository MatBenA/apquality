package com.matbena.apquality.service.impl;

import com.matbena.apquality.domain.model.Booking;
import com.matbena.apquality.domain.model.BookingType;
import com.matbena.apquality.domain.model.SalonService;
import com.matbena.apquality.domain.model.UserSec;
import com.matbena.apquality.domain.repository.BookingRepository;
import com.matbena.apquality.domain.repository.BookingTypeRepository;
import com.matbena.apquality.domain.repository.SalonServiceRepository;
import com.matbena.apquality.domain.repository.UserSecRepository;
import com.matbena.apquality.service.BookingService;
import com.matbena.apquality.service.UserSecService;
import com.matbena.apquality.web.dto.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookingServiceImp implements BookingService {
    private final BookingRepository bookingRepository;
    private final UserSecRepository userSecRepository;
    private final BookingTypeRepository bookingTypeRepository;
    private final SalonServiceRepository salonServiceRepository;

    @Override
    @Transactional
    public BookingDTO createBooking(BookingRequestDTO bookingRequestDTO) {
        Booking booking = new Booking();

        BookingType bookingType = bookingTypeRepository.findByName(bookingRequestDTO.bookingType())
                .orElseThrow(() -> new EntityNotFoundException("BookingType not found: " + bookingRequestDTO.bookingType()));

        List<SalonService> serviceList = bookingRequestDTO.serviceList()
                .stream()
                .map(service -> salonServiceRepository.findByName(service)
                        .orElseThrow(() -> new EntityNotFoundException("Service not found: " + service))
                ).toList();

        booking.setBookedTime(bookingRequestDTO.bookedTime());
        booking.setDetails(bookingRequestDTO.details());
        booking.setClientName(bookingRequestDTO.clientName());
        booking.setClientAddress(bookingRequestDTO.clientAddress());
        booking.setClientPhone(bookingRequestDTO.clientPhone());
        booking.setBookingType(bookingType);
        booking.setSalonServiceList(serviceList);

        Booking savedBooking = bookingRepository.save(booking);

        return entityToDto(savedBooking);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookingDTO> findAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BookingDTO findBooking(Long id) {
        return entityToDto(bookingRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found with id: " + id))
        );
    }

    @Override
    @Transactional
    public BookingDTO updateBooking(BookingDTO bookingDTO) {
        Booking booking = bookingRepository.findById(bookingDTO.id())
                .orElseThrow(() -> new EntityNotFoundException("Booking not found with id: " + bookingDTO.id()));

        UserSec manager = userSecRepository.findByEmail(bookingDTO.manager().value())
                .orElseThrow(() -> new EntityNotFoundException("User not found for email: " + bookingDTO.manager().value()));

        BookingType bookingType = bookingTypeRepository.findByName(bookingDTO.bookingType().name())
                .orElseThrow(() -> new EntityNotFoundException("BookingType not found: " + bookingDTO.bookingType().name()));

        List<SalonService> serviceList = bookingDTO.salonServiceList()
                .stream()
                .map(service -> salonServiceRepository.findByName(service.name())
                        .orElseThrow(() -> new EntityNotFoundException("Service not found for name: " + service.name()))
                ).toList();

        booking.setBookedTime(bookingDTO.bookedTime());
        booking.setTotalPrice(bookingDTO.totalPrice());
        booking.setDetails(bookingDTO.details());
        booking.setClientName(bookingDTO.clientName());
        booking.setClientAddress(bookingDTO.clientAddress());
        booking.setClientPhone(bookingDTO.clientPhone());
        booking.setManager(manager);
        booking.setBookingType(bookingType);
        booking.setSalonServiceList(serviceList);

        return entityToDto(bookingRepository.save(booking));
    }

    @Override
    @Transactional
    public Boolean deleteBooking(Long id) {
        try {
            if (!bookingRepository.existsById(id)) {
                return false;
            }
            bookingRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public BookingDTO entityToDto(Booking booking){
        List<SalonServiceDTO> salonServiceDTO = booking.getSalonServiceList()
                .stream()
                .map(service ->
                        new SalonServiceDTO(service.getName(), service.getPrice()))
                .toList();

        BookingTypeDTO bookingTypeDTO = new BookingTypeDTO(
                booking.getBookingType().getName(),
                booking.getBookingType().getExtraFee());

        SelectOptionDTO manager = new SelectOptionDTO(
                booking.getManager().getEmail(),
                booking.getManager().getFullName());

        return new BookingDTO(
                booking.getId(),
                booking.getCreatedAt(),
                booking.getUpdatedAt(),
                booking.getBookedTime(),
                booking.getTotalPrice(),
                booking.getDetails(),
                booking.getClientName(),
                booking.getClientAddress(),
                booking.getClientPhone(),
                booking.getState().getName(),
                manager,
                bookingTypeDTO,
                salonServiceDTO
        );
    }
}