package th.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import th.database.service.ClientService;
import th.database.service.PolisazycieService;
import th.model.entities.Polisazycie;
import th.validator.PolisazycieValidator;

import java.util.Date;

@Controller
@RequestMapping("/polisazycie")
public class PolisazycieController {

    private PolisazycieService polisazycieService;
    private PolisazycieValidator polisazycieValidator;
    private ClientService clientService;

    @Autowired
    public PolisazycieController(PolisazycieService polisazycieService, PolisazycieValidator polisazycieValidator, ClientService clientService) {
        this.polisazycieService = polisazycieService;
        this.polisazycieValidator = polisazycieValidator;
        this.clientService = clientService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(polisazycieValidator);
    }

    @GetMapping("/")
    public String polisazycies(Model model) {
        model.addAttribute("polisazycies", polisazycieService.findAllWithRelations());
        String status = model.asMap().get("status") == null ? "none" : (String) model.asMap().get("status");
        model.addAttribute("status", status);
        model.addAttribute("message", model.asMap().get("message"));
        return "polisazycies/polisazycies";
    }

    @GetMapping("/addPolisazycie")
    public String addPolisazycie(ModelMap model) {
        model.addAttribute("polisazycie", new Polisazycie());
        model.addAttribute("clients", clientService.findAll());
        return "polisazycies/addPolisazycie";
    }

    @PostMapping("/addPolisazycie")
    public String addPolisazycie(@ModelAttribute("polisazycie") @Validated Polisazycie polisazycie, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            model.addAttribute("clients", clientService.findAll());
            model.addAttribute("status", "warning");
            model.addAttribute("message", "Błąd walidacji polisy. Proszę poprawić dane.");
            return "polisazycies/addPolisazycie";
        }

        polisazycie.setCreationDate(new Date());
        polisazycieService.save(polisazycie);
        redirectAttributes.addFlashAttribute("status", "success");
        redirectAttributes.addFlashAttribute("message", "Nowa polisa została dodana.");

        return "redirect:/polisazycie/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        Polisazycie polisazycie = polisazycieService.findById(id);
        ModelAndView model = new ModelAndView("polisazycies/editPolisazycie", "polisazycie", polisazycie);
        model.getModelMap().addAttribute("clients", clientService.findAll());
        return model;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, @Validated @ModelAttribute("polisazycie") Polisazycie polisazycie, BindingResult bindingResult, ModelMap model, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("clients", clientService.findAll());
            model.addAttribute("status", "warning");
            model.addAttribute("message", "Błąd walidacji polisy. Proszę poprawić dane.");
            return "polisazycies/editPolisazycie";
        }

        polisazycie.setCreationDate(polisazycieService.findById(id).getCreationDate());
        polisazycieService.update(polisazycie);
        redirectAttributes.addFlashAttribute("status", "success");
        redirectAttributes.addFlashAttribute("message", "Polisa została zmieniona.");
        return "redirect:/polisazycie/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Integer id) {
        polisazycieService.delete(polisazycieService.findById(id));
        return "redirect:/polisazycie/";
    }

    @GetMapping("/info/{id}")
    public ModelAndView info(@PathVariable Integer id) {
        Polisazycie polisazycie = polisazycieService.findById(id);
        polisazycieService.initEntityRelations(polisazycie);
        ModelAndView model = new ModelAndView("polisazycies/polisazycieInfo", "polisazycie", polisazycie);
        return model;
    }
}