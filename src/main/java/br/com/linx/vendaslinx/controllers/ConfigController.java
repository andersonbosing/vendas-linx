/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.linx.vendaslinx.controllers;

import br.com.linx.vendaslinx.controllers.dto.ConfigDTO;
import br.com.linx.vendaslinx.models.Config;
import br.com.linx.vendaslinx.services.ConfigService;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Anderson
 */
@RestController
@RequestMapping("/configs")
public class ConfigController {

    @Autowired
    private ConfigService configService;
    
    @GetMapping
    public ConfigDTO find() {
        return ConfigDTO.toDTO(configService.findConfig());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ConfigDTO> atualizar(@PathVariable Long id,
            @RequestBody @Valid ConfigDTO config) {

        Optional<Config> optional = configService.findById(id);
        if (optional.isPresent()) {
            Config cfg = configService.update(config.toModel(config));
            
            if (!config.equals(ConfigDTO.toDTO(cfg)))
                configService.recalcularItens(cfg);
            
            return ResponseEntity.ok(ConfigDTO.toDTO(cfg));
        }

        return ResponseEntity.notFound().build();

    }

}