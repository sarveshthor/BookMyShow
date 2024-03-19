package dev.sarvesh.BookMyShow.service;

import dev.sarvesh.BookMyShow.model.Auditorium;
import dev.sarvesh.BookMyShow.model.City;
import dev.sarvesh.BookMyShow.model.Seat;
import dev.sarvesh.BookMyShow.model.Theatre;
import dev.sarvesh.BookMyShow.model.constant.AuditoriumFeature;
import dev.sarvesh.BookMyShow.model.constant.SeatStatus;
import dev.sarvesh.BookMyShow.model.constant.SeatType;
import dev.sarvesh.BookMyShow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class InitService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;

    public boolean initializeData(){
        City delhi = new City("Delhi");
        City bangalore = new City("Bangalore");
        City udaipur = new City("Udaipur");

        cityRepository.save(delhi);
        cityRepository.save(bangalore);
        cityRepository.save(udaipur);

        City savedCity = cityRepository.findCityByName("Udaipur");
        Theatre pvr = new Theatre("PVRCinemas", "Jr, Udaipur");
        Theatre carnival = new Theatre("CarnivalCinemas", "Lake, Udaipur");

        theatreRepository.save(pvr);
        theatreRepository.save(carnival);

        Theatre savedPvr = theatreRepository.findTheatreByName("PVRCinemas");
        Theatre savedCarnival = theatreRepository.findTheatreByName("CarnivalCinemas");

        List<Theatre> udaipurTheatres = new ArrayList<>();
        udaipurTheatres.add(savedPvr);
        udaipurTheatres.add(savedCarnival);

        savedCity.setTheatres(udaipurTheatres);

        cityRepository.save(savedCity);

        Auditorium auditorium = new Auditorium();
        auditorium.setName("Audi-01");
        auditorium.setCapacity(100);
        auditorium.setAuditoriumFeatures(List.of(AuditoriumFeature.DOLBY, AuditoriumFeature.TWOD));
        auditoriumRepository.save(auditorium);

        List<Seat> seats = new ArrayList<>();

        for(int i = 1; i<=5; i++){
            Seat seat = new Seat(i+"-"+ i, SeatType.GOLD,i, i, SeatStatus.AVAILABLE);
            seatRepository.save(seat);
            Seat savedSeat = seatRepository.findSeatBySeatNumber(i+"-"+ i);
            seats.add(seat);
        }
        //we are fetching these objects again from the repository to get the id attribute as well
        Auditorium savedAudi = auditoriumRepository.findAuditoriumByName("Audi-01");
        savedAudi.setSeats(seats);
        auditoriumRepository.save(savedAudi);

        return true;
    }

}
