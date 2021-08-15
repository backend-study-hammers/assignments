package individual_project.profile.controller;

import individual_project.profile.profile.Profile;
import individual_project.profile.profile.ProfileService;
import individual_project.profile.profile.ProfileServiceImpl;
import individual_project.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProfileController {

    private ProfileServiceImpl profileService;
    @Autowired
    public ProfileController(ProfileServiceImpl profileService){
        this.profileService= profileService;
    }
    @GetMapping(value= "profiles/new")
    public String createform(){
        return "profiles/createProfileForm";
    }
    @PostMapping(value= "profiles/new")
    public String create(ProfileForm profileForm){
        Profile profile= new Profile(profileForm.getName(), profileForm.getUniversity(), profileForm.getMajor(), profileForm.getStudentId());

        profileService.join(profile);

        return "redirect:/";
    }
    @GetMapping(value = "/profiles")
    public String list (Model model){
        List<Profile> profiles= profileService.findMembers();
        model.addAttribute("profiles",profiles);
        return "profiles/profileList";
    }
}
