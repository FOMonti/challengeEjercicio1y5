package entity;

import java.time.LocalDate;

public enum Brand {

    VISA(Brand.OPERATION_VISA), NARA(Brand.OPERATION_NARA), AMEX(Brand.OPERATION_AMEX);

    private final int tipoOperation;
    private final static int OPERATION_VISA = 0;
    private final static int OPERATION_NARA = 1;
    private final static int OPERATION_AMEX = 2;

    Brand(int tipoOperation) {
        this.tipoOperation = tipoOperation;
    }

    public double tasa(LocalDate date) {
        switch (tipoOperation) {
            case OPERATION_VISA:
                return Math.floorDiv((date.getYear() - 2000), date.getMonthValue());
            case OPERATION_NARA:
                return date.getDayOfMonth() * 0.5;
            case OPERATION_AMEX:
                return date.getMonthValue() * 0.1;
        }
        return 0;
    }
}
