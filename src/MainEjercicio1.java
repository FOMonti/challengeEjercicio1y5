import entity.Brand;
import entity.Card;
import entity.Holder;
import entity.Operation;
import exception.CardException;
import exception.HolderException;
import exception.OperationException;
import service.CardService;
import service.OperationService;

public class MainEjercicio1 {

    public static void main(String[] args) {
        CardService cardService = new CardService();
        OperationService operationService = new OperationService();
        try {
            Holder holder = new Holder("Fernando", "Montoro");
            Card cardA = new Card(123123L, Brand.AMEX, holder, "15/08/2024");
            Card cardB = new Card(271123L, Brand.VISA, holder, "15/08/2021");
            Operation operation = new Operation(cardA, 550.0, "15/04/2023");

            System.out.println(cardService.getInfoCard(cardA));
            System.out.println("Valid : " + cardService.isValid(cardA));
            System.out.println("Valid : " + cardService.isValid(cardB));
            System.out.println("Are Equals: " + cardService.areEqual(cardA, cardA));
            System.out.println("Are Equals: " + cardService.areEqual(cardA, cardB));
            System.out.println(operationService.getInformation(operation));
            Operation operationB = new Operation(cardB, 550.0, "15/04/2023"); //Exception
        } catch (CardException | HolderException | OperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
