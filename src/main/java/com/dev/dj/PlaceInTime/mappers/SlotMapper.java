package com.dev.dj.PlaceInTime.mappers;

import com.dev.dj.PlaceInTime.dtos.SlotDto;
import com.dev.dj.PlaceInTime.entity.Slot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",uses = {BookingMapper.class, ServiceMapper.class})
public abstract class SlotMapper {

    @Autowired
    protected BookingMapper bookingMapper;
    @Autowired
    protected ServiceMapper serviceMapper;

    public abstract Slot toEntity(SlotDto slotDto);

    public abstract SlotDto toDto(Slot slot);



}
