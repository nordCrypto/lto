package de.andreasheilig.apllications.lotto.controller;

import de.andreasheilig.apllications.lotto.Repository.EuroJackpotTicket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

/**
 * @author Andreas Heilig
 * Date: 28.09.2018
 */
@Controller public class MainController {



    @GetMapping("/ej") public String getMainPage(final Model model) {
        model.addAttribute("euroJackpotTickets", generateEuroJackpotTicketListOf(4));
        return "index";
    }

    private List<EuroJackpotTicket> generateEuroJackpotTicketListOf(int count) {
        List<EuroJackpotTicket> ticketList = new ArrayList<>();
        while (ticketList.size() < count) {
            EuroJackpotTicket generatedTicked = new EuroJackpotTicket();
            if (ticketNumbersNotEqual(ticketList, generatedTicked) && additionalNumbersNotEqual(ticketList, generatedTicked)) {
                ticketList.add(generatedTicked);
            }
        }
        return ticketList;
    }

    private boolean additionalNumbersNotEqual(List<EuroJackpotTicket> ticketList, EuroJackpotTicket generatedTicked) {
        return ticketList.stream().noneMatch(t -> t.getAdditionalNumbers().stream().anyMatch(a -> generatedTicked.getAdditionalNumbers().contains(a)));
    }

    private boolean ticketNumbersNotEqual(List<EuroJackpotTicket> ticketList, EuroJackpotTicket generatedTicked) {
        return ticketList.stream().noneMatch(t -> t.getNumbers().stream().anyMatch(n -> generatedTicked.getNumbers().contains(n)));
    }
}
