package th.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import th.database.service.ClientService;
import th.model.entities.Client;
import th.validator.ClientValidator;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;
    private ClientValidator clientValidator;

    @Autowired
    public ClientController(ClientService clientService, ClientValidator clientValidator) {
        this.clientService = clientService;
        this.clientValidator = clientValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(clientValidator);
        binder.registerCustomEditor(Integer.class, "phone", new CustomNumberEditor(Integer.class, Boolean.TRUE));
        binder.registerCustomEditor(Integer.class, "sex", new CustomNumberEditor(Integer.class, Boolean.FALSE));
        binder.registerCustomEditor(Date.class, "birthDate", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), Boolean.TRUE));
    }

    @GetMapping(value = "/")
    public String clients(Model model) {
        model.addAttribute("clients", clientService.findAll());
        String status = model.asMap().get("status") == null ? "none" : (String) model.asMap().get("status");
        model.addAttribute("status", status);
        model.addAttribute("message", model.asMap().get("message"));

        return "clients/clients";
    }

    @RequestMapping(value = "/addClient", method = RequestMethod.GET)
    public String addClient(ModelMap model) {
        model.addAttribute("client", new Client());
        return "clients/addClient";
    }

    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("client") @Validated Client client,
                            BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("clients", clientService.findAll());
            model.addAttribute("status", "warning");
            model.addAttribute("message", "Błąd walidacji klienta. Proszę poprawić dane.");
            return "clients/addClient";
        }

        client.setCreationDate(new Date());
        clientService.save(client);
        redirectAttributes.addFlashAttribute("status", "success");
        redirectAttributes.addFlashAttribute("message", "Nowy klient został dodany");

        return "redirect:/client/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        Client client = clientService.findById(id);
        ModelAndView model = new ModelAndView("clients/editClient", "client", client);
        client.setBirthDate(new Date(client.getBirthDate().getTime()));
        return model;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, @Validated @ModelAttribute("client") Client client, BindingResult bindingResult, ModelMap model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("status", "warning");
            model.addAttribute("message", "Błąd walidacji klienta. Proszę poprawić dane.");
            return "clients/editClient";
        }

        client.setCreationDate(clientService.findById(id).getCreationDate());
        clientService.update(client);
        redirectAttributes.addFlashAttribute("status", "success");
        redirectAttributes.addFlashAttribute("message", "Klient został zmieniony.");
        return "redirect:/client/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Integer id) {
        clientService.delete(clientService.findById(id));
        return "redirect:/client/";
    }

    @GetMapping("/info/{id}")
    public ModelAndView info(@PathVariable Integer id, Model model) {
        Client client = clientService.findById(id);
        ModelAndView modelAndView = new ModelAndView("clients/clientInfo", "client", client);
        String returnPathAttr = model.asMap().get("returnPath") == null ? "/client/" : (String) model.asMap().get("returnPath");
        modelAndView.getModelMap().addAttribute("returnPath", returnPathAttr);
        return modelAndView;
    }

    @Transactional
    @GetMapping("/showClientTrips/{id}")
    public ModelAndView showClientTrips(ModelMap model, @PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/trip/clTrips/" + id, model);
        return modelAndView;
    }
}
