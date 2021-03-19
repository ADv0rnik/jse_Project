package by.basnet.irb.beans;

public class HalfMark extends Mark{

    public HalfMark(int mark) {
        super(mark);
    }

    public HalfMark(String mark) {
        super((int) (Double.parseDouble(mark) * 10));
    }

    @Override
    public void setMark(int mark) {
        super.setMark(mark);
    }

    @Override
    public int strToIntMark(String value) {
        return (int) (Double.parseDouble(value) * 10);
    }

    @Override
    public String intToStrMark(int mark) {
        if(mark%10 == 5){
            return String.valueOf((double)(mark / 10) + 0.5);
        }
        return String.valueOf((mark / 10));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
