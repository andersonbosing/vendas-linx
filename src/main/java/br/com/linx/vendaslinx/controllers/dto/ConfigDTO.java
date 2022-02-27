/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.linx.vendaslinx.controllers.dto;

import br.com.linx.vendaslinx.models.Config;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author Anderson
 */
public class ConfigDTO {
    
    @NotNull
    private Long id;
    @Min(value = 1)
    private Double despesasTotais;
    @NotNull
    @PositiveOrZero 
    private Double pcMargemLucro;
    private Date createdAt;
    private Date updatedAt;

    public ConfigDTO() {
    }
    
    public ConfigDTO(Long id, Double despesasTotais, Double pcMargemLucro, Date createdAt, Date updatedAt) {
        this.id = id;
        this.despesasTotais = despesasTotais;
        this.pcMargemLucro = pcMargemLucro;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public Long getId() {
        return id;
    }

    public Double getDespesasTotais() {
        return despesasTotais;
    }

    public Double getPcMargemLucro() {
        return pcMargemLucro;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
    
    public static ConfigDTO toDTO(Config config) {
        
        return new ConfigDTO(
                config.getId(),
                config.getDespesasTotais(),
                config.getPcMargemLucro(),
                config.getCreatedAt(),
                config.getUpdatedAt()
        );
        
    }
    
    public static Config toModel(ConfigDTO config) {
        
        return new Config(
                config.getId(),
                config.getDespesasTotais(),
                config.getPcMargemLucro(),
                config.getCreatedAt(),
                config.getUpdatedAt()
        );
        
    }
}
