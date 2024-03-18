package dev.sarvesh.BookMyShow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {
    private List<Integer> showSeatIDs;
    private Integer userId;
}
