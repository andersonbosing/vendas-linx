/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.linx.vendaslinx.services;

import br.com.linx.vendaslinx.controllers.dto.ItemVendaDTO;
import br.com.linx.vendaslinx.controllers.dto.VendaDTO;
import br.com.linx.vendaslinx.models.Venda;
import br.com.linx.vendaslinx.repository.ItemVendaRepository;
import br.com.linx.vendaslinx.repository.VendaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anderson
 */
@Service
public class VendaService {
    
    @Autowired
    private VendaRepository vendaRepository;
    
    @Autowired
    private ItemVendaRepository itemVendaRepository;
    
    public List<VendaDTO> findAll() {
        return VendaDTO.toDTOList(vendaRepository.findAll());
    }
    
    public Venda save(VendaDTO vendaDTO) {

        if (vendaDTO.getListaItensVenda() != null) {
            for (ItemVendaDTO itemVenda : vendaDTO.getListaItensVenda()) {
                if (itemVenda.getId() != null) {
                    itemVenda.toDTO(itemVendaRepository.saveAndFlush(itemVenda.toModel(itemVenda)));
                }
            }
        }
        
        return vendaRepository.saveAndFlush(vendaDTO.toModel(vendaDTO));

    }

    public Optional<Venda> findById(Long id) {
        return vendaRepository.findById(id);
    }
    
    public void deleteById(Long id) {
        vendaRepository.deleteById(id);
    }
    
}
