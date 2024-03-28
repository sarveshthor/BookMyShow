package dev.sarvesh.BookMyShow.service;

import dev.sarvesh.BookMyShow.model.*;
import dev.sarvesh.BookMyShow.model.constant.AuditoriumFeature;
import dev.sarvesh.BookMyShow.model.constant.SeatStatus;
import dev.sarvesh.BookMyShow.model.constant.SeatType;
import dev.sarvesh.BookMyShow.model.constant.ShowSeatStatus;
import dev.sarvesh.BookMyShow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    @Autowired
    private ShowSeatRepository showSeatRepository;

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

        for(int i = 1; i<=5; i++){
            Seat seat = new Seat(i+"-"+ i, SeatType.GOLD,i, i, SeatStatus.AVAILABLE);
            seatRepository.save(seat);
        }

        List<Seat> savedSeats = seatRepository.findAll();

        Auditorium auditorium = new Auditorium();
        auditorium.setName("Audi-01");
        auditorium.setCapacity(100);
        auditorium.setAuditoriumFeatures(List.of(AuditoriumFeature.DOLBY, AuditoriumFeature.TWOD));
        auditorium.setSeats(savedSeats);
        auditoriumRepository.save(auditorium);

        List<Auditorium> savedAudis = auditoriumRepository.findAll();

        savedPvr.setAuditoriums(savedAudis);
        theatreRepository.save(savedPvr);

        Movie movie = new Movie();
        movie.setName("Andaaz Apna Apna");
        movie.setDescription("A comedy film starring Salman and Aamir");
        movieRepository.save(movie);

        Show show = new Show();
        show.setStartTime(LocalDateTime.now());
        show.setEndTime(LocalDateTime.now().plusMinutes(180));
        show.setMovie(movieRepository.findMovieByName("Andaaz Apna Apna"));
        show.setAuditorium(auditoriumRepository.findAuditoriumByName("Audi-01"));
        showRepository.save(show);

        for(int i = 1 ; i<=5 ; i++){
            ShowSeat s = new ShowSeat(1200,
                    showRepository.findById(1).get(),
                    seatRepository.findSeatBySeatNumber(i+"-"+ i),
                    ShowSeatStatus.AVAILABLE
                    );

            showSeatRepository.save(s);
        }



        return true;
    }

}
