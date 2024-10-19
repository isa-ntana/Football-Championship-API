package br.com.zup.zup_championship.service.mapper;

import br.com.zup.zup_championship.controllers.dtos.RegisterTeamDTO;
import br.com.zup.zup_championship.controllers.dtos.UpdateTeamDTO;
import br.com.zup.zup_championship.models.Team;

public class TeamMapper {
    public static Team fromTeamRegisterDTO(RegisterTeamDTO registerTeamDTO){
        Team team = new Team();
        team.setName(registerTeamDTO.getTeamName());
        team.setPlayers(registerTeamDTO.getPlayers());

        return team;
    }

    public static Team fromTeamUpdateDTO(UpdateTeamDTO updateTeamDTO){
        Team team = new Team();
        team.setId(updateTeamDTO.getId());
        team.setName(updateTeamDTO.getTeamName());
        team.setPlayers(updateTeamDTO.getPlayers());

        return team;
    }
}
