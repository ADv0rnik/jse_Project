package by.basnet.irb.impl;

import by.basnet.irb.beans.Result;
import by.basnet.irb.dao.IResultDAO;
import by.basnet.irb.factories.MarkFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ResultImplCsv implements IResultDAO {
    private Scanner scanner;
    private MarkFactory markFactory;

    public static final int LOGIN_INDEX = 0;
    public static final int TEST_INDEX = 1;
    public static final int DATE_INDEX = 2;
    public static final int MARK_INDEX = 3;

    public ResultImplCsv(String fileName, MarkFactory markFactory) {
        try{
            scanner = new Scanner(fileName);
            this.markFactory = markFactory;
        } catch (Exception e) {
            System.out.println("File not found: "+ e.toString());
        }
    }

    @Override
    public Result nextResult() {
        return null;
    }

    @Override
    public boolean hasResult() {
        return false;
    }
}
