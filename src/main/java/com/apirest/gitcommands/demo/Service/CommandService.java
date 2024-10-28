package com.apirest.gitcommands.demo.Service;

import com.apirest.gitcommands.demo.DTO.CommandDTO;
import com.apirest.gitcommands.demo.Model.Command;
import com.apirest.gitcommands.demo.Repository.CommandRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandService {
    @Autowired
    private CommandRepository commandRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    public List<CommandDTO> getAllCommands() {
        return commandRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public CommandDTO getCommandById(Long id) {
        Command command = commandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Command not found"));
        return convertToDTO(command);
    }
    
    public CommandDTO createCommand(CommandDTO commandDTO) {
        Command command = convertToEntity(commandDTO);
        Command savedCommand = commandRepository.save(command);
        return convertToDTO(savedCommand);
    }
    
    public CommandDTO updateCommand(Long id, CommandDTO commandDTO) {
        Command command = commandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Command not found"));
        
        command.setHowTo(commandDTO.getHowTo());
        command.setCommandLine(commandDTO.getCommandLine());
        command.setPlatform(commandDTO.getPlatform());
        
        Command updatedCommand = commandRepository.save(command);
        return convertToDTO(updatedCommand);
    }

    public CommandDTO partialUpdateCommand(Long id, CommandDTO commandDTO) {
        Command command = commandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Command not found"));
        
        if (commandDTO.getHowTo() != null) {
            command.setHowTo(commandDTO.getHowTo());
        }
        if (commandDTO.getCommandLine() != null) {
            command.setCommandLine(commandDTO.getCommandLine());
        }
        if (commandDTO.getPlatform() != null) {
            command.setPlatform(commandDTO.getPlatform());
        }
        
        Command updatedCommand = commandRepository.save(command);
        return convertToDTO(updatedCommand);
    }
    
    public void deleteCommand(Long id) {
        commandRepository.deleteById(id);
    }
    
    private CommandDTO convertToDTO(Command command) {
        return modelMapper.map(command, CommandDTO.class);
    }
    
    private Command convertToEntity(CommandDTO commandDTO) {
        return modelMapper.map(commandDTO, Command.class);
    }
}
