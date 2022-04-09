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
import pl.edu.wszib.http2.service.ToDoService;
import pl.edu.wszib.http2.service.exception.NotFoundException;
import pl.edu.wszib.http2.service.model.Produkt;
import pl.edu.wszib.http2.service.model.Profile;
import pl.edu.wszib.http2.service.model.ToDo;

import javax.validation.Valid;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@Controller
@RequestMapping("/toDo")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("/list")
    public String listToDoView(Model model) {
        ToDo toDo = new ToDo();
        ToDo.setZadanie("Skok przez płot");
        ToDo.setStatus(IN_PROGRESS);
        ToDo.setTermin("dziś");
        toDoService.create(toDo);


        model.addAttribute("toDosy", toDoService.list());
        return "toDo/list-toDo";
    }
}
