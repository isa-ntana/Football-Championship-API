package br.com.zup.zup_championship.controllers.dtos;

import java.util.List;

public class RegisterTeamDTO {
    private String teamName;
    private List<String> players;

    public RegisterTeamDTO() {}

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
