package com.pathfinder.restfull.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class I18Controller{

    @Autowired
    MessageSource messageSource;

    @GetMapping("/message/i18")
    public String getI18Message(){
        final Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null ,locale);
    }
}
