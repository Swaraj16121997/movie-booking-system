package dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketRequestDto {
    private Long userId;    // reason behind asking for IDs only, instead of other infos from the client, is that the tech stack used at client's side is not certain to us always
    private Long showId;
    private List<Long> showSeatId;
}
