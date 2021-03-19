package by.basnet.irb.beans;

public class DecimalMark extends Mark{

    public DecimalMark(int mark) {
        super(mark);
    }

    public DecimalMark(String mark) {
        super((int) (Double.parseDouble(mark) * 10));
    }

    public DecimalMark(Mark value) {
        super(value.getValue());
    }

    @Override
    public void setValue(int value) {
        super.setValue(value);
    }

    @Override
    public int strToIntMark(String value) {
        return (int)(Double.parseDouble(value) * 10);
    }

    @Override
    public String intToStrMark(int mark) {
        return (mark / 10) + "?" + (mark % 10);
    }

    @Override
    public String toString() {
        return intToStrMark(getValue());
    }
}
