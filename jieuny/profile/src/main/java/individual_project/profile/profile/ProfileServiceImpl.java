package individual_project.profile.profile;

import individual_project.profile.repository.MemoryProfileRepository;
import individual_project.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService{


    private ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository){
        this.profileRepository= profileRepository;
    }

    @Override
    public void join(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public Profile findprofileByName(String name) {
        return profileRepository.findByName(name);
    }

    @Override
    public List<Profile> findMembers(){
        return profileRepository.findAll();
    }
}
