package tn.esprit.videos.entity;

import java.util.*;

public class Commande {
    private int id;
    private User user;
    private List<Plat> order;
    private int prix;
    private boolean seen;

    public Commande() {
        this.order= new ArrayList<Plat>() ;
        this.user = new User();
        }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Plat> getOrder() {
        return order;
    }

    public void setOrder(List<Plat> order) {
        this.order = order;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }
}
