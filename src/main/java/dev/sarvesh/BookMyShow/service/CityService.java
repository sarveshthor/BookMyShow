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

    public City SaveCity(City city){
        return cityRepository.save(city);
    }

    public boolean deleteCity(int cityId){
        cityRepository.deleteById(cityId);
        return true;
    }

    public City getCityByName(String cityName){
        return cityRepository.findCityByName(cityName);
    }

    public City getCityById(int cityId){
        return cityRepository.findById(cityId).get();
    }
}
