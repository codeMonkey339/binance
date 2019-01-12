package com.safu.safecoin.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wallet extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private float score;

    public Long getId() {
        return id;
    }

    public Wallet setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Wallet setAddress(String address) {
        this.address = address;
        return this;
    }

    public float getScore() {
        return score;
    }

    public Wallet setScore(float score) {
        this.score = score;
        return this;
    }
}
