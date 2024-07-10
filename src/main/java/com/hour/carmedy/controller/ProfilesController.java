package com.hour.carmedy.controller;

import com.hour.carmedy.model.Profile;
import com.hour.carmedy.service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfilesController {

    @Autowired
    ProfilesService profilesService;

    @GetMapping
    public List<Profile> getProfiles(
            @RequestParam("pageSize") int pageSize,
            @RequestParam("pageNumber") int pageNumber){

        return profilesService.getProfiles(pageSize, pageNumber);
    }
}
