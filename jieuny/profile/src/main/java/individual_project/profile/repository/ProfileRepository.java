package individual_project.profile.repository;

import individual_project.profile.profile.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ProfileRepository {
    void save(Profile profile);
    Optional<Profile> findByName(String name);
    List<Profile> findAll();
}
