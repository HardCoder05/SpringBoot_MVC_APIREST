package com.apirest.gitcommands.demo.Repository;

import com.apirest.gitcommands.demo.Model.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command, Long> {

}
