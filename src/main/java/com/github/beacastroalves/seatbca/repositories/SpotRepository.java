package com.github.beacastroalves.seatbca.repositories;

import com.github.beacastroalves.seatbca.models.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends JpaRepository<Spot, Long> {
}
