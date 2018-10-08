package de.andreasheilig.apllications.lotto.Repository;

import java.util.*;

/**
 * @author Andreas Heilig
 * Date: 08.10.2018
 */
public class EuroJackpotTicket {

    private UUID id;
    private List<Integer> numbers;
    private List<Integer> additionalNumbers;

    private final Random generator = new Random();

    public EuroJackpotTicket() {
        setID(UUID.randomUUID());
        setNumbers(generateNumbers(5, 51));
        setAdditionalNumbers(generateNumbers(2, 11));
    }

    private List<Integer> generateNumbers(int size, int bound) {
        List<Integer> genNumbers = new ArrayList<>();
        while (genNumbers.size() < size) {
            int number = generator.nextInt(bound);
            if (number != 0 && genNumbers.stream().noneMatch(n -> n.equals(number))) {
                genNumbers.add(number);
            }
        }
        genNumbers.sort(Comparator.naturalOrder());
        return genNumbers;
    }

    public UUID getID() {
        return id;
    }

    private void setID(UUID id) {
        this.id = id;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getAdditionalNumbers() {
        return additionalNumbers;
    }

    private void setAdditionalNumbers(List<Integer> additionalNumbers) {
        this.additionalNumbers = additionalNumbers;
    }
}
