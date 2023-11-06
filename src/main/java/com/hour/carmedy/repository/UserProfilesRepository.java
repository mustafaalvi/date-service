package com.hour.carmedy.repository;

import com.hour.carmedy.model.UserProfile;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserProfilesRepository extends PagingAndSortingRepository<UserProfile, Integer> {

}
