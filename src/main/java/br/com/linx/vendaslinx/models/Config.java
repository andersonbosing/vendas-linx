/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.linx.vendaslinx.models;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 *
 * @author Anderson
 */
@Entity
@Table(name = "config_faturamento")
public class Config {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double despesasTotais;
    private Double pcMargemLucro;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;
    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

    public Config() {
    }
    
    public Config(Long id, Double despesasTotais, Double pcMargemLucro, Date createdAt, Date updatedAt) {
        this.id = id;
        this.despesasTotais = despesasTotais;
        this.pcMargemLucro = pcMargemLucro;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDespesasTotais() {
        return despesasTotais;
    }

    public void setDespesasTotais(Double despesasTotais) {
        this.despesasTotais = despesasTotais;
    }

    public Double getPcMargemLucro() {
        return pcMargemLucro;
    }

    public void setPcMargemLucro(Double pcMargemLucro) {
        this.pcMargemLucro = pcMargemLucro;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Config{" + "id=" + id + ", despesasTotais=" + despesasTotais + ", pcMargemLucro=" + pcMargemLucro + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Config other = (Config) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.despesasTotais, other.despesasTotais)) {
            return false;
        }
        if (!Objects.equals(this.pcMargemLucro, other.pcMargemLucro)) {
            return false;
        }
        return true;
    }
    
}
