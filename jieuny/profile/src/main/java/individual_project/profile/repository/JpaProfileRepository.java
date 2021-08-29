package individual_project.profile.repository;

import individual_project.profile.profile.Profile;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaProfileRepository implements ProfileRepository{
    private EntityManager em;
    @Autowired
    public JpaProfileRepository(EntityManager em) {
        this.em = em;
    }
    @Override
    public void save(Profile profile) {
        em.persist(profile);
    }
    @Override
    public Profile findByName(String name) {
        Profile profile= em.find(Profile.class, name);
        return profile;
//return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Profile> findAll() {
        return em.createQuery("select p from Profile p", Profile.class).getResultList();
    }
}
