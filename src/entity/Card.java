package entity;

import exception.CardException;
import exception.OperationException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Card {
    private Long numTarjeta;

    private Brand brand;
    private Holder holder;

    private LocalDate expirationDate;

    public Card(Long numTarjeta, Brand brand, Holder holder, String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        try {
            this.expirationDate = LocalDate.parse(fecha, formatter);
        } catch (DateTimeException e) {
            throw new CardException("Date misspelled");
        }
        this.numTarjeta = numTarjeta;
        this.brand = brand;
        this.holder = holder;
    }

    public Brand getBrand() {
        return brand;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setNumTarjeta(Long numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Long getNumTarjeta() {
        return numTarjeta;
    }

    public Holder getHolder() {
        return holder;
    }

    public boolean isValid() {
        return expirationDate.isAfter(LocalDate.now());
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Card)) {
            return false;
        }
        return equals((Card) object);
    }

    public boolean equals(Card card) {
        return Objects.equals(this.numTarjeta, card.getNumTarjeta());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\nCard Number: ").append(numTarjeta);
        sb.append("\nBrand: ").append(brand.name());
        sb.append("\nFirst Name: ").append(holder.getFirstName());
        sb.append("\nLast Name: ").append(holder.getLastName());
        sb.append("\nExpiration Date: ").append(expirationDate);
        sb.append("\n}");
        return sb.toString();
    }
}

