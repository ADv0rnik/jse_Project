package by.basnet.irb.beans;

import java.util.Date;

public class Result {
    String login;
    String name;
    Date date;
    int mark;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int strToIntMark(String value){
        return (int)Double.parseDouble(value) * 10;
    }

    public String setStringMark(int mark){
        return String.valueOf(mark / 10);
    }

    @Override
    public String toString() {
        return login + ";" + name + ";" + date + ";" + setStringMark(mark);
    }
}
