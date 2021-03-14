package by.basnet.irb.beans;

public class Test {
    private int idTest;
    private String name;

    public Test(int idTest, String name) {
        this.idTest = idTest;
        this.name = name;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
