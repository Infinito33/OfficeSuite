package th.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import th.database.service.*;
import th.model.entities.Client;
import th.model.entities.Trip;
import th.model.entities.User;
import th.model.entities.UserProfile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @Autowired
    private PlaceService placeService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private TripService tripService;


    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String showDashboard(ModelMap model) throws IOException {
        model.addAttribute("loggedinuser", getPrincipal());

        List<Trip> trips = tripService.findAllWithRelations();
        Map<String, Double> tripsWithAmount = getTripsWithAmount(trips);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(tripsWithAmount);

        model.addAttribute("tripsWithAmount", json);
        Map<String, Double> tripsWithPercentage = getTripsWithPercentage(tripsWithAmount, trips.size());
        model.addAttribute("tripsWithPercentage", tripsWithPercentage);

        model.addAttribute("clientsAmount", clientService.count());
        model.addAttribute("tripsAmount", tripService.count());
        model.addAttribute("hotelsAmount", hotelService.count());
        model.addAttribute("placesAmount", placeService.count());
        return "index";
    }

    private Map<String, Double> getTripsWithPercentage(Map<String, Double> tripsWithAmount, int tripSize) {
        Map<String, Double> tripsWithPercentage = new HashMap<>();
        tripsWithAmount.forEach((k, v) -> {
            double value = Math.round((v * 100 / tripSize)  * 100d) / 100d;
            tripsWithPercentage.put(k, value);
        });

        return tripsWithPercentage;
    }

    private Map<String, Double> getTripsWithAmount(List<Trip> trips) {
        Map<String, Double> tripsWithAmount = new HashMap<>();
        for (Trip trip : trips) {
            tripsWithAmount.putIfAbsent(trip.getPlace().getCountry(), 0.0);
            tripsWithAmount.computeIfPresent(trip.getPlace().getCountry(), (k, v) -> v + 1.0);
        }
        return tripsWithAmount;
    }

    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
        return "userslist";
    }

    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public ModelAndView newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return new ModelAndView("registration", model);
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = {"/newuser"}, method = RequestMethod.POST)
    public String newUser(@Valid User user, BindingResult result,
                          ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        /*
         * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation
         * and applying it on field [sso] of Model class [User].
         *
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         *
         */
        if (!userService.isUserSSOUnique(user.getId(), user.getSsoId())) {
            FieldError ssoError = new FieldError("user", "ssoId", messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registration";
        }

        userService.saveUser(user);

        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "registrationsuccess";
    }


    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = {"/edit-user-{ssoId}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String ssoId, ModelMap model) {
        User user = userService.findBySSO(ssoId);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-user-{ssoId}"}, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
                             ModelMap model, @PathVariable String ssoId) {

        if (result.hasErrors()) {
            return "registration";
        }

        /*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
        if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
            FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registration";
        }*/


        userService.updateUser(user);

        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }


    /**
     * This method will delete an user by it's SSOID value.
     */
    @RequestMapping(value = {"/delete-user-{ssoId}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String ssoId) {
        userService.deleteUserBySSO(ssoId);
        return "redirect:/list";
    }


    /**
     * This method will provide UserProfile list to views
     */
    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }

    /**
     * This method handles Access-Denied redirect.
     */
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "accessDenied";
    }

    /**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(ModelMap model) {
        if (isCurrentAuthenticationAnonymous()) {
            return new ModelAndView("login", model);
        } else {
            return new ModelAndView("redirect:/", model);
        }
    }

    @GetMapping("/showClients")
    public ModelAndView showClients(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("redirect:/client/", model);
        return modelAndView;
    }

    @GetMapping("/addClient")
    public String addClient(ModelMap model) {
        model.addAttribute("client", new Client());
        return "clients/addClient";
    }

    @GetMapping("/showTrips")
    public ModelAndView showTrips(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("redirect:/trip/", model);
        return modelAndView;
    }

    @GetMapping("/addTrip")
    public String addTrip(ModelMap model) {
        return "redirect:/trip/addTrip";
    }

    @GetMapping("/showHotels")
    public ModelAndView showHotels(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("redirect:/hotel/", model);
        return modelAndView;
    }

    @GetMapping("/addHotel")
    public String addHotel(ModelMap model) {
        return "redirect:/hotel/addHotel";
    }

    @GetMapping("/showPlaces")
    public ModelAndView showPlaces(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("redirect:/place/", model);
        return modelAndView;
    }

    @GetMapping("/addPlace")
    public String addPlace(ModelMap model) {
        return "redirect:/place/addPlace";
    }

    @GetMapping("/showPolisazycies")
    public ModelAndView showPolisazycies(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("redirect:/polisazycie/", model);
        return modelAndView;
    }

    @GetMapping("/addPolisazycie")
    public String addPolisazycie(ModelMap model) {
        return "redirect:/polisazycie/addPolisazycie";
    }

    /**
     * This method handles logout requests.
     * Toggle the handlers if you are RememberMe functionality is useless in your app.
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }

    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    /**
     * This method returns true if users is already authenticated [logged-in], else false.
     */
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
}
