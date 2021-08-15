package individual_project.profile;

import individual_project.profile.profile.ProfileService;
import individual_project.profile.profile.ProfileServiceImpl;
import individual_project.profile.repository.MemoryProfileRepository;
import individual_project.profile.repository.ProfileRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SpringConfig {

    @Bean
    public ProfileService profileService() {
        return new ProfileServiceImpl(profileRepository());
    }
    @Bean
    public ProfileRepository profileRepository() {
        return new MemoryProfileRepository();
    }
}
