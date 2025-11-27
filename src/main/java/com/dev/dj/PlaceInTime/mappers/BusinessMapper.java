package com.dev.dj.PlaceInTime.mappers;

import com.dev.dj.PlaceInTime.dtos.BookingDto;
import com.dev.dj.PlaceInTime.dtos.BusinessDto;
import com.dev.dj.PlaceInTime.entity.Booking;
import com.dev.dj.PlaceInTime.entity.Business;
import com.dev.dj.PlaceInTime.entity.User;
import com.dev.dj.PlaceInTime.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ServiceMapper.class})
public abstract class BusinessMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "owner", source = "ownerId",qualifiedByName = "mapOwner")
    public abstract BookingDto toEntity(BusinessDto businessDto);

    public abstract Business toDto(Booking booking);

    @Named("mapOwner")
    protected User mapOwner(UUID ownerId) {
        if (ownerId == null) return null;
        return userRepository.getReferenceById(ownerId);
    }
}
