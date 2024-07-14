package service;

import com.hour.carmedy.model.Profile;
import com.hour.carmedy.repository.ProfilesRepository;
import com.hour.carmedy.service.ProfilesService;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

//alternatively use:
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ProfilesService.class)

@RunWith(MockitoJUnitRunner.class)
public class ProfilesServiceTest {

    @InjectMocks //alternatively use: @Autowired
    ProfilesService profileService;

    @Mock //alternatively use: @MockBean
    ProfilesRepository profilesRepository;


    @Test
    public void getProfilesTest(){
        Mockito.when(profilesRepository.findAll(Mockito.any(PageRequest.class))).thenReturn(createDummyProfile());

        List<Profile> result = profileService.getProfiles(1,1);
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());

        Profile actualProfile = result.get(0);

        Assert.assertEquals(new ObjectId("60c72b2f9b1e8a5e5a2b3c4d"), actualProfile.getId());
        Assert.assertEquals("Boob", actualProfile.getName());
        Assert.assertEquals(25, actualProfile.getAge());
    }

    public Page<Profile> createDummyProfile(){
        Profile profile = new Profile();
        profile.setId(new ObjectId("60c72b2f9b1e8a5e5a2b3c4d"));
        profile.setName("Boob");
        profile.setAge(25);

        ArrayList<Profile> list = new ArrayList<>();
        list.add(profile);

        return new PageImpl<>(list);
    }

}
