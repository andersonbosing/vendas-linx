/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.linx.vendaslinx.controllers.dto;

import br.com.linx.vendaslinx.models.Venda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Anderson
 */
public class VendaDTO {

    private Long id;
    private Date createdAt;
    private Date updatedAt;
    @NotNull @NotEmpty
    private List<ItemVendaDTO> listaItensVenda;

    public VendaDTO() {
    }

    public VendaDTO(Long id, Date createdAt, Date updatedAt, List<ItemVendaDTO> listaItensVenda) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.listaItensVenda = listaItensVenda;
    }
    
    public Long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public List<ItemVendaDTO> getListaItensVenda() {
        return listaItensVenda;
    }
    
    public static VendaDTO toDTO(Venda venda) {
        
        return new VendaDTO(
                venda.getId(),
                venda.getCreatedAt(),
                venda.getUpdatedAt(),
                ItemVendaDTO.toDTOList(venda.getListaItensVenda())
        );
        
    }
  
    public static Venda toModel(VendaDTO venda) {
        
        return new Venda(
                venda.getId(),
                venda.getCreatedAt(),
                venda.getUpdatedAt(),
                ItemVendaDTO.toModelList(venda.getListaItensVenda())
        );
        
    }
    
    public static List<VendaDTO> toDTOList(List<Venda> listaVendas) {
    
        List<VendaDTO> resultList = new ArrayList<>();

        for (Venda venda : listaVendas) {
            resultList.add(toDTO(venda));
        }
        
        return resultList;
    
    }
    
    
}
