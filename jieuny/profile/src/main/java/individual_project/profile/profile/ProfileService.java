package individual_project.profile.profile;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    void join(Profile profile);
    Profile findprofileByName(String name);
    List<Profile> findMembers();
}
