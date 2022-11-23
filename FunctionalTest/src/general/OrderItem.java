package general;

import java.util.List;

public class OrderItem {

    private List<ItemTicket> tickets;

    public OrderItem(List<ItemTicket> tickets){
        this.tickets = tickets;
    }

    public List<ItemTicket> getTickets() {
        return tickets;
    }

    public void setTickets(List<ItemTicket> tickets) {
        this.tickets = tickets;
    }
}
