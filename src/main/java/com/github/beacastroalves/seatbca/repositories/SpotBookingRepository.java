package com.github.beacastroalves.seatbca.repositories;

import com.github.beacastroalves.seatbca.models.SpotBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotBookingRepository extends JpaRepository<SpotBooking, Long> {
}
