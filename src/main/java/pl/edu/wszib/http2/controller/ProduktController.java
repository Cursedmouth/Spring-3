package pl.edu.wszib.http2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.wszib.http2.service.ProduktService;
import pl.edu.wszib.http2.service.ProfileService;
import pl.edu.wszib.http2.service.exception.NotFoundException;
import pl.edu.wszib.http2.service.model.Filtr;
import pl.edu.wszib.http2.service.model.Produkt;
import pl.edu.wszib.http2.service.model.Profile;

import javax.validation.Valid;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@Controller
@RequestMapping("/produkt")
public class ProduktController {

    @Autowired
    private ProduktService produktService;

    @GetMapping("/list")
    public String listProductView(Filtr filtr, Model model) {
        if(filtr == null) {

            model.addAttribute("produkty", produktService.list());
            model.addAttribute("filtr", new Filtr());
        } else {
            model.addAttribute("produkty", produktService.list(filtr));
            model.addAttribute("filtr", filtr);
        }
        return "produkt/list-produkt";
    }

    @GetMapping("/create")
    public String createProductView(Model model) {
        model.addAttribute("newProdukt", new Produkt());
        return "produkt/create-produkt";

    }

    @PostMapping("/create")
    public String createProductAction(Produkt newProdukt, Model model) {
        newProdukt = produktService.create(newProdukt);
        return "redirect:/produkt/get?id=" + newProdukt.getId();
    }

    @GetMapping("/get")
    public String getProductView(@RequestParam Integer id, Model model) {
        model.addAttribute("produkt", produktService.get(id));
        return "produkt/get-produkt";
    }

    @GetMapping("/update")
    public String updateProductView(@RequestParam Integer id, Model model) {
        model.addAttribute("updateProdukt", produktService.get(id));
        return "produkt/update-produkt";
    }

    @PostMapping("/update")
    public String updateProductAction(Produkt updateProdukt, Model model) {
        updateProdukt = produktService.update(updateProdukt);
        return "redirect:/produkt/get?id=" + updateProdukt.getId();
    }

    @GetMapping("/delete")
    public String deleteProductView(@RequestParam Integer id, Model model) {
        model.addAttribute("produkt", produktService.get(id));
        return "produkt/delete-produkt";
    }

    @PostMapping("/delete")
    public String deleteProductAction(@RequestParam Integer id, Model model) {
        produktService.delete(id);
        return "redirect:/produkt/list";
    }

    @ExceptionHandler(NotFoundException.class)
    public String notFoundView() {
        return "produkt/404-produkt";
    }

}
