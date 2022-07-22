package service;

import entity.Operation;

public class OperationService {

    public boolean isValid(Operation operation) {
        return false;
    }

    public String getInformation(Operation operation) {
        return "{" +
                "\nTasa: " + operation.getCard().getBrand().tasa(operation.getConsumptionDate()) +
                "\nMarca: " + operation.getCard().getBrand().name() +
                "\nImporte: " + operation.getConsumption() +
                "\n}";

    }

}
