package com.dev.dj.PlaceInTime.mappers;

import com.dev.dj.PlaceInTime.dtos.BookingDto;
import com.dev.dj.PlaceInTime.entity.Booking;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",uses = {SlotMapper.class})
public abstract class BookingMapper {

    @Autowired
    private SlotMapper slotMapper;

    public abstract Booking toEntity(BookingDto bookingDto);
    public  abstract BookingDto toDto(Booking booking);

}
