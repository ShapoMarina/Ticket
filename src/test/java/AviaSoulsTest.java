import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void shouldChooseTicketFromMoscowToSochi() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Сочи", "Москва", 350, 9, 11);
        Ticket ticket2 = new Ticket("Новосибирск", "Москва", 500, 17, 23);
        Ticket ticket3 = new Ticket("Москва", "Сочи", 400, 3, 6);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 800, 8, 19);
        Ticket ticket5 = new Ticket("Москва", "Сочи", 250, 15, 17);
        Ticket ticket6 = new Ticket("Москва", "Сочи", 300, 14, 16);
        Ticket ticket7 = new Ticket("Москва", "Белгород", 400, 12, 13);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket5, ticket6, ticket3};
        Ticket[] actual = manager.search("Москва", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldChooseTicket() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Сочи", "Москва", 350, 9, 11);
        Ticket ticket2 = new Ticket("Новосибирск", "Москва", 500, 17, 23);
        Ticket ticket3 = new Ticket("Москва", "Сочи", 400, 3, 6);//3
        Ticket ticket4 = new Ticket("Москва", "Белгород", 800, 8, 13);
        Ticket ticket5 = new Ticket("Москва", "Сочи", 250, 15, 17);//2
        Ticket ticket6 = new Ticket("Москва", "Сочи", 300, 14, 19);//5
        Ticket ticket7 = new Ticket("Москва", "Белгород", 400, 12, 13);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5, ticket3, ticket6};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Сочи", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}