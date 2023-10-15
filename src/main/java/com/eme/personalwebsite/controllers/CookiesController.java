package com.eme.personalwebsite.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookiesController {

    @GetMapping("/en")
    public void setEnglishCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("lang", "en");
        response.addCookie(cookie);
    }

    @GetMapping("/es")
    public void setSpanishCookies(HttpServletResponse response) {
        Cookie deleteServletCookie = new Cookie("lang", null);
        deleteServletCookie.setMaxAge(0);

        response.addCookie(deleteServletCookie);
    }

    @GetMapping("/darkmode")
    public void setDarkmodeCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("theme", "dark");
        response.addCookie(cookie);
    }

    @GetMapping("/lightmode")
    public void setLightmodeCookies(HttpServletResponse response) {
        Cookie deleteServletCookie = new Cookie("theme", null);
        deleteServletCookie.setMaxAge(0);

        response.addCookie(deleteServletCookie);
    }

}
