/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.linx.vendaslinx.repository;

import br.com.linx.vendaslinx.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anderson
 */
@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{
    
}
