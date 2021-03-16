package by.basnet.irb.beans;

import java.util.Date;

public class HalfResult extends Mark{
    public HalfResult(int mark) {
        super(mark);
    }

    public HalfResult(Mark value) {
        super(value.getMark());
    }

    public HalfResult(String mark) {
        super((int) (Double.parseDouble(mark) * 10));
    }

    @Override
    public void setMark(int mark) {
        super.setMark(mark);
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
