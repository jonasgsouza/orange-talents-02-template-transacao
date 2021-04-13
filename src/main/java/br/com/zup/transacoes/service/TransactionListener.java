package br.com.zup.transacoes.service;

import br.com.zup.transacoes.repository.TransactionRepository;
import br.com.zup.transacoes.service.response.TransactionResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class TransactionListener {

    private final TransactionRepository transactionRepository;

    public TransactionListener(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void consume(TransactionResponse transactionResponse) {
        System.out.println(transactionResponse);
        transactionRepository.save(transactionResponse.toModel());
    }

}
