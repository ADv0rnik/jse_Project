package by.basnet.irb.dao;

import by.basnet.irb.beans.Result;

public interface IResultDAO {
    Result nextResult();
    boolean hasResult();
    void closeReader();

}
