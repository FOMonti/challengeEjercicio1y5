package entity;

import exception.OperationException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Operation {

    private Card card;

    private Double consumption;

    private LocalDate consumptionDate;

    public Operation(Card card, Double consumption, String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        try {
            this.consumptionDate = LocalDate.parse(fecha, formatter);
            if (this.consumptionDate.isAfter(card.getExpirationDate())) {
                throw new OperationException("Invalid Operation, The date of consumption is after expiration date ");
            }
        } catch (DateTimeException e) {
            throw new OperationException("Date misspelled");
        }
        if (0 > consumption || consumption > 1000) {
            throw new OperationException("Consumption must be greater than 0 and less than 1000");
        }
        this.card = card;
        this.consumption = consumption;
    }

    public LocalDate getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(LocalDate consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    public Double getConsumption() {
        return consumption;
    }

    public void setConsumption(Double consumption) {
        this.consumption = consumption;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
