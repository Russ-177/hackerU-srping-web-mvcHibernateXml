package services;

import entity.Storage;
import exceptions.StorageException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.interfaces.IRepository;
import services.iterfaces.IStorageService;


@Component
public class StorageService implements IStorageService {
    @Autowired
    IRepository<Storage> repository;

    public void setRepository(IRepository repository) {
        this.repository = repository;
    }
    
    
    @Override
    public void insert(Storage storage) throws StorageException {
        if (!repository.insert(storage))
            throw new StorageException("Storage don't insert");
    }

    @Override
    public void update(Storage storage) throws StorageException {
        if (!repository.update(storage))
            throw new StorageException("Srorage don't update");
    }

    @Override
    public void delete(int id) throws StorageException {
        if (!repository.delete(id))
            throw new StorageException("Storage don't delete");
    }

    @Override
    public List<Storage> get() {
        return repository.get();
    }

    @Override
    public Storage get(int id) {
        return repository.get(id);
    }
    
}
