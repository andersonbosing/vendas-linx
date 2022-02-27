/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.linx.vendaslinx.models;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 *
 * @author Anderson
 */
@Entity
@Table(name = "vendas")
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;
    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;
    @OneToMany(cascade=CascadeType.PERSIST)
    private List<ItemVenda> listaItensVenda;

    public Venda() {
    }
    
    public Venda(Long id, Date createdAt, Date updatedAt, List<ItemVenda> listaItensVenda) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.listaItensVenda = listaItensVenda;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<ItemVenda> getListaItensVenda() {
        return listaItensVenda;
    }
     
}
