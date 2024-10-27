package com.apirest.gitcommands.demo.DTO;

import lombok.Data;

@Data
public class CommandDTO {
    private Long id;
    private String howTo;
    private String commandLine;
    private String platform;
}
