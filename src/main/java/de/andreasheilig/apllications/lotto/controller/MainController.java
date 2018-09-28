package de.andreasheilig.apllications.lotto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * @author Andreas Heilig
 * Date: 28.09.2018
 */
@Controller
public class MainController {

    private final Random generator = new Random();

    @GetMapping("/")
    public String getMainPage(final Model model) {
        model.addAttribute("lottoNumbers", generateLottoNumbers());
        model.addAttribute("additionalNumber", generateAdditionalNumber());
        return "index";
    }

    private int generateAdditionalNumber() {
        int additionalNumber = 0;
        while (additionalNumber == 0) {
            int generatedNumber = generator.nextInt(10);
            if (generatedNumber != 0) {
                additionalNumber = generatedNumber;
            }
        }
        return additionalNumber;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> sixNumbers = new ArrayList<>();
        while (sixNumbers.size() < 6) {
            int number = generator.nextInt(50);
            if (number != 0 && sixNumbers.stream().noneMatch(n -> n.equals(number))) {
                sixNumbers.add(number);
            }
        }
        sixNumbers.sort(Comparator.naturalOrder());
        return sixNumbers;
    }
}
