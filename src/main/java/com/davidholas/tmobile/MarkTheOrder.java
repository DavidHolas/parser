package com.davidholas.tmobile;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MarkTheOrder {

    public String markTheOrder(String fileLocation) {

        File file = new File(fileLocation);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        List<Order> orders = new ArrayList<>();
        Map<String, Integer> providersMap = new HashMap<>();
        String result = "";
        int counter = 1;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(",");
                String subject = parts[0];
                String provider = parts[1].split("/")[0];
                String timeString = parts[2].substring(1);
                LocalDateTime time = LocalDateTime.parse(timeString, formatter);

                Order newOrder = new Order(counter, provider, subject, time);
                orders.add(newOrder);

                fillPositions(providersMap, newOrder);

                //String outputLine = this.appendLine(subject, provider, "1");
                String outputLine = this.appendLineFromOrder(newOrder);

                result = result + outputLine;
                counter++;
            }

            scanner.close();
        } catch (FileNotFoundException e){
            System.out.println("File was not found!");
        }
        return result;
    }

    private String appendLine(String subject, String provider, String number) {
        String outputLine = "";
        StringBuilder sb = new StringBuilder();
        sb.append(outputLine)
                .append(provider)
                .append("|")
                .append(number)
                .append("|")
                .append(subject)
                .append("\n");

        return sb.toString();
    }

    private String appendLineFromOrder(Order order) {
        String outputLine = "";
        StringBuilder sb = new StringBuilder();
        sb.append(outputLine)
                .append(order.getProvider())
                .append("|")
                .append(order.getPosition())
                .append("|")
                .append(order.getSubject())
                .append("\n");

        return sb.toString();
    }

    private void fillPositions(Map<String, Integer> providersMap, Order order) {

        String provider = order.getProvider();

        if(providersMap.containsKey(order.getProvider())) {
            int position = providersMap.get(provider) + 1;
            providersMap.put(provider, position);
            order.setPosition(position);
        } else {
            providersMap.put(provider, 1);
            order.setPosition(1);
        }
    }
}
