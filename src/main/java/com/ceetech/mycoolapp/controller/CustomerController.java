package com.ceetech.mycoolapp.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ceetech.mycoolapp.entity.Customer;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class CustomerController {

    //add initbinder  to convert tri input string
    //remove leading and trailing white space
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("validation")
    public String showForm(Model model) {

        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("processform")
    public String processForm(@Valid @ModelAttribute("customer") Customer thCustomer, BindingResult bindingResult) {

//        Checking specific errors - change message in the properties package
        System.out.println("Data binding errors:::::::: " + bindingResult.toString());

        System.out.println("\n\n\n\n");

        if (bindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }

    }

}
