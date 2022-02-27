/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.linx.vendaslinx.repository;

import br.com.linx.vendaslinx.models.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anderson
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

    @Query("select i from Item i where i.custoCompra is not null")
    public List<Item> findAllVenda();
    
}
