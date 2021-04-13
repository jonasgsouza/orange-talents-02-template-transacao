package br.com.zup.transacoes.repository;

import br.com.zup.transacoes.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    Boolean existsByCreditCardId(UUID cardId);

    List<Transaction> findTop10ByCreditCardIdOrderByEffectiveOnDesc(UUID cardId);
}
