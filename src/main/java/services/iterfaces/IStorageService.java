package services.iterfaces;

import entity.Storage;
import exceptions.StorageException;
import java.util.List;


public interface IStorageService {
    void insert(Storage storage) throws StorageException;
    void update(Storage storage) throws StorageException;
    void delete(int id) throws StorageException;
    List<Storage> get();
    Storage get(int id);
}
