package credit.credit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import credit.credit.request.CreditCard;
import credit.credit.service.CreditCardService;

@Controller
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @MutationMapping("createCreditCard")
    public CreditCard create(@Argument String cardNumber, @Argument String cardHolderName, @Argument String expirationDate, @Argument String cvv) {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber(cardNumber);
        creditCard.setCardHolderName(cardHolderName);
        creditCard.setExpirationDate(expirationDate);
        creditCard.setCvv(cvv);
        return creditCardService.create(creditCard);
    }

    @QueryMapping("allCreditCards")
    public List<CreditCard> getAll() {
        return creditCardService.getAll();
    }

    @QueryMapping("getCreditCard")
    public CreditCard get(@Argument Long id) {
        return creditCardService.get(id).orElse(null);
    }

    @QueryMapping("paginatedCreditCards")
    public List<CreditCard> getPaginated(@Argument int page, @Argument int size) {
        Page<CreditCard> creditCardPage = creditCardService.getAllPaginated(page, size);
        return creditCardPage.getContent();
    }

    @MutationMapping("deleteCreditCard")
    public String delete(@Argument Long id) {
        creditCardService.delete(id);
        return "Credit card deleted";
    }
}
