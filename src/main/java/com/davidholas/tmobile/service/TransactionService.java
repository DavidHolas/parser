package com.davidholas.tmobile.service;

public interface TransactionService {

    /**
     * Function that reads the input file, create desired output string a print it.
     *
     * @param fileLocation
     * @return List of all transactions from the input file in unchanged order
     */
    String markTheOrder(String fileLocation);
}
