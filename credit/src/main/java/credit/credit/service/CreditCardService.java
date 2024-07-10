package credit.credit.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import credit.credit.repository.CreditCardRepository;
import credit.credit.request.CreditCard;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    public CreditCard create(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    public List<CreditCard> getAll() {
        return creditCardRepository.findAll();
    }

    public Page<CreditCard> getAllPaginated(int page, int size) {
        return creditCardRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<CreditCard> get(Long id) {
        return creditCardRepository.findById(id);
    }

    public void delete(Long id) {
        creditCardRepository.deleteById(id);
    }
}
