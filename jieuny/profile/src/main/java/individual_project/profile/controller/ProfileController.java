package individual_project.profile.controller;

import individual_project.profile.profile.Profile;
import individual_project.profile.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProfileController {

    private ProfileService profileService;
    @Autowired
    public ProfileController(ProfileService profileService){
        this.profileService= profileService;
    }
    @GetMapping(value= "profiles/new")
    public String createform(){
        return "profiles/createProfileForm";
    }
    @PostMapping(value= "profiles/new")
    public String create(ProfileForm profileForm){
        //Profile profile= new Profile(profileForm.getName(), profileForm.getUniversity(), profileForm.getMajor(), profileForm.getStudentID());
        Profile profile= new Profile();
        profile.setName(profileForm.getName());
        profile.setMajor(profileForm.getMajor());
        profile.setUniversity(profileForm.getUniversity());
        profile.setStudentID(profileForm.getStudentID());
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
