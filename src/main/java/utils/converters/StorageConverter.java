
package utils.converters;

import entity.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import services.iterfaces.IStorageService;


public class StorageConverter implements Converter<String, Storage>{

    
    @Autowired
    IStorageService service;

    public void setService(IStorageService service) {
        this.service = service;
    }

    @Override
    public Storage convert(String s) {
        return service.get(Integer.parseInt(s));
    }
    
    
    
    
}
