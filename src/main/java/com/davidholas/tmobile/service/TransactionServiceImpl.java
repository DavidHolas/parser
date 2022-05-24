package com.davidholas.tmobile.service;

import com.davidholas.tmobile.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private LineParserServiceImpl lineParserServiceImpl;

    public TransactionServiceImpl(LineParserServiceImpl lineParserServiceImpl) {
        this.lineParserServiceImpl = lineParserServiceImpl;
    }

    public String markTheOrder(String fileLocation) {
        List<Transaction> transactions = lineParserServiceImpl.parseLines(fileLocation);
        fillPositions(transactions);
        return printOutput(transactions);
    }

    private String printOutput(List<Transaction> transactions) {
        StringBuilder sb = new StringBuilder();
        String output = "";
        for (Transaction transaction : transactions) {
            sb.append(transaction.toString());
        }
        return sb.toString();
    }

    private void fillPositions(List<Transaction> transactions) {

        Map<String, Integer> providersMap = new HashMap<>();
        List<Transaction> sortedTransaction = new ArrayList<>(transactions);
        sortedTransaction.sort(Comparator.comparing(Transaction::getTime));

        for (Transaction transaction : sortedTransaction) {
            String provider = transaction.getProvider();
            if (providersMap.containsKey(transaction.getProvider())) {
                int position = providersMap.get(provider) + 1;
                providersMap.put(provider, position);
                transactions.get(transaction.getId()).setPosition(position);
            } else {
                providersMap.put(provider, 1);
                transactions.get(transaction.getId()).setPosition(1);
            }
        }
    }
}
