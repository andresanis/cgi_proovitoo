package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistEntity;
import com.cgi.dentistapp.service.interfaces.DentistService;
import com.cgi.dentistapp.service.interfaces.DentistVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {

    @Autowired
    private DentistVisitService dentistVisitService;

    @Autowired
    private DentistService dentistService;

    private List<DentistEntity> dentists;

    private DentistVisitDTO dentistVisitDTO = new DentistVisitDTO();

    private List<String> times = new ArrayList<>();


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
        dentists = dentistService.getAllDentists();
        times.add("10:00");
        times.add("11:00");
        times.add("12:00");
        times.add("13:00");
    }

    @GetMapping("/")
    public String showRegisterForm(DentistVisitDTO dentistVisitDTO) {
        return "form";
    }

    @PostMapping("/")
    public String postRegisterForm(@Valid DentistVisitDTO dentistVisitDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        dentistVisitService.addVisit(dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitDate(), dentistVisitDTO.getVisitTime());
        return "redirect:/results";
    }

    @ModelAttribute("dentists")
    public List<DentistEntity> getDentists() {
        return dentists;
    }

    @ModelAttribute("dentistVisitDTO")
    public DentistVisitDTO getDentistVisitDTO() {
        return dentistVisitDTO;
    }

    @ModelAttribute("times")
    public List<String> getTimes() {
        return times;
    }

    public void setDentistVisitDTO(DentistVisitDTO dentistVisitDTO) {
        this.dentistVisitDTO = dentistVisitDTO;
    }
}
