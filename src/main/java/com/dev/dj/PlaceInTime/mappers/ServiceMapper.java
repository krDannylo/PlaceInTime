package com.dev.dj.PlaceInTime.mappers;

import com.dev.dj.PlaceInTime.dtos.BusinessSummaryDto;
import com.dev.dj.PlaceInTime.dtos.ServiceDto;
import com.dev.dj.PlaceInTime.entity.Business;
import com.dev.dj.PlaceInTime.entity.Service;
import com.dev.dj.PlaceInTime.entity.Slot;
import com.dev.dj.PlaceInTime.repository.BusinessRepository;
import com.dev.dj.PlaceInTime.repository.SlotRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = { SlotMapper.class })
public abstract class ServiceMapper {

    @Autowired protected BusinessRepository businessRepository;
    @Autowired protected SlotRepository slotRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "business", source = "businessId", qualifiedByName = "businessRef")
    @Mapping(target = "slots", source = "slotIds", qualifiedByName = "slotRefs")
    public abstract Service toEntity(ServiceDto dto);


    @Mapping(target = "businessId", ignore = true) // só usado em write
    @Mapping(target = "slotIds", ignore = true)    // só usado em write
    @Mapping(target = "business", source = "business", qualifiedByName = "toBusinessSummary")
    public abstract ServiceDto toDto(Service service);


    @Named("businessRef")
    protected Business businessRef(UUID id) {
        return id == null ? null : businessRepository.getReferenceById(id);
    }

    @Named("slotRefs")
    protected Set<Slot> slotRefs(Set<UUID> ids) {
        if (ids == null) return null;
        return ids.stream().map(slotRepository::getReferenceById).collect(Collectors.toSet());
    }

    @Named("toBusinessSummary")
    protected BusinessSummaryDto toBusinessSummary(Business b) {
        if (b == null) return null;
        return new BusinessSummaryDto(b.getId(), b.getName());
    }
}