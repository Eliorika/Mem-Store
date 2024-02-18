package dev.chipichapa.memestore.repository;

import dev.chipichapa.memestore.domain.user.Role;
import dev.chipichapa.memestore.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
