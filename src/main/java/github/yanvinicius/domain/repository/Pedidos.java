package github.yanvinicius.domain.repository;

import github.yanvinicius.domain.entity.Cliente;
import github.yanvinicius.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);
}
