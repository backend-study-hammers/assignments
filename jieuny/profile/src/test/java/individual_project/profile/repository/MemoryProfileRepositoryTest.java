package individual_project.profile.repository;

import individual_project.profile.AutoAppConfig;
import individual_project.profile.profile.Profile;
import individual_project.profile.profile.ProfileService;
import individual_project.profile.profile.ProfileServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MemoryProfileRepositoryTest {
    Profile jieun = new Profile("jieun", "Ewha", "computerscience", 2076193L);
    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AutoAppConfig.class);
    @Test
    void repositorytest(){
        ProfileRepository profileRepositoy= new MemoryProfileRepository();
        ac.getBean(ProfileRepository.class).save(jieun);
        System.out.println("jieun's profile =" + profileRepositoy.findByName("jieun"));
        ProfileService profileService= new ProfileServiceImpl();
        ProfileService profile= ac.getBean(ProfileService.class);
        profile.join(jieun);
        System.out.println(profile.findprofile("jieun"));
    }

}