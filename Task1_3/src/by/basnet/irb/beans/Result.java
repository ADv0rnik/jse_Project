package by.basnet.irb.beans;

import exceptions.ParseExceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class Result {
    String login;
    String name;
    Date date;
    Mark mark;

    private final static SimpleDateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    private final static SimpleDateFormat INPUT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public Result(String login, String name, Date date, Mark mark) {
        this.login = login;
        this.name = name;
        this.date = date;
        this.mark = mark;
    }

    public Result(String login, String name, String date, Mark mark) {
        this.login = login;
        this.name = name;
        setDate(date);
        this.mark = mark;
    }

    public Result() {

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

    public void setDate(String dateValue) {
        try {
            date = new Date(INPUT_DATE_FORMAT.parse(dateValue).getTime());
        } catch (ParseException e) {
            throw new ParseExceptions("Date parsing error: ", e);
        }
    }

   public String getStringDate(){
        return OUTPUT_DATE_FORMAT.format(date);
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return login + ";" + name + ";" + date + ";" + mark;
    }
}
