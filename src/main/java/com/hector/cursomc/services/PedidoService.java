package com.hector.cursomc.services;


import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hector.cursomc.domain.ItemPedido;
import com.hector.cursomc.domain.PagamentoComBoleto;
import com.hector.cursomc.domain.Pedido;
import com.hector.cursomc.domain.enums.EstadoPagamento;
import com.hector.cursomc.repositories.ItemPedidoRepository;
import com.hector.cursomc.repositories.PagamentoRepository;
import com.hector.cursomc.repositories.PedidoRepository;
import com.hector.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	public Pedido find(Integer id) {		
		Pedido obj = repo.findOne(id);		
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto no encontrado! Id: " + id
					+ ", Tipo: " + Pedido.class.getName());
		}
		return obj;
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());		
		obj.getPagamento().setEstado(EstadoPagamento.PENDENDE);		
		obj.getPagamento().setPedido(obj);		
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip: obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());					
			ip.setPedido(obj);
		}		
		itemPedidoRepository.save(obj.getItens());
		return obj;
	}
}