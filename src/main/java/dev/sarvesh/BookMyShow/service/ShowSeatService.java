package dev.sarvesh.BookMyShow.service;

import dev.sarvesh.BookMyShow.model.ShowSeat;
import dev.sarvesh.BookMyShow.repository.ShowSeatRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class ShowSeatService {

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public ShowSeat getShowSeat(int showSeatId){
        return showSeatRepository.findById(showSeatId).get();
    }

    public ShowSeat saveShowSeat(ShowSeat showSeat){
        return showSeatRepository.save(showSeat);//save() is insert and update both
    }
}
