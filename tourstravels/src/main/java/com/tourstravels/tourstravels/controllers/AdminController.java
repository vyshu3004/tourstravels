package com.tourstravels.tourstravels.controllers;

import com.tourstravels.tourstravels.models.Flight;
import com.tourstravels.tourstravels.models.Hotel;
import com.tourstravels.tourstravels.models.Place;
import com.tourstravels.tourstravels.models.TourPackage;
import com.tourstravels.tourstravels.services.*;
import com.tourstravels.tourstravels.services.IHotelService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;


@Controller
public class AdminController {
    private static final String ADMIN_ADDPLACES = "admin/addPlaces";
    private static final String ADMIN_ADDHOTELS = "admin/addHotels";
    private static final String ADMIN_ADDFLIGHTS = "admin/addFlights";
    private static final String ADMIN_ADDPACKAGES = "admin/addPackages";
    @Autowired
    private IHotelService hotelService;
    @Autowired
    private HttpServletRequest req;
    @Autowired
    private IPlaceService placeService;
    @Autowired
    private IFlightService flightService;
    @Autowired
    private ITourPackageService packageService;


    // Hotels are adding by admin

    @PostMapping("/addHotels")
    private String addHotels(Model model,MultipartFile photo) {
        try {
            String hName = req.getParameter("hName");
            String fare = req.getParameter("fare");
            String city = req.getParameter("city");
            String state = req.getParameter("state");
            String country = req.getParameter("country");
            Hotel hotel = Hotel.builder()
                    .hName(hName)
                    .fare(Integer.parseInt(fare))
                    .city(city)
                    .state(state)
                    .country(country)
                    .photo(Base64.getEncoder().encodeToString(photo.getBytes()))
                    .build();
            boolean checkHotel = hotelService.getByHotelName(hName) == null;
            if (checkHotel) {
                hotelService.saveHotel(hotel);
                req.getSession().setAttribute("hotel", hotel);
                model.addAttribute("success", "Hotel Added successfully");
                return ADMIN_ADDHOTELS;
            } else {
                model.addAttribute("error", "hotel already exist");
                return ADMIN_ADDHOTELS;
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getLocalizedMessage());
            return ADMIN_ADDHOTELS;
        }
    }


    // places are adding by admin

    @PostMapping("/addPlaces")
    private String addPlaces(Model model, MultipartFile photo) {
        try {
            String pname = req.getParameter("pname");
            String description = req.getParameter("description");
            String city = req.getParameter("city");
            String state = req.getParameter("state");
            String country = req.getParameter("country");
            Place place = Place.builder()
                    .pname(pname)
                    .description(description)
                    .city(city)
                    .state(state)
                    .country(country)
                    .photo(Base64.getEncoder().encodeToString(photo.getBytes()))
                    .build();
            boolean checkPlace = placeService.getByPlaceName(pFname) != null;
            if (checkPlace) {
                model.addAttribute("error", "This place already exists");
                return "admin/addPlaces";
            } else {
                placeService.addPlaces(place);
                req.getSession().setAttribute("place", place);
                model.addAttribute("success", "Place added successfully");
                return "admin/addPlaces";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Place not added");
            return "admin/addPlaces";
        }
    }



// admin adding flights

    @PostMapping("/addFlights")
    private String addFlights(Model model) {
        try {
            String fName = req.getParameter("fName");
            String fare = req.getParameter("fare");
            String fromCity = req.getParameter("fromCity");
            String toCity = req.getParameter("toCity");
            String fromState = req.getParameter("fromState");
            String formCountry = req.getParameter("fromCountry");
            String toState = req.getParameter("toState");
            String toCountry = req.getParameter("toCountry");
            Flight flight = Flight.builder()
                    .fName(fName)
                    .fare(Integer.parseInt(fare))
                    .fromCity(fromCity)
                    .fromState(fromState)
                    .fromCountry(formCountry)
                    .toCity(toCity)
                    .toState(toState)
                    .toCountry(toCountry)
                    .build();
            boolean checkByfName = flightService.findByfName(fName) != null;
            if (checkByfName) {
                model.addAttribute("error", "FLight name already exist");
                return ADMIN_ADDFLIGHTS;
            } else {
                flightService.saveFlight(flight);
                req.getSession().setAttribute("flight", flight);
                model.addAttribute("success", "Flight Added SuccessFully");
                return ADMIN_ADDFLIGHTS;
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getLocalizedMessage());
            return ADMIN_ADDFLIGHTS;
        }
    }

    // Admin Addding packages

    @PostMapping("/addPackages")
    private String addPackages(Model model, MultipartFile photo) {
        try {
            String pkgName = req.getParameter("pkgName");
            int price = Integer.parseInt(req.getParameter("price"));
            String city = req.getParameter("city");
            String state = req.getParameter("state");
            String country = req.getParameter("country");
            TourPackage tourPackage = TourPackage.builder()
                    .pkgName(pkgName)
                    .price(price)
                    .city(city)
                    .state(state)
                    .country(country)
                    .photo(Base64.getEncoder().encodeToString(photo.getBytes()))
                    .build();
            boolean checkByTourPkgName = packageService.getByPackageName(pkgName) != null;
            if (checkByTourPkgName) {
                model.addAttribute("error", "package name already exist");
                return ADMIN_ADDPACKAGES;
            } else {
                packageService.savePackage(tourPackage);
                req.getSession().setAttribute("tourPackage",tourPackage);
                model.addAttribute("success","package added successfully");
                return  ADMIN_ADDPACKAGES;
            }
        }catch (Exception e){
            model.addAttribute("error",e.getLocalizedMessage());
            return  ADMIN_ADDPACKAGES;
        }
}






}
