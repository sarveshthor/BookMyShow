package dev.sarvesh.BookMyShow.controller;

import dev.sarvesh.BookMyShow.dto.CityRequestDTO;
import dev.sarvesh.BookMyShow.model.City;
import dev.sarvesh.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/city")
    public ResponseEntity createCity(@RequestBody CityRequestDTO cityRequestDTO){
        //controller is mainly used to do the validation of data
        try{
            String cityName = cityRequestDTO.getName();
            if(cityName == null || cityName.isEmpty() || cityName.isBlank()){ // "" empty string, "    " blank string
                throw new Exception("city name cannot be blank");
            }
            City savedCity = cityService.SaveCity(cityName);
            return ResponseEntity.ok(savedCity);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
