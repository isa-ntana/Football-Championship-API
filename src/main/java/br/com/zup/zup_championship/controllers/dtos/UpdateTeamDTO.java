package br.com.zup.zup_championship.controllers.dtos;

import java.util.List;

public class UpdateTeamDTO {
    private Long id;
    private String teamName;
    private List<String> players;

    public UpdateTeamDTO() {    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }
}
