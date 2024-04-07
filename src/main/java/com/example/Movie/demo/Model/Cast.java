package com.example.Movie.demo.Model;
import jakarta.persistence.*;

@Entity
@Table(name="Cast")
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorId;
    private String actorName;

    public Cast() {
    }

    public Cast(int actorId, String actorName) {
        this.actorId = actorId;
        this.actorName = actorName;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
    // Getters, setters, constructors, and other methods
}
