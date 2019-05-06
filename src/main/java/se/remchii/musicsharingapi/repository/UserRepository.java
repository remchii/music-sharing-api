package se.remchii.musicsharingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.remchii.musicsharingapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
