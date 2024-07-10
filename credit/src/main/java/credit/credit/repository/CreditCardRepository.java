package credit.credit.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import credit.credit.request.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
