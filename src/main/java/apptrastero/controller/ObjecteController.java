package apptrastero.controller;

import apptrastero.models.entity.Objecte;
import apptrastero.models.entity.Ubicacio;
import apptrastero.models.service.IUbicacioService;
import apptrastero.models.service.IObjecteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/views/objectes")
public class ObjecteController {

    @Autowired
    private IObjecteService objecteService;

    @Autowired
    private IUbicacioService ubicacioService;

    @GetMapping("/")
    public String listarObjectes(Model model) {
        List<Objecte> listadoObjectes = objecteService.listarTodos();
        model.addAttribute("titulo", "Llista d'Objectes");
        model.addAttribute("objectes", listadoObjectes);
        return "/views/objectes/llistar";
    }

    @GetMapping("/create")
    public String crear(Model model) {

        Objecte objecte = new Objecte();
        List<Ubicacio> listUbicacions = ubicacioService.listaUbicaciones();
        model.addAttribute("title", "Nou Objecte");
        model.addAttribute("objecte", objecte);
        model.addAttribute("ubicacions", listUbicacions);

        return "/views/objectes/frmCrear";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Objecte objecte, BindingResult result,
                       Model model, RedirectAttributes redirectAttributes) {
        List<Ubicacio> listUbicacions = ubicacioService.listaUbicaciones();

        if (result.hasErrors()) {
            model.addAttribute("title", "Nou Objecte");
            model.addAttribute("objecte", objecte);
            model.addAttribute("ubicacions", listUbicacions);
            System.out.println("Hi ha errors al formulari");
            return "/views/objectes/frmCrear";
        }
        objecteService.guardar(objecte);
        redirectAttributes.addFlashAttribute("success", "Objecte guardat amb èxit!");
        return "redirect:/views/objectes/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long idObjecte, Model model, RedirectAttributes redirectAttributes) {
        Objecte objecte = null;
        if (idObjecte > 0) {
            objecte = objecteService.buscarPorId(idObjecte);
            if (objecte == null) {
                redirectAttributes.addFlashAttribute("error", "L'ID del objecte no existeix");
                return "redirect:/views/objectes/";
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Error amb l'ID de l'objecte");
            return "redirect:/views/objectes/";
        }

        List<Ubicacio> listUbicacions = ubicacioService.listaUbicaciones();
        model.addAttribute("title", "Modificar Objecte");
        model.addAttribute("objecte", objecte);
        model.addAttribute("ubicacions", listUbicacions);

        return "/views/objectes/frmCrear";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long idObjecte, RedirectAttributes redirectAttributes) {

        Objecte objecte = null;
        if (idObjecte > 0) {
            objecte = objecteService.buscarPorId(idObjecte);
            if (objecte == null) {
                redirectAttributes.addFlashAttribute("error", "L'ID del objecte no existeix");
                return "redirect:/views/objectes/";
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Error amb l'ID de l'objecte");
            return "redirect:/views/objectes/";
        }
        objecteService.eliminar(idObjecte);
        System.out.println("Objecte eliminat");
        redirectAttributes.addFlashAttribute("warning", "Objecte eliminat");
        return "redirect:/views/objectes/";
    }

}
