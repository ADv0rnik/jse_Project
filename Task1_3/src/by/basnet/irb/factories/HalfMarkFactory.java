package by.basnet.irb.factories;

import by.basnet.irb.beans.HalfMark;

public class HalfMarkFactory {
    public HalfMark getHalfMarkFromFactory (int mark){
        return new HalfMark(mark);
    }

    public HalfMark getHalfMarkFromFactory (String mark){
        return new HalfMark(mark);
    }
}
