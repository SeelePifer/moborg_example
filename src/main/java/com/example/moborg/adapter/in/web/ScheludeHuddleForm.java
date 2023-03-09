package com.example.moborg.adapter.in.web;

import java.util.Objects;

public final class ScheludeHuddleForm {
    private  String name;
    private  String dateTime;

    private String time;

    public ScheludeHuddleForm() {

    }
    public ScheludeHuddleForm(String name,
                              String dateTime,
                              String time) {
        this.name = name;
        this.dateTime = dateTime;
        this.time = time;
    }

    public String time(){
        return time;
    }
    public String name() {
        return name;
    }

    public String dateTime() {
        return dateTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ScheludeHuddleForm) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateTime);
    }

    @Override
    public String toString() {
        return "ScheludeHuddleForm[" +
                "name=" + name + ", " +
                "dateTime=" + dateTime + ']';
    }

}
