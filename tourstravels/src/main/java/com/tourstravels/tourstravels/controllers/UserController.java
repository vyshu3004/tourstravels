package com.tourstravels.tourstravels.controllers;


import com.tourstravels.tourstravels.models.*;
import com.tourstravels.tourstravels.models.Flight;
import com.tourstravels.tourstravels.models.Hotel;
import com.tourstravels.tourstravels.models.User;
import com.tourstravels.tourstravels.services.IFlightService;
import com.tourstravels.tourstravels.services.IHotelService;
import com.tourstravels.tourstravels.services.IUserService;
import com.tourstravels.tourstravels.models.*;
import com.tourstravels.tourstravels.services.*;
import com.tourstravels.tourstravels.services.impl.emailservice;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private emailservice emailservice;
    private static final String USER_REG = "user/register";
    private static final String USER_HOME = "user/home";
    private static final String ADMIN_HOME = "admin/home";
    @Autowired
    private IUserService userService;

    @Autowired
    private HttpServletRequest req;
    @Autowired
    private IHotelService hotelService;
    @Autowired
    private IPlaceService placeService;

    @Autowired
    private IFlightService flightService;
    @Autowired
    private ITourPackageService packageService;

    // User Login page

    @PostMapping("/login")
    public String login(String email, String password, Model model) {
        try {
            if (email.equals("admin@gmail.com") && password.equals("admin")) {
                return ADMIN_HOME;
            }
            if (email.equals("vallampatlavyshnavi1501@gmail.com") && password.equals("vyshnavi")) {
                return USER_HOME;
            }
            User user = userService.findByEmailAndPassword(email, password);
            if (email.equals("") && password.equals("")) {
                return "login";
            }
            if (user != null) {
                req.getSession().setAttribute("user", user);
                return "redirect:/userHome";
            } else {
                model.addAttribute("error", "Invalid credentials");
                return "login";

            }
        } catch (Exception e) {
            model.addAttribute("error", "Please check your details");
            return "login";
        }
    }

    // user registration page

    @PostMapping("/register")
    private String login(Model model) {
        try {

            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String gender = req.getParameter("gender");
            String address = req.getParameter("address");
            String phoneNumber = req.getParameter("phoneNumber");
            String role = req.getParameter("role");
            User user = User.builder()
                    .name(name)
                    .email(email)
                    .password(password)
                    .gender(gender)
                    .address(address)
                    .phoneNumber(phoneNumber)
                    .role(role)
                    .build();
            User u = userService.findByEmailAndPassword(email, password);
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                model.addAttribute("error", "All fields are required");
                return USER_REG;
            }
            if (u != null) {
                model.addAttribute("error", "User already exists");
                return "login";
            } else {
                userService.saveUser(user);

                model.addAttribute("success", "user registered successfully");
                req.getSession().setAttribute("user", user);
                return USER_REG;
            }
        } catch (Exception e) {
            model.addAttribute("error", "invalid credentials");
            return USER_REG;
        }
    }


// user can view the list of places

    @GetMapping("/viewPlaces")
    private String alPlaces(Model model) {
        Place p = (Place) req.getSession().getAttribute("place");
        model.addAttribute("places", placeService.listAll());
        return "user/viewPlaces";
    }

    // user can view the list of hotels

    @GetMapping("/viewHotels")
    private String allHotels(Model model){
        Hotel hotel=(Hotel) req.getSession().getAttribute("hotel");
        model.addAttribute("hotels",hotelService.getAllHotels());
        return "user/viewHotels";
    }

// user can view the list of flights

    @GetMapping("/viewFlights")
    private String allFlights(Model model){
        Flight flight=(Flight) req.getSession().getAttribute("flight");
        model.addAttribute("flights",flightService.getAll());
        return "user/viewFlights";
    }

// user can view the list of packages

    @GetMapping("/viewPackages")
    private String allPackages(Model model){
        TourPackage tourPackage=(TourPackage) req.getSession().getAttribute("tourPackage");
        model.addAttribute("tourPackages",packageService.getAll());
        return "user/viewPackages";
    }

// user can book the required hotel in a list of hotels

    @PostMapping("/bookHotel")
    private String bookingHotel(Model model,Long id) {
            Hotel hotel = (Hotel) req.getSession().getAttribute("hotel");
            int fare=hotelService.getById(id).getFare();
            model.addAttribute("fare",fare);
        emailservice.sendSimpleEmail("vallampatlavyshnavi1501@gmail.com",
                "This is email body",
                "This is email subject");
            return "user/hotelPayment";
    }

    // user can book the required hotel in a list of hotels

    // User can book a flight in the list of flights

    @PostMapping("/bookFlight")
    private String flightBooking(Model model,Long id) {
        Flight flight = (Flight) req.getSession().getAttribute("flight");
        int fare=flightService.getById(id).getFare();
        model.addAttribute("fare",fare);
        return "user/flightPayment";
    }
    // user can book a package in the package list

@PostMapping("/bookPackage")
    private  String packageBooking(Model model,Long pId){
    TourPackage tourPackage=(TourPackage) req.getSession().getAttribute("tourPackage");
    int price=packageService.getById(pId).getPrice();
    model.addAttribute("price",price);
    return "user/tourPackagePayment";
}



}
