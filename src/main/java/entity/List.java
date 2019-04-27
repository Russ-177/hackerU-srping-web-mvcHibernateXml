package entity;

import java.io.Serializable;
import java.util.Objects;


public class List implements Serializable{
    private int id;
    private String name;
    private int article;
    private Storage storage;
    private int price;
    
    public List(){}

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

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int restriction) {
        this.price = restriction;
    }

    @Override
    public String toString() {
        return "List{" + "id=" + id + ", name=" + name + ", article=" + article + ", storage=" + storage + ", price=" + price + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + this.article;
        hash = 29 * hash + Objects.hashCode(this.storage);
        hash = 29 * hash + this.price;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final List other = (List) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.article != other.article) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.storage, other.storage)) {
            return false;
        }
        return true;
    }
    
    
    
}
