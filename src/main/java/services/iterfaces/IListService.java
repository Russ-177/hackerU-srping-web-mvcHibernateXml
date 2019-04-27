package services.iterfaces;

import entity.List;
import exceptions.ListException;


public interface IListService {
    void insert(List list) throws ListException;
    void update(List list) throws ListException;
    void delete(int id) throws ListException;
    java.util.List get();
    List get(int id);
}
