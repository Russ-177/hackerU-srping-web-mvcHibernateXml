package controller;

import entity.List;
import exceptions.ListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import services.iterfaces.IListService;
import services.iterfaces.IStorageService;


@Controller
@RequestMapping("/list")
public class ListController {

    @Autowired
    IListService service;

    @Autowired
    IStorageService storageService;

    public void setStorageService(IStorageService storageService) {
        this.storageService = storageService;
    }
    
    public void setService(IListService service) {
        this.service = service;
    }
    
    @GetMapping("/")
    public String list(Model model){
        java.util.List list = service.get();
        if (list == null){
            model.addAttribute("success", false);
            model.addAttribute("message", "Список товаров пуст");
            return "/list/index";
        }
        model.addAttribute("list", list);
        model.addAttribute("success", true);
        return "/list/index";
    }
    
    @GetMapping("/add")
    public String view(Model model){
        model.addAttribute("list", new List());
        model.addAttribute("categories",storageService.get());
        model.addAttribute("action", "insert");
        return "/list/add";
    }
    
    @GetMapping("/edit/{id}")
    public String view(@PathVariable int id, Model model){
        
        List list = service.get(id);
        if (list != null){
            model.addAttribute("success", true);
            model.addAttribute("action", "/list/update");
            model.addAttribute("list",list);
            model.addAttribute("storages",storageService.get());
            return "/list/add";
        }
        model.addAttribute("success", false);
        model.addAttribute("message", "Нет такого товара");
        return "/list/index";
    }
    
    @PostMapping(value = "/update")
    public RedirectView update(@ModelAttribute(value = "list") List list, RedirectAttributes attributes){
        try {
            service.update(list);
        } catch (ListException ex) {
                attributes.addFlashAttribute("success", false);
                attributes.addFlashAttribute("message", ex.getMessage());
            
        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/list/");
    }
    
    @PostMapping(value = "/insert")
    public RedirectView insert(@ModelAttribute(value = "list") List list, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()){
            System.out.println(result.toString());
        }
        try {
            service.insert(list);
        } catch (ListException ex) {
                attributes.addFlashAttribute("success", false);
                attributes.addFlashAttribute("message", ex.getMessage());
            
        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/list/");
    }
    
    @GetMapping(value = "/delete/{id}")
    public RedirectView delete(@PathVariable int id, RedirectAttributes attributes){
        try {
            service.delete(id);
        } catch (ListException ex) {
                attributes.addFlashAttribute("success", false);
                attributes.addFlashAttribute("message", ex.getMessage());
            
        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/list/");
    }
}
