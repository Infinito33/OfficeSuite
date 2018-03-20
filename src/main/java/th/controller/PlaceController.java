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
import th.database.service.PlaceService;
import th.model.entities.Place;
import th.validator.PlaceValidator;

import java.util.Date;

@Controller
@RequestMapping("/place")
public class PlaceController {

    private PlaceService placeService;
    private PlaceValidator placeValidator;

    @Autowired
    public PlaceController(PlaceService placeService, PlaceValidator placeValidator) {
        this.placeService = placeService;
        this.placeValidator = placeValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(placeValidator);
    }

    @GetMapping("/")
    public String places(Model model) {
        model.addAttribute("places", placeService.findAllWithRelations());
        String status = model.asMap().get("status") == null ? "none" : (String) model.asMap().get("status");
        model.addAttribute("status", status);
        model.addAttribute("message", model.asMap().get("message"));
        return "places/places";
    }

    @GetMapping("/addPlace")
    public String addPlace(ModelMap model) {
        model.addAttribute("place", new Place());
        return "places/addPlace";
    }

    @PostMapping("/addPlace")
    public String addPlace(@ModelAttribute("place") @Validated Place place, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            model.addAttribute("status", "warning");
            model.addAttribute("message", "Błąd walidacji miejsca. Proszę poprawić dane.");
            return "places/addPlace";
        }

        place.setCreationDate(new Date());
        placeService.save(place);
        redirectAttributes.addFlashAttribute("status", "success");
        redirectAttributes.addFlashAttribute("message", "Nowe miejsce zostało dodane");

        return "redirect:/place/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        Place place = placeService.findById(id);
        ModelAndView model = new ModelAndView("places/editPlace", "place", place);
        return model;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, @Validated @ModelAttribute("place") Place place, BindingResult bindingResult, ModelMap model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("status", "warning");
            model.addAttribute("message", "Błąd walidacji miejsca. Proszę poprawić dane.");
            return "places/editPlace";
        }

        place.setCreationDate(placeService.findById(id).getCreationDate());
        placeService.update(place);

        redirectAttributes.addFlashAttribute("status", "success");
        redirectAttributes.addFlashAttribute("message", "Miejsce zostało zmienione.");
        return "redirect:/place/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Integer id) {
        placeService.delete(placeService.findById(id));
        return "redirect:/place/";
    }

    @GetMapping("/info/{id}")
    public ModelAndView info(@PathVariable Integer id, Model model) {
        Place place = placeService.findById(id);
        placeService.initEntityRelations(place);
        ModelAndView modelAndView = new ModelAndView("places/placeInfo", "place", place);
        String returnPathAttr = model.asMap().get("returnPath") == null ? "/place/" : (String) model.asMap().get("returnPath");
        modelAndView.getModelMap().addAttribute("returnPath", returnPathAttr);
        return modelAndView;
    }
}

