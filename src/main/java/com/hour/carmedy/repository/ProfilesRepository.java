package com.hour.carmedy.repository;

import com.hour.carmedy.model.Profile;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfilesRepository extends PagingAndSortingRepository<Profile, Integer> {

}
