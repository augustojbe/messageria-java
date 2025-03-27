package com.augustojbe.pedidos.processador.service;

import com.augustojbe.pedidos.processador.entity.ItemPedido;
import com.augustojbe.pedidos.processador.entity.Pedido;
import com.augustojbe.pedidos.processador.repository.ItemPedidoRepository;
import com.augustojbe.pedidos.processador.repository.PedidoRepository;
import com.augustojbe.pedidos.processador.repository.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoService itemPedidoService;


    public void save(Pedido pedido){

        // salvamos os produtos
        produtoService.save(pedido.getItens());

        // salvamos os itens do pedido
        List<ItemPedido> itemPedidos = itemPedidoService.save(pedido.getItens());

        // salvamos o pedido
        pedidoRepository.save(pedido);

        // atualiza o item pedidos definindo o pedido ao qual ele faz parte
        itemPedidoService.updateItemPedido(itemPedidos, pedido);

        logger.info("Pedido salvo: {}", pedido.toString());
    }





}
