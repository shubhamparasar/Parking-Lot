package respositories;

import models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {

    private Map<Long, Ticket> ticketMap = new TreeMap<>();
    private int index = 0;
    public Ticket saveTicket(Ticket ticket){
        ticketMap.put((long)index++, ticket);
        return ticket;
    }
}
