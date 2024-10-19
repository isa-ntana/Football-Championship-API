package br.com.zup.zup_championship.models;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome do time não pode ser vazio.")
    private String name;

    @ElementCollection
    @Size(max = 5, message = "Um time pode ter no máximo 5 jogadores.")
    @NotNull(message = "O nome do jogador não pode ser vazio.")
    private List<String> players;

    public Team() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }
}
