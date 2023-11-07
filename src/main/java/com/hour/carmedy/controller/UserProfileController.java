package com.hour.carmedy.controller;

import com.hour.carmedy.model.UserProfile;
import com.hour.carmedy.service.UserProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userProfiles")
public class UserProfileController {

    @Autowired
    UserProfilesService userProfilesService;

    @GetMapping
    public List<UserProfile> getUserProfiles(
            @RequestParam("pageSize") int pageSize,
            @RequestParam("pageNumber") int pageNumber){

        return userProfilesService.getUserProfiles(pageSize, pageNumber);
    }
}
