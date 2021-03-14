package by.basnet.irb.beans;

import java.util.Date;

public class HalfResult extends Result{

    public HalfResult(String login, String name, Date date, int mark) {
        super(login, name, date, mark);
    }

    public HalfResult(String login, String name, String date, String mark) {
        super(login, name, date, mark);
    }

    @Override
    public int strToIntMark(String value) {
        return (int)(Double.parseDouble(value) * 10);
    }

    @Override
    public String getStringMark(int mark) {
        return String.valueOf((double)(mark / 10) + (((mark % 10) == 5)? 0.5 : 0));
    }
}
