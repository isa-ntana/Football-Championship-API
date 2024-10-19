package br.com.zup.zup_championship.service;

import br.com.zup.zup_championship.models.Team;
import br.com.zup.zup_championship.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Team findById(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        return team.orElseThrow(() -> new RuntimeException("Team not found"));
    }

    public Team saveTeam(Team team) { return teamRepository.save(team); }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    public Team updateTeam(Team team) {
        Team updatedTeam = findById(team.getId());

        if (!updatedTeam.getName().equals(team.getName())) {
            updatedTeam.setName(team.getName());
        }

        if(!updatedTeam.getPlayers().equals(team.getPlayers())) {
            updatedTeam.setPlayers(team.getPlayers());
        }

        return saveTeam(updatedTeam);
    }
}
