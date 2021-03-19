package by.basnet.irb.impl;

import by.basnet.irb.beans.Result;
import by.basnet.irb.dao.IResultDAO;

public class ResultImplCsv implements IResultDAO {
    

    @Override
    public Result nextResult() {
        return null;
    }

    @Override
    public boolean hasResult() {
        return false;
    }
}
