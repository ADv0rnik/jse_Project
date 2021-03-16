import by.basnet.irb.beans.DecimalMark;
import by.basnet.irb.beans.HalfResult;
import by.basnet.irb.beans.Mark;
import by.basnet.irb.beans.Result;

public class Runner {
    public static void main(String[] args) {
        Mark mark1 = new HalfResult("20.5");
        Mark mark = new DecimalMark("9.5");
        Mark mark2 = new Mark("8");
        Result result = new Result("cool", "xml", "2013-03-27", mark1);
        System.out.println(result.toString());


    }
}

