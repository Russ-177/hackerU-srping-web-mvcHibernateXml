package controller;

import entity.Storage;
import exceptions.StorageException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import services.iterfaces.IStorageService;


@Controller
@RequestMapping("/storage")
public class StorageController {
    
    @Autowired
    IStorageService service;

    public void setService(IStorageService service) {
        this.service = service;
    }
    
    @GetMapping("/")
    public String get(Model model){
        List<Storage> list = service.get();
        if (list == null){
            model.addAttribute("success", false);
            model.addAttribute("message", "Список товаров пуст");
            return "/storage/ndex";
        }
        model.addAttribute("storages", list);
        model.addAttribute("success", true);
        return "/storage/index";
    }
    
    @GetMapping("/add")
    public String view(Model model){
        model.addAttribute("storage", new Storage());
        model.addAttribute("action", "insert");
        return "/storage/add";
    }
    
    @GetMapping("/edit/{id}")
    public String view(@PathVariable int id, Model model){
        
        Storage storage = service.get(id);
        if (storage != null){
            model.addAttribute("success", true);
            model.addAttribute("action", "/storage/update");
            model.addAttribute("storage", storage);
            return "/storage/add";
        }
        model.addAttribute("success", false);
        model.addAttribute("message", "Склад не найден");
        return "/storage/add";
    }
    
    @PostMapping(value = "/update")
    public RedirectView update(@ModelAttribute(value = "storage") Storage storage, RedirectAttributes attributes){
        try {
            service.update(storage);
        } catch (StorageException ex) {
                attributes.addFlashAttribute("success", false);
                attributes.addFlashAttribute("message", ex.getMessage());
            
        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/storage/");
    }
    
    @PostMapping(value = "/insert")
    public RedirectView insert(@ModelAttribute(value = "storage") Storage storage, RedirectAttributes attributes){
        try {
            service.insert(storage);
        } catch (StorageException ex) {
                attributes.addFlashAttribute("success", false);
                attributes.addFlashAttribute("message", ex.getMessage());
            
        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/storage/");
    }
    
    @GetMapping(value = "/delete/{id}")
    public RedirectView delete(@PathVariable int id, RedirectAttributes attributes){
        try {
            service.delete(id);
        } catch (StorageException ex) {
                attributes.addFlashAttribute("success", false);
                attributes.addFlashAttribute("message", ex.getMessage());
            
        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/storage/");
    }
}
