package com.davidholas.tmobile.service;

import com.davidholas.tmobile.Transaction;

import java.util.List;

public interface LineParser {

    List<Transaction> parseLines(String fileLocation);
}
