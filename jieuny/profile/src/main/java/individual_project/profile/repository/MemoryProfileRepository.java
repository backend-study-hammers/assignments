package individual_project.profile.repository;

import individual_project.profile.profile.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryProfileRepository implements ProfileRepository {
    public static Map<String, Profile> store=new HashMap<>();

    @Override
    public void save(Profile profile) {
        store.put(profile.getName(), profile);
    }

    @Override
    public Profile findByName(String name) {
        return store.get(name);
    }
}
