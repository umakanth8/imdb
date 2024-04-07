package com.example.Movie.demo.Model;
import jakarta.persistence.*;

@Entity
@Table(name="Gross")
public class Gross {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int grossId;
    private long gross;
    private long budget;

    public Gross() {
    }

    public Gross(int grossId, long gross, long budget) {
        this.grossId = grossId;
        this.gross = gross;
        this.budget = budget;
    }

    public int getGrossId() {
        return grossId;
    }

    public void setGrossId(int grossId) {
        this.grossId = grossId;
    }

    public long getGross() {
        return gross;
    }

    public void setGross(long gross) {
        this.gross = gross;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }
    // Getters, setters, constructors, and other methods
}
