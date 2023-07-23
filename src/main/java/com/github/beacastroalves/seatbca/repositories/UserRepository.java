package com.github.beacastroalves.seatbca.repositories;

import com.github.beacastroalves.seatbca.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
