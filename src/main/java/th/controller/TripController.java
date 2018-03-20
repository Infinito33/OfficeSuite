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
import th.database.service.HotelService;
import th.database.service.PlaceService;
import th.database.service.TripService;
import th.model.entities.Client;
import th.model.entities.Trip;
import th.validator.TripValidator;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/trip")
public class TripController {

    private TripService tripService;
    private ClientService clientService;
    private PlaceService placeService;
    private HotelService hotelService;
    private TripValidator tripValidator;

    @Autowired
    public TripController(TripService tripService, TripValidator tripValidator, ClientService clientService, PlaceService placeService, HotelService hotelService) {
        this.tripService = tripService;
        this.tripValidator = tripValidator;
        this.hotelService = hotelService;
        this.placeService = placeService;
        this.clientService = clientService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(tripValidator);
    }

    @GetMapping("/")
    public String trips(Model model) {
        model.addAttribute("trips", tripService.findAllWithRelations());
        String status = model.asMap().get("status") == null ? "none" : (String) model.asMap().get("status");
        model.addAttribute("status", status);
        model.addAttribute("message", model.asMap().get("message"));

        return "trips/trips";
    }

    @GetMapping("/addTrip")
    public String addTrip(ModelMap model) {
        model.addAttribute("trip", new Trip());
        model.addAttribute("clients", clientService.findAllWithRelations());
        model.addAttribute("hotels", hotelService.findAllWithRelations());
        model.addAttribute("places", placeService.findAllWithRelations());
        return "trips/addTrip";
    }

    @PostMapping("/addTrip")
    public String addTrip(@ModelAttribute("trip") @Validated Trip trip, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("clients", clientService.findAllWithRelations());
            model.addAttribute("hotels", hotelService.findAllWithRelations());
            model.addAttribute("places", placeService.findAllWithRelations());
            model.addAttribute("status", "warning");
            model.addAttribute("message", "Błąd walidacji wycieczki. Proszę poprawić dane.");
            return "trips/addTrip";
        }

        trip.setCreationDate(new Date());
        tripService.save(trip);
        redirectAttributes.addFlashAttribute("status", "success");
        redirectAttributes.addFlashAttribute("message", "Nowa wycieczka została dodana");

        return "redirect:/trip/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        Trip trip = tripService.findByIdWithRelations(id);
        ModelAndView model = new ModelAndView("trips/editTrip", "trip", trip);
        model.getModelMap().addAttribute("clients", clientService.findAll());
        model.getModelMap().addAttribute("hotels", hotelService.findAllWithRelations());
        model.getModelMap().addAttribute("places", placeService.findAll());
        return model;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, @Validated @ModelAttribute("trip") Trip trip, BindingResult bindingResult, ModelMap model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("status", "warning");
            model.addAttribute("message", "Błąd walidacji wycieczki. Proszę poprawić dane.");
            return "trips/editTrip";
        }

        trip.setCreationDate(tripService.findById(id).getCreationDate());
        tripService.update(trip);
        redirectAttributes.addFlashAttribute("status", "success");
        redirectAttributes.addFlashAttribute("message", "Wycieczka została zmieniona.");
        return "redirect:/trip/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Integer id) {
        tripService.delete(tripService.findById(id));
        return "redirect:/trip/";
    }

    @GetMapping("/info/{id}")
    public ModelAndView info(@PathVariable Integer id, Model model) {
        Trip trip = tripService.findById(id);
        tripService.initEntityRelations(trip);
        ModelAndView modelAndView = new ModelAndView("trips/tripInfo", "trip", trip);
        String returnPathAttr = model.asMap().get("returnPath") == null ? "/hotel/" : (String) model.asMap().get("returnPath");
        modelAndView.getModelMap().addAttribute("returnPath", returnPathAttr);
        return modelAndView;
    }

    @GetMapping("/clientInfo/{id}")
    public ModelAndView showClientInfo(@PathVariable Integer id, final RedirectAttributes redirectAttributes) {
        ModelAndView model = new ModelAndView("redirect:/client/info/{id}");
        redirectAttributes.addFlashAttribute("returnPath", "/trip/");
        return model;
    }

    @GetMapping("/placeInfo/{id}")
    public ModelAndView showPlaceInfo(@PathVariable Integer id, final RedirectAttributes redirectAttributes) {
        ModelAndView model = new ModelAndView("redirect:/place/info/{id}");
        redirectAttributes.addFlashAttribute("returnPath", "/trip/");
        return model;
    }

    @GetMapping("/hotelInfo/{id}")
    public ModelAndView showHotelInfo(@PathVariable Integer id, final RedirectAttributes redirectAttributes) {
        ModelAndView model = new ModelAndView("redirect:/hotel/info/{id}");
        redirectAttributes.addFlashAttribute("returnPath", "/trip/");
        return model;
    }

    /**
     * Shows trips that belongs to a single client.
     */
    @GetMapping("/clTrips/{id}")
    public String getClientTrips(@PathVariable Integer id, Model model) {
        List<Trip> tripsFromClient = tripService.findByClientId(id);
        model.addAttribute("trips", tripsFromClient);
        return "trips/clientTrips";
    }
}
