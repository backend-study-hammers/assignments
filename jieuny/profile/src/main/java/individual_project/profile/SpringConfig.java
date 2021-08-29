package individual_project.profile;

import individual_project.profile.profile.ProfileService;
import individual_project.profile.profile.ProfileServiceImpl;
import individual_project.profile.repository.JpaProfileRepository;
import individual_project.profile.repository.MemoryProfileRepository;
import individual_project.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;


@Configuration
public class SpringConfig {
    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    @Bean
    public ProfileService profileService() {
        return new ProfileServiceImpl(profileRepository());
    }
    @Bean
    public ProfileRepository profileRepository() {
        return new JpaProfileRepository(em);
    }
}
