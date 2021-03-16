package by.basnet.irb.beans;

public class Mark {
    private int mark;

    public Mark(int mark) {
        this.mark = mark;
    }

    public Mark(Mark mark) {
        this.mark = mark.getMark();
    }

    public Mark(String mark) {
        this.mark = strToIntMark(mark);
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

    public String intToStrMark(int mark){
        return String.valueOf(mark/10);
    }

    @Override
    public String toString() {
        return intToStrMark(mark);
    }
}
