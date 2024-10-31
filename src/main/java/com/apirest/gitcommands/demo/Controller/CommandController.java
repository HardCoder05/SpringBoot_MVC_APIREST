package com.apirest.gitcommands.demo.Controller;

import com.apirest.gitcommands.demo.DTO.CommandDTO;
import com.apirest.gitcommands.demo.Service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/commands")
public class CommandController {
    @Autowired
    private CommandService commandService;
    
    @GetMapping
    public ResponseEntity<List<CommandDTO>> getAllCommands() {
        return ResponseEntity.ok(commandService.getAllCommands());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CommandDTO> getCommandById(@PathVariable Long id) {
        return ResponseEntity.ok(commandService.getCommandById(id));
    }
    
    @PostMapping
    public ResponseEntity<CommandDTO> createCommand(@RequestBody CommandDTO commandDTO) {
        CommandDTO createdCommand = commandService.createCommand(commandDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdCommand.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdCommand);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CommandDTO> updateCommand(@PathVariable Long id, 
        @RequestBody CommandDTO commandDTO) {
        return ResponseEntity.ok(commandService.updateCommand(id, commandDTO));
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Void> partialUpdateCommand(@PathVariable Long id, 
        @RequestBody CommandDTO commandDTO) {
        commandService.partialUpdateCommand(id, commandDTO);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public String deleteCommand(@PathVariable Long id) {
        commandService.deleteCommand(id);
        return "Command with id " + id + " has been deleted";
    }


}
