package com.github.beacastroalves.seatbca.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "spot_bookings")
public class SpotBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime starAt;
    private LocalDateTime endAt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spot_id", referencedColumnName = "id")
    private Spot spot;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStarAt() {
        return starAt;
    }

    public void setStarAt(LocalDateTime starAt){
        this.starAt = starAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }
}
