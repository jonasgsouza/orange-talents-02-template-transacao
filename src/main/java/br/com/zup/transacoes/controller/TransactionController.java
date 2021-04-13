package br.com.zup.transacoes.controller;

import br.com.zup.transacoes.controller.response.TransactionResponse;
import br.com.zup.transacoes.model.Transaction;
import br.com.zup.transacoes.repository.TransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/{cardId}/transactions")
    public ResponseEntity<List<TransactionResponse>> listMostRecentTransactions(@PathVariable UUID cardId) {
        if(!transactionRepository.existsByCreditCardId(cardId)) return ResponseEntity.notFound().build();
        List<Transaction> transactions = transactionRepository.findTop10ByCreditCardIdOrderByEffectiveOnDesc(cardId);
        return ResponseEntity.ok().body(transactions.stream().map(TransactionResponse::new).collect(Collectors.toList()));
    }
}
