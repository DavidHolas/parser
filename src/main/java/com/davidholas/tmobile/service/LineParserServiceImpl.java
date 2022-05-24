package com.davidholas.tmobile.service;

import com.davidholas.tmobile.Transaction;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class LineParserServiceImpl implements LineParser {

    public LineParserServiceImpl() {
    }

    public List<Transaction> parseLines(String fileLocation) {

        File file = new File(fileLocation);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        List<Transaction> transactions = new ArrayList<>();
        int counter = 0;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // get data from input line
                String[] parts = line.split("(?!\\B\"[^\"]*),(?![^\"]*\"\\B)");
                String subject = parts[0].startsWith("\"") ? parts[0].substring(1, parts[0].length() - 1) : parts[0];
                String provider = parts[1].split("/")[0];
                String timeString = parts[2].substring(1);
                LocalDateTime time = LocalDateTime.parse(timeString, formatter);

                // create transaction
                Transaction newTransaction = new Transaction(counter++, provider, subject, time);
                transactions.add(newTransaction);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        } catch (DateTimeParseException e) {
            System.out.println("Problem while parsing date of the transaction has occurred.");
        } catch (RuntimeException e) {
            System.out.println("Problem while parsing a file.");
        }
        return transactions;
    }
}
