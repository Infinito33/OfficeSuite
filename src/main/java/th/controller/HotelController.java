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
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import th.database.service.HotelService;
import th.database.service.PlaceService;
import th.converter.PlaceConverter;
import th.model.entities.Hotel;
import th.validator.HotelValidator;

import java.util.Date;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    private HotelService hotelService;
    private HotelValidator hotelValidator;
    private PlaceService placeService;

    @Autowired
    public HotelController(HotelService hotelService, HotelValidator hotelValidator, PlaceService placeService) {
        this.hotelService = hotelService;
        this.hotelValidator = hotelValidator;
        this.placeService = placeService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(hotelValidator);
    }

    @GetMapping("/")
    public String hotels(Model model) {
        model.addAttribute("hotels", hotelService.findAllWithRelations());
        String status = model.asMap().get("status") == null ? "none" : (String) model.asMap().get("status");
        model.addAttribute("status", status);
        model.addAttribute("message", model.asMap().get("message"));

        return "hotels/hotels";
    }

    @GetMapping("/addHotel")
    public String addHotel(ModelMap model) {
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("places", placeService.findAll());
        return "hotels/addHotel";
    }

    @PostMapping("/addHotel")
    public String addHotel(@ModelAttribute("hotel") @Validated Hotel hotel, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("places", placeService.findAll());
            model.addAttribute("status", "warning");
            model.addAttribute("message", "Błąd walidacji hotelu. Proszę poprawić dane.");
            return "hotels/addHotel";
        }

        hotel.setCreationDate(new Date());
        hotelService.save(hotel);
        redirectAttributes.addFlashAttribute("status", "success");
        redirectAttributes.addFlashAttribute("message", "Nowy hotel został dodany");

        return "redirect:/hotel/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        Hotel hotel = hotelService.findById(id);
        ModelAndView model = new ModelAndView("hotels/editHotel", "hotel", hotel);
        return model;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, @Validated @ModelAttribute("hotel") Hotel hotel, BindingResult bindingResult, ModelMap model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("status", "warning");
            model.addAttribute("message", "Błąd walidacji hotelu. Proszę poprawić dane.");
            return "hotels/editHotel";
        }

        hotel.setCreationDate(hotelService.findById(id).getCreationDate());
        hotelService.update(hotel);
        redirectAttributes.addFlashAttribute("status", "success");
        redirectAttributes.addFlashAttribute("message", "Hotel został zmieniony.");
        return "redirect:/hotel/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Integer id) {
        hotelService.delete(hotelService.findById(id));
        return "redirect:/hotel/";
    }

    @GetMapping("/info/{id}")
    public ModelAndView info(@PathVariable Integer id, Model model) {
        Hotel hotel = hotelService.findById(id);
        ModelAndView modelAndView = new ModelAndView("hotels/hotelInfo", "hotel", hotel);
        String returnPathAttr = model.asMap().get("returnPath") == null ? "/hotel/" : (String) model.asMap().get("returnPath");
        modelAndView.getModelMap().addAttribute("returnPath", returnPathAttr);
        return modelAndView;
    }
}
