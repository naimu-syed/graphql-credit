package credit.credit.utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import credit.credit.request.CreditCard;
import credit.credit.service.CreditCardService;

@Component
public class DummyDataInitializer implements ApplicationRunner {

    @Autowired
    private CreditCardService creditCardService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 1; i <= 100; i++) {
            String cardNumber = "DummyCardNumber" + i;
            String cardHolderName = "DummyCardHolder" + i;
            String expirationDate = "12/25";
            String cvv = "123";

            // Create credit card using service
            CreditCard creditCard = new CreditCard();
            creditCard.setCardNumber(cardNumber);
            creditCard.setCardHolderName(cardHolderName);
            creditCard.setExpirationDate(expirationDate);
            creditCard.setCvv(cvv);

            creditCardService.create(creditCard);
        }
        System.out.println("Initialization complete: Created 100 dummy credit card records.");
    }
}
