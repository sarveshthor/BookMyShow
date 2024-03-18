package dev.sarvesh.BookMyShow.controller;

import dev.sarvesh.BookMyShow.dto.BookTicketRequestDTO;
import dev.sarvesh.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    //create the dependency object and inject inside controller
    @Autowired
    public TicketService ticketService;

    @PostMapping("/ticket") //a new ticket will be a new entity for the database
    public ResponseEntity bookTicket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO) throws Exception {
        //validate ticketrequestdto
            if (bookTicketRequestDTO.getShowSeatIDs() == null
                    || bookTicketRequestDTO.getUserId() == null) {
                throw new Exception("Invalid inputs");
            }
            return ResponseEntity.ok(ticketService.bookTicket(bookTicketRequestDTO.getShowSeatIDs(), bookTicketRequestDTO.getUserId()));

    }


    @GetMapping("/hello")
    public ResponseEntity greet(){
        String greet = ticketService.greet();
        return ResponseEntity.ok(greet);
    }
}
