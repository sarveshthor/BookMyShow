package dev.sarvesh.BookMyShow.service;

import dev.sarvesh.BookMyShow.model.ShowSeat;
import dev.sarvesh.BookMyShow.model.Ticket;
import dev.sarvesh.BookMyShow.model.constant.ShowSeatStatus;
import dev.sarvesh.BookMyShow.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private ShowSeatService showSeatService;
    @Autowired
    private TicketRepository ticketRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatIds, int userId) throws Exception {
        //checking if the selected seats are available
        for(int showSeatId : showSeatIds){
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new Exception("Seat is not available for this show");
            }
        }

        //updating the showseat status to a locked state
        for(int showSeatId : showSeatIds){
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.saveShowSeat(seat);
        }

        //logic for payment flow
        //separate method is called for payment because that is not required to be serializable
        startPayment(showSeatIds);// when we do startPayment, commit is done on sql

        return new Ticket();
    }

    public boolean startPayment(List<Integer> showSeatIds){
        return true;
    }

    public String greet(){
        return "Our first working API";
    }
}
