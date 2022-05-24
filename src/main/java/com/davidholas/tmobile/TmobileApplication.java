package com.davidholas.tmobile;

import com.davidholas.tmobile.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TmobileApplication {

    @Autowired
    private TransactionService transactionService;

    public TmobileApplication(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TmobileApplication.class, args);
        if(args == null) {
            System.out.println("File location was to provided.");
        } else {
            ConfigurableApplicationContext appContext = SpringApplication.run(TmobileApplication.class, args);
            TransactionService transactionService = appContext.getBean(TransactionService.class);
            String output = transactionService.markTheOrder(args[0]);
            System.out.println(output);
        }
    }
}
