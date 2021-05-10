package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistEntity;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.service.interfaces.DentistService;
import com.cgi.dentistapp.service.interfaces.DentistVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    private List<DentistVisitEntity> dentistVisits;

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

    @GetMapping("/visits")
    public String showAllRegisteredVisits(Model model) {
        dentistVisits = dentistVisitService.getAllVisits();
        model.addAttribute("dentistVisits", getDentistVisits());
        return "visits";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        DentistVisitEntity dentistVisitEntity = dentistVisitService.getVisitByID(id);

        model.addAttribute("dentistVisitChange", dentistVisitEntity);
        return "changes";
    }

    @PostMapping("/update/{id}")
    public String updateVisit(@PathVariable("id") long id, @Valid DentistVisitDTO dentistVisitDTO,
                              BindingResult result, Model model) {
        dentistVisitService.updateVisit(id, dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitDate(), dentistVisitDTO.getVisitTime());
        return "redirect:/visits";
    }

    @GetMapping("/delete/{id}")
    public String deleteVisit(@PathVariable("id") long id, Model model) {
        DentistVisitEntity dentistVisitEntity = dentistVisitService.getVisitByID(id);
        dentistVisitService.deleteVisit(dentistVisitEntity);
        return "redirect:/visits";
    }

    @PostMapping("/")
    public String postRegisterForm(@Valid DentistVisitDTO dentistVisitDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        if (dentistVisitService.getVisitByNameAndDateAndTime(dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitDate(), dentistVisitDTO.getVisitTime()) != null) {
            ObjectError error = new ObjectError("error", "See aeg on juba broneeritud!");
            bindingResult.addError(error);
        }
        if (bindingResult.hasErrors()) {
            return "form";
        }
        else {
            dentistVisitService.addVisit(dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitDate(), dentistVisitDTO.getVisitTime());
            return "redirect:/results";
        }
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

    public List<DentistVisitEntity> getDentistVisits() {
        return dentistVisits;
    }

    public void setDentistVisitDTO(DentistVisitDTO dentistVisitDTO) {
        this.dentistVisitDTO = dentistVisitDTO;
    }
}
