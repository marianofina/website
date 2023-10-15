package com.eme.personalwebsite.controllers;

import com.eme.personalwebsite.helpers.LoaderHelper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/data")
public class DataController {

    private final JSONObject data_object_es;
    private final JSONObject data_object_en;

    private DataController () {
        LoaderHelper arc_es = new LoaderHelper("data-es.json");
        LoaderHelper arc_en = new LoaderHelper("data-en.json");

        this.data_object_es = arc_es.getData();
        this.data_object_en = arc_en.getData();

    }

    private String langCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("lang")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    private String obtenerData(String lang, String section) {
        if(lang == null) {
            return data_object_es != null ? data_object_es.get(section).toString() : null;
        } else {
            return data_object_en != null ? data_object_en.get(section).toString() : null;
        }
    }

    @GetMapping("/about")
    public ResponseEntity<String> about(HttpServletRequest request) {
        String lang = langCookie(request);
        String data = obtenerData(lang, "about");

        return new ResponseEntity<>(data, data != null ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/education")
    public ResponseEntity<String> education(HttpServletRequest request) {
        String lang = langCookie(request);
        String data = obtenerData(lang, "education");

        return new ResponseEntity<>(data, data != null ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/experience")
    public ResponseEntity<String> experience(HttpServletRequest request) {
        String lang = langCookie(request);
        String data = obtenerData(lang, "experience");

        return new ResponseEntity<>(data, data != null ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/projects")
    public ResponseEntity<String> projects(HttpServletRequest request) {
        String lang = langCookie(request);
        String data = obtenerData(lang, "projects");

        return new ResponseEntity<>(data, data != null ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/skills")
    public ResponseEntity<String> skills(HttpServletRequest request) {
    String lang = langCookie(request);
    String data = obtenerData(lang, "skills");

        return new ResponseEntity<>(data, data != null ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/contact")
    public ResponseEntity<String> contact(HttpServletRequest request) {
        String lang = langCookie(request);
        String data = obtenerData(lang, "contact");

        return new ResponseEntity<>(data, data != null ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/operation")
    public ResponseEntity<String> operation(HttpServletRequest request) {
        String lang = langCookie(request);
        String data = obtenerData(lang, "operation");

        return new ResponseEntity<>(data, data != null ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
