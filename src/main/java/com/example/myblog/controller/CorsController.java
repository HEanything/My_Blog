package com.example.myblog.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class CorsController {

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity handleOptions(HttpServletRequest request) {
        // 确保返回 200 OK
        return ResponseEntity.ok().build(); // 返回 200 OK
    }
}
