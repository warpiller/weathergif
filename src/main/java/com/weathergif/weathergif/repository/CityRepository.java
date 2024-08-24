package com.weathergif.weathergif.repository;

import com.weathergif.weathergif.entity.CityEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<CityEntity, Integer> {
    @Override
    List<CityEntity> findAll();

    CityEntity findCityEntitiesByCity(String city);

}
