package github.yanvinicius;


import github.yanvinicius.domain.entity.Cliente;
import github.yanvinicius.domain.entity.Pedido;
import github.yanvinicius.domain.repository.Clientes;
import github.yanvinicius.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
   public CommandLineRunner init(@Autowired Clientes clientes, @Autowired Pedidos pedidos){

       return args -> {
           System.out.println("Salvando cliente");
            Cliente yan = new Cliente("Yan");
           Cliente joao = new Cliente("João");

           clientes.save(yan);
           clientes.save(joao);

           Pedido p = new Pedido();
           p.setCliente(joao);
           p.setDataPedido(LocalDate.now());
           p.setTotal(BigDecimal.valueOf(100));

           pedidos.save(p);
//
//           Cliente cliente = clientes.findClienteFetchPedidos(joao.getId());
//           System.out.println(cliente);
//           System.out.println(cliente.getPedidos());

           pedidos.findByCliente(yan).forEach(System.out::println);

       };
   }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
