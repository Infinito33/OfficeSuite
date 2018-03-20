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
import th.database.service.S7Service;
import th.model.entities.S7;
import th.validator.S7Validator;

@Controller
@RequestMapping("/s7")
public class S7Controller {

    private S7Service s7Service;
    private S7Validator s7Validator;

    @Autowired
    public S7Controller(S7Service s7Service, S7Validator s7Validator) {
        this.s7Service = s7Service;
        this.s7Validator = s7Validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(s7Validator);
    }

    @GetMapping("/")
    public String s7s(ModelMap model) {
        model.addAttribute("s7s", s7Service.findAllWithRelations());

        return "s7s/s7s";
    }

    @GetMapping("/addS7")
    public String addS7(ModelMap model) {
        model.addAttribute("s7", new S7());
        return "s7s/addS7";
    }

    @PostMapping("/addS7")
    public String addS7(@ModelAttribute("s7") @Validated S7 s7, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "s7s/addS7";
        }

        s7Service.save(s7);

        return "redirect:/s7/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        S7 s7 = s7Service.findById(id);
        ModelAndView model = new ModelAndView("s7s/editS7", "s7", s7);
        return model;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, @Validated @ModelAttribute("s7") S7 s7, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "s7s/editS7";
        }

        s7Service.update(s7);
        return "redirect:/s7/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Integer id) {
        s7Service.delete(s7Service.findById(id));
        return "redirect:/s7/";
    }

    @GetMapping("/info/{id}")
    public ModelAndView info(@PathVariable Integer id) {
        S7 s7 = s7Service.findById(id);
        s7Service.initEntityRelations(s7);
        ModelAndView model = new ModelAndView("s7s/s7Info", "s7", s7);
        return model;
    }
}