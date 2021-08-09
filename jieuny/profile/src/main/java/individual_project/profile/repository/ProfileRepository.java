package individual_project.profile.repository;

import individual_project.profile.profile.Profile;

public interface ProfileRepository {
    void save(Profile profile);
    Profile findByName(String name);
}
