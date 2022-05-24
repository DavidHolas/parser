package com.davidholas.tmobile;

import java.time.LocalDateTime;

public class Transaction {

    private int id;
    private String provider;
    private String subject;
    private LocalDateTime time;
    private int position;

    public Transaction(int id, String provider, String subject, LocalDateTime time) {
        this.id = id;
        this.provider = provider;
        this.subject = subject;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getProvider())
                .append("|")
                .append(this.getPosition())
                .append("|")
                .append(this.getSubject())
                .append("\n");
        return sb.toString();
    }
}
