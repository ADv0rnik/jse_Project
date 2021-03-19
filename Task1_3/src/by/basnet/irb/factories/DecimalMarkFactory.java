package by.basnet.irb.factories;

import by.basnet.irb.beans.DecimalMark;

public class DecimalMarkFactory extends MarkFactory{
    public DecimalMark getDecimalMarkFromFactory (int mark){
        return new DecimalMark(mark);
    }

    public DecimalMark getDecimalMarkFromFactory (String mark){
        return new DecimalMark(mark);
    }

}
