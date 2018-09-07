package com.gustavobastos.cursomc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavobastos.cursomc.domain.ItemPedido;
import com.gustavobastos.cursomc.domain.ItemPedidoPK;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

	Optional<ItemPedido> findById(ItemPedidoPK id);

}
