package com.davidholas.tmobile.service;

import com.davidholas.tmobile.Transaction;

import java.util.List;

public interface LineParser {

    /**
     * Create list of transactions from file in the given path
     *
     * @param fileLocation
     * @return List of transactions in the order of the file
     */
    List<Transaction> parseLines(String fileLocation);
}
