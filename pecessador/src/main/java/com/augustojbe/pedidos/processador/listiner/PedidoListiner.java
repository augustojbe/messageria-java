package com.augustojbe.pedidos.processador.listiner;

import com.augustojbe.pedidos.processador.entity.Pedido;
import com.augustojbe.pedidos.processador.entity.enums.Status;
import com.augustojbe.pedidos.processador.service.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class PedidoListiner {

    private final Logger logger = LoggerFactory.getLogger(PedidoListiner.class);

    @Autowired
    public PedidoService pedidoService;

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-processamento")
    public void salvarPedido(Pedido pedido){
        pedido.setStatus(Status.PROCESSADO);
        pedidoService.save(pedido);
    }
}
