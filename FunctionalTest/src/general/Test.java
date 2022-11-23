package general;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        ticket.setProductType("RESALE_TICKETING");
        ticket.setProductSubType("TICKETMASTER_EVENT_RESALE");
        ProductDetails productDetails = new ProductDetails();
        productDetails.setInventorySourceID("1");
        ticket.setProductDetails(productDetails);

        String originalInventorySourceID = ticket.getProductDetails().getInventorySourceID();
        String inventorySource = null;

        System.out.println(ticket.getProductType());
        System.out.println(ticket.getProductSubType());
        System.out.println(originalInventorySourceID);
        if ("LEGACY".equalsIgnoreCase(ticket.getProductType()) ||
                "TICKETMASTER_EVENT_RESALE".equalsIgnoreCase(ticket.getProductSubType()) &&
                        "1".equals(originalInventorySourceID)) {
            inventorySource = "ticketmaster";
        }

        System.out.println(inventorySource);

        /*System.out.println(ZonedDateTime.now(ZoneOffset.UTC));
        System.out.println(ZonedDateTime.now(ZoneOffset.UTC).minusSeconds(3600));*/

        /*String orderId = "Elton John: Farewell/ Yellow Brick Road";

        String[] array =  orderId.split("/");
        System.out.println(array.length);*/
        //System.out.println(evaluate().getTickets().size());
    }

    public static RotatingEntryTokenApiRequest evaluate(){

        RotatingEntryTokenApiRequest rotatingEntryTokenApiRequest = new RotatingEntryTokenApiRequest();
        List<String> ticketsItem = new ArrayList<>();
        rotatingEntryTokenApiRequest.setTickets(ticketsItem);
        List<OrderItem> orders = new ArrayList<>();
        List<ItemTicket> tickets = new ArrayList<>();
        tickets.add(new ItemTicket("0x123"));
        tickets.add(new ItemTicket("0x234"));
        tickets.add(new ItemTicket("0x345"));
        orders.add(new OrderItem(tickets));
        for (OrderItem order: orders) {
            for (ItemTicket ticket: order.getTickets()) {
                System.out.println(ticket.getSeatReference());
                if("0x123".equals(ticket.getSeatReference())) {
                    ticketsItem.add(ticket.getSeatReference());
                    return rotatingEntryTokenApiRequest;
                }
            }
        }
        return rotatingEntryTokenApiRequest;
    }
}
