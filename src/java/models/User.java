package models;

public class User {
    private String username;
    // for explicity, will not be storing password.
    private String password;
    
    public User(){this.username = ""; this.password = null;}
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
