package tn.esprit.videos.entity;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private boolean admin;
    private List<Plat> panier;

    public User() {
        this.panier= new ArrayList<Plat>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Plat> getPanier() {
        return panier;
    }

    public void setPanier(List<Plat> panier) {
        this.panier = panier;
    }
}
