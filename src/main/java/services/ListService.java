package services;

import entity.List;
import exceptions.ListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import repository.impl.ListRepository;
import services.iterfaces.IListService;


@Component
@RequestScope
public class ListService implements IListService {

    @Autowired
    ListRepository repository;

    public void setRepository(ListRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public void insert(List list) throws ListException {
        if (!repository.insert(list))
            throw new ListException("List don't insert");
    }

    @Override
    public void update(List list) throws ListException {
        if (!repository.update(list))
            throw new ListException("List don't update");
    }

    @Override
    public void delete(int id) throws ListException {
        if (!repository.delete(id))
            throw new ListException("List don't delete");
    }

    @Override
    public java.util.List get() {
        return repository.get();
    }

    @Override
    public List get(int id) {
        return repository.get(id);
    }
    
}
