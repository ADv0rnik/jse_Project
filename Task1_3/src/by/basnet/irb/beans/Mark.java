package by.basnet.irb.beans;

public class Mark {
    private int value;

    public Mark(int mark) {
        this.value = mark;
    }

    public Mark(Mark mark) {
        this.value = mark.getValue();
    }

    public Mark(String mark) {
        this.value = strToIntMark(mark);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setMark(String value) {
        this.value = strToIntMark(value);
    }

    public int strToIntMark(String value){
        return Integer.parseInt(value) ;
    }

    public String intToStrMark(int mark){
        return String.valueOf(mark);
    }

    @Override
    public String toString() {
        return intToStrMark(value);
    }
}
