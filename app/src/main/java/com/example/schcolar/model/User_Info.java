package com.example.schcolar.model;

public class User_Info {
    String Date, time, venue, category;

    public User_Info(String date, String time, String venue, String category) {
        Date = date;
        this.time = time;
        this.venue = venue;
        this.category = category;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User_Info() {
    }
}
