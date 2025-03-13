package com.authCheck.oAuthCheck.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/success")
    public String success(@AuthenticationPrincipal OAuth2User principal, Model model) {
        if (principal != null) {
            model.addAttribute("name", principal.getAttribute("name"));
            model.addAttribute("email", principal.getAttribute("email"));
            
            // Get the picture URL from Google OAuth
            String pictureUrl = principal.getAttribute("picture");
            logger.info("Received picture URL from Google: {}", pictureUrl);
            
            if (pictureUrl != null) {
                // Ensure the URL is using HTTPS
                pictureUrl = pictureUrl.replace("http://", "https://");
                model.addAttribute("picture", pictureUrl);
                logger.info("Processed picture URL: {}", pictureUrl);
            } else {
                logger.warn("No picture URL received from Google OAuth");
            }
        }
        return "success";
    }
} 