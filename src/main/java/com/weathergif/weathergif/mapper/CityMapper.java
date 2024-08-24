package com.weathergif.weathergif.mapper;

import com.weathergif.weathergif.entity.CityEntity;
import com.weathergif.weathergif.query.CityResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper extends StandardMapper<CityEntity, CityResponse>{
    @Override
    CityResponse map(CityEntity entity);
}
