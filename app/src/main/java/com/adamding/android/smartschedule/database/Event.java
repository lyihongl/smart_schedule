package com.adamding.android.smartschedule.database;

public class Event {

    private int section, id, date, time;
    private String event;

    public Event(){}

    public Event(int section, int date, int time, String event){
        this.section = section;
        this.date = date;
        this.time = time;
        this.event = event;
    }

    //getters and setters
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString(){
        return "Event [id="+ id+", section "+section+", date "+date+", time "+time+" event desc "+event+"]";
    }
}
