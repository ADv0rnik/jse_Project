package by.basnet.irb.beans;

public class Login {
    private int idLogin;
    private String name;

    public Login(int idLogin, String name) {
        this.idLogin = idLogin;
        this.name = name;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
