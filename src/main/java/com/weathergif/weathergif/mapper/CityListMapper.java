package com.weathergif.weathergif.mapper;

import com.weathergif.weathergif.entity.CityEntity;
import com.weathergif.weathergif.query.CityResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityListMapper extends StandardListMapper<CityEntity, CityResponse>{
    @Override
    List<CityResponse> map(List<CityEntity> from);
}
