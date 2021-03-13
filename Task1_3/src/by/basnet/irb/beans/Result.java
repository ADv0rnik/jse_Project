package by.basnet.irb.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Result {
    String login;
    String name;
    Date date;
    int mark;
    private final static SimpleDateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    private final static SimpleDateFormat INPUT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public Result(String login, String name, Date date, int mark) {
        this.login = login;
        this.name = name;
        this.date = date;
        this.mark = mark;
    }

    public Result(String login, String name, String date, String mark) {
        this.login = login;
        this.name = name;
        setDate(date);
        this.mark = strToIntMark(mark);
    }

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

    public void setDate(String date) {
        try {
            this.date = INPUT_DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

   public String getStringDate(){
        return OUTPUT_DATE_FORMAT.format(date);
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setMark(String value) {
        this.mark = strToIntMark(value);
    }

    public int strToIntMark(String value){
        return Integer.parseInt(value) * 10;
    }

    public String getStringMark(int mark){
        return String.valueOf(mark / 10);
    }

    @Override
    public String toString() {
        return login + ";" + name + ";" + getStringDate() + ";" + getStringMark(mark);
    }
}
