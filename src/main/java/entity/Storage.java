package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class Storage implements Serializable{
    private int id;
    private String name;
    private List<List> list;
    
    public Storage(){}

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

    public List<List> getList() {
        return list;
    }

    public void setList(List<List> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Storage{" + "id=" + id + ", name=" + name + ", list=" + list + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.list);
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
        final Storage other = (Storage) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.list, other.list)) {
            return false;
        }
        return true;
    }
    
    
    
}
