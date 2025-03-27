package com.augustojbe.pedidos.processador.service;

import com.augustojbe.pedidos.processador.entity.ItemPedido;
import com.augustojbe.pedidos.processador.entity.Pedido;
import com.augustojbe.pedidos.processador.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> save(List<ItemPedido> itens) {
        return itemPedidoRepository.saveAll(itens);
    }


    public void save(ItemPedido item){
        itemPedidoRepository.save(item);
    }

    public void updateItemPedido(List<ItemPedido> itemPedidos, Pedido pedido) {

        itemPedidos.forEach(item -> {
            item.setPedido(pedido); // informando ao item o seu pedido.
            this.save(item);
        });
    }
}
