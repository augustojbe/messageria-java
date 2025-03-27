package br.com.augustojbe.pedidos.notificacao.listener;

import br.com.augustojbe.pedidos.notificacao.entity.Pedido;
import br.com.augustojbe.pedidos.notificacao.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoListiner {

    private final Logger logger = LoggerFactory.getLogger(PedidoListiner.class);

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    public void enviarNotificacao(Pedido pedido){

        if (pedido.getValorTotal() > 2000){
            throw new RuntimeException("Valor muito alto");
        }

        emailService.enviarEmail(pedido);
        logger.info("Notificação gerada{} ", pedido.toString());
    }

}
