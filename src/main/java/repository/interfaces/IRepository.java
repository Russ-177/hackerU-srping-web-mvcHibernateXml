package repository.interfaces;

import java.util.List;


public interface IRepository<T> {
    T get(int id);
    List<T> get();
    boolean insert(T item);
    boolean update(T item);
    boolean delete(int id);
}
