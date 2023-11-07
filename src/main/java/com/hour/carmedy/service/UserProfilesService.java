package com.hour.carmedy.service;

import com.hour.carmedy.model.UserProfile;
import com.hour.carmedy.repository.UserProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

//Purpose: To serve other daters' profiles to the client/user

@Service
public class UserProfilesService {

    @Autowired
    UserProfilesRepository userProfilesRepository;

    public List<UserProfile> getUserProfiles(int pageSize, int pageNumber){
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Order.asc("age")));
        Page<UserProfile> userProfilePage = userProfilesRepository.findAll(pageRequest);

        return userProfilePage.getContent();


    }








}
