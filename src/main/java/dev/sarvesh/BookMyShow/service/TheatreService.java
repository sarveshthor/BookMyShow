package dev.sarvesh.BookMyShow.service;

import dev.sarvesh.BookMyShow.model.City;
import dev.sarvesh.BookMyShow.model.Theatre;
import dev.sarvesh.BookMyShow.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private CityService cityService;

    public Theatre saveTheatre(String name, String address, int cityId){
        Theatre theatre = new Theatre();
        theatre.setName(name);
        theatre.setAddress(address);
        Theatre savedTheatre = theatreRepository.save(theatre);

        //now we have to map this theatre to the city

        City city = cityService.getCityById(cityId);
        List<Theatre> theatreList = city.getTheatres();
        theatreList.add(theatre);
        city.setTheatres(theatreList);
        cityService.SaveCity(city);

        return savedTheatre;
    }
}
