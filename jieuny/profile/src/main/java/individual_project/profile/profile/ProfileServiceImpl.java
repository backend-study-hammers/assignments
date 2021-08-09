package individual_project.profile.profile;

import individual_project.profile.repository.MemoryProfileRepository;
import individual_project.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private static ProfileRepository profileRepository= new MemoryProfileRepository();

    @Override
    public void join(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public Profile findprofile(String name) {
        return profileRepository.findByName(name);
    }
}
