package dev.sarvesh.BookMyShow.service;

import dev.sarvesh.BookMyShow.model.City;
import dev.sarvesh.BookMyShow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City SaveCity(String cityName){
        City city = new City();
        city.setName(cityName);
        return cityRepository.save(city);
    }
}
