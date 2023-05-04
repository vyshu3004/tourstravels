package com.tourstravels.tourstravels.controllers;

import com.tourstravels.tourstravels.models.User;
import com.tourstravels.tourstravels.services.IHotelService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class HomeController {

    private static final String ADMIN_ADDPLACES = "admin/addPlaces";
    private static final String ADMIN_ADDHOTELS ="admin/addHotels" ;
    private static final String ADMIN_ADDFLIGHTS = "admin/addFlights";
    private static final String ADMIN_PACKAGES ="admin/addPackages" ;
    @Autowired
    private HttpServletRequest req;
    @Autowired
    private IHotelService hotelService;

// Home Page

    @GetMapping("/")
    private String home(){
        return  "index";
    }
// Login page

    @GetMapping("/login")
    private String login(){
        return "login";
    }

    //Registration page 
    
    @GetMapping("/register")
    private String register(){
        return "user/register";
    }

    // User Home Page

    @GetMapping("/userHome")
    private String login(Model model){
       User u= (User) req.getSession().getAttribute("user");
        if (u !=null){
            model.addAttribute("user",u);
            return "user/home";
        }else {
            return "login";
        }
    }

    //Add palces page

    @GetMapping("/addPlaces")
    private String addPlaces(){
        return  ADMIN_ADDPLACES;
    }


// Add Hotels page

    @GetMapping("/addHotels")
    private String  addHotels(){
        return ADMIN_ADDHOTELS;
    }

// Add Flights page

    @GetMapping("/addFlights")
    private  String  addFlights(){
        return ADMIN_ADDFLIGHTS;
    }

    //  Add Packages page

    @GetMapping("/addPackages")
    private  String  addPackages(){
        return  ADMIN_PACKAGES;
    }


// returns a page where  user can  book flight by id 

@GetMapping("/bookFlight/{id}")
    private  String bookFlight(Model model, @PathVariable Long id){
        model.addAttribute("flight",id);
        return "user/bookFlight";
}

// return a page where user can book package by package id

@GetMapping("/bookPackage/{id}")
    private String bookPackage(Model model,@PathVariable Long id){
        model.addAttribute("tourPackage",id);
        return "user/bookPackage";
}

// returns a page where user can book a hotel by hotel id

@GetMapping("/bookHotel/{id}")
    private String  bookHotel(Model model,@PathVariable Long id){
        model.addAttribute("hotel",id);
        return "user/bookHotel";
}

// returns flight payment page

@GetMapping("/flightPayment")
    private String  flightPayment(){
        return "user/flightPayment";
}
}

