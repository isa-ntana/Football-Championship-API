package br.com.zup.zup_championship.controllers;

import br.com.zup.zup_championship.controllers.dtos.RegisterTeamDTO;
import br.com.zup.zup_championship.controllers.dtos.UpdateTeamDTO;
import br.com.zup.zup_championship.service.TeamService;
import br.com.zup.zup_championship.service.mapper.TeamMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/{id}")
    public ResponseEntity<?> showAllTeams(@PathVariable Long id){
        try{
            return ResponseEntity.status(200).body(teamService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTeam(@RequestBody @Valid RegisterTeamDTO teamRegisterDTO){
        teamService.saveTeam(TeamMapper.fromTeamRegisterDTO(teamRegisterDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeam(@RequestBody @Valid UpdateTeamDTO teamUpdateDTO, @PathVariable Long id){
        try{
            teamService.updateTeam(TeamMapper.fromTeamUpdateDTO(teamUpdateDTO));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long id){
        try{
            teamService.deleteTeam(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }
}