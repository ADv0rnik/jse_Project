import by.basnet.irb.ResultLoader;
import by.basnet.irb.dao.IResultDAO;
import by.basnet.irb.factories.MarkFactory;
import by.basnet.irb.impl.ResultImplCsv;

public class Runner {
    public static void main(String[] args) {
        MarkFactory markFactory = new MarkFactory();
        IResultDAO resultDAO;
        resultDAO = new ResultImplCsv("Task1_3/src/resource/results.csv", markFactory);
        ResultLoader.loadResults(resultDAO);
    }
}

