package by.basnet.irb.factories;

import by.basnet.irb.beans.Mark;

public class MarkFactory {
    public Mark getMarkFromFactory(int mark){
        return new Mark(mark);
    }

    public Mark getMarkFromFactory(String mark){
        return new Mark(mark);
    }

}
