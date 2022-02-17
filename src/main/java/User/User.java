package User;

public class User {

    private int id;
    private String name;
    private String password;
    private boolean authorization;

    public User(String name, String password, boolean authorization) {
        this.name = name;
        this.password = password;
        this.authorization = authorization;
    }

    public User(int id, String name, String password, boolean authorization) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.authorization = authorization;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", authorization=" + authorization +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthorization() {
        return authorization;
    }

    public void setAuthorization(boolean authorization) {
        this.authorization = authorization;
    }
}
