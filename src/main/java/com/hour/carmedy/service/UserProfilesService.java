package com.hour.carmedy.service;

import com.hour.carmedy.model.UserProfile;
import com.hour.carmedy.repository.UserProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

//Purpose: To serve other daters' profiles to the client/user

@Service
public class UserProfilesService {

    @Autowired
    UserProfilesRepository userProfilesRepository;

    public Page<UserProfile> getRandomProfile(){
        return null;
    }








}
