package com.hector.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hector.cursomc.domain.Categoria;
import com.hector.cursomc.domain.Cidade;
import com.hector.cursomc.domain.Cliente;
import com.hector.cursomc.domain.Endereco;
import com.hector.cursomc.domain.Estado;
import com.hector.cursomc.domain.ItemPedido;
import com.hector.cursomc.domain.Pagamento;
import com.hector.cursomc.domain.PagamentoComBoleto;
import com.hector.cursomc.domain.PagamentoComCartao;
import com.hector.cursomc.domain.Pedido;
import com.hector.cursomc.domain.Produto;
import com.hector.cursomc.domain.enums.EstadoPagamento;
import com.hector.cursomc.domain.enums.TipoCliente;
import com.hector.cursomc.repositories.CategoriaRepository;
import com.hector.cursomc.repositories.CidadeRepository;
import com.hector.cursomc.repositories.ClienteRepository;
import com.hector.cursomc.repositories.EnderecoRepository;
import com.hector.cursomc.repositories.EstadoRepository;
import com.hector.cursomc.repositories.ItemPedidoRepository;
import com.hector.cursomc.repositories.PagamentoRepository;
import com.hector.cursomc.repositories.PedidoRepository;
import com.hector.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}
