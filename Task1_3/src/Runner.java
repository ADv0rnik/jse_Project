import by.basnet.irb.beans.Result;

public class Runner {
    public static void main(String[] args) {
        Result result = new Result("cool", "xml", "2013-03-27","8");
        System.out.println(result.toString());

    }
}

