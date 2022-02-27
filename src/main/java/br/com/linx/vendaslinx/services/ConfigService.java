/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.linx.vendaslinx.services;

import br.com.linx.vendaslinx.models.Config;
import br.com.linx.vendaslinx.models.Item;
import br.com.linx.vendaslinx.repository.ConfigRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anderson
 */
@Service
public class ConfigService {

    @Autowired
    private ConfigRepository configRepository;

    @Autowired
    private ItemService itemService;

    public Config findConfig() {
        return configRepository.findAll().get(0);
    }

    public Optional<Config> findById(Long id) {
        return configRepository.findById(id);
    }

    public Config getOne(Long id) {
        return configRepository.getOne(id);
    }
    
    public Config update(Config config){
        
        Config configGerenciado = configRepository.getById(config.getId());
        configGerenciado.setDespesasTotais(config.getDespesasTotais());
        configGerenciado.setPcMargemLucro(config.getPcMargemLucro());
        
        return configRepository.saveAndFlush(configGerenciado);
        
    }

    public void recalcularItens(Config cfg) {

        List<Item> listaItensRecalculo = itemService.findAllInternalItens();

        if (!listaItensRecalculo.isEmpty()) {

            if (cfg.getDespesasTotais() == null) {
                cfg.setDespesasTotais(400.00);
            }

            Double valorDespesaUnitario = cfg.getDespesasTotais() / listaItensRecalculo.size();

            for (Item itemRecalc : listaItensRecalculo) {

                itemRecalc.setPrecoVendaProduto(
                        itemRecalc.getCustoCompra()
                        + valorDespesaUnitario
                );

                itemRecalc.setPrecoVendaProduto(
                        itemRecalc.getPrecoVendaProduto()
                        * (1 + (cfg.getPcMargemLucro() / 100))
                );

            }

        }

    }

}
