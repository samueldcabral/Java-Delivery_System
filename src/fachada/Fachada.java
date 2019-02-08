package fachada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import assets.JavaMail;
import assets.pdf;
import modelo.Cliente;
import modelo.Combo;
import modelo.Pedido;
import modelo.Produto;
import repositorio.Restaurante;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POO - Programação Orientada a Objetos
 * Prof. Fausto Ayres
 *
 */

public class Fachada {
	private static Restaurante restaurante = new Restaurante();
	private static int idpedido=0;
	private static int idproduto=0;


	//-----------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------
	
	public static ArrayList<Produto> listarProdutos() {
		return restaurante.getProdutos();
	}
	
	public static ArrayList<Produto> listarProdutos(String nome) {
		return restaurante.getProdutos(nome);
	}

	public static TreeMap<String, Cliente> listarClientes() {
		return restaurante.getClientes();
	}

	public static ArrayList<Pedido> listarPedidos() {
		return restaurante.getPedidos();
	}
	
	public static ArrayList<Pedido> listarPedidos(String telefone) throws Exception{
		return restaurante.getPedidos(telefone);
	}
	
	
	//-----------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------
	
	public static Produto cadastrarProduto(String nome, double preco) throws  Exception{
		idproduto++;
		Produto p = restaurante.localizarProduto(nome);
		if (p!=null)
			throw new Exception("cadastrar produto: produto ja cadastrado: " + nome);
		
		p = new Produto(idproduto, nome, preco);
		restaurante.adicionar(p);
		return p;
	}
	
	//-----------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------
	
	public static Cliente cadastrarCliente(String nome, String telefone, String email, String endereco) throws Exception{
		Cliente c = restaurante.localizarCliente(telefone);
		if(c != null)
			throw new Exception("Cliente já existe!");
		
		c =  new Cliente(nome, telefone, email, endereco);
		restaurante.adicionar(c);
		return c;
	}
	
	public static Cliente localizarCliente(String telefone) throws Exception{
		Cliente c = restaurante.localizarCliente(telefone);
		if(c != null)
			return c;
		else
			throw new Exception("Cliente nao existe!");
	}
	
	//-----------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------
	
	public static Pedido abrirPedido(String telefone) throws Exception{
		idpedido++;
		Pedido p = new Pedido(idpedido);	
		Cliente c = restaurante.localizarCliente(telefone);
		
		if(c != null && c.obterPedidoAberto() == null) {
			restaurante.adicionar(p);
			c.cadastrarPedido(p);
			p.setCliente(c);
			return p;
			
		}
		else {
			if(c.obterPedidoAberto() == null)
				 new Exception("Não pode ter mais de um pedido aberto por cliente!");
			else
				new Exception("Não pode cadastrar pedido sem cliente cadastrado!");
		}
		return null;
	}
	
	//-----------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------
	//a few modifications
	public static void adicionarProdutoPedido(String nome_cliente, String nome_produto, String nome_entregador) throws  Exception {	

		Cliente cli = restaurante.localizarClienteNome(nome_cliente);
		if(cli == null) 
			throw new Exception("inclusao no pedido - cliente nao cadastrado:" + nome_cliente);
	
		Pedido pedido = cli.obterPedidoAberto();
		if(pedido == null) 
			throw new Exception("inclusao no pedido - nao existe pedido aberto do cliente: " + nome_cliente);

		Produto produto = restaurante.localizarProduto(nome_produto);
		if(produto == null)
			throw new Exception("inclusao no pedido - produto nao cadastrado:" + nome_produto);
		pedido.setEntregador(nome_entregador);
		pedido.adicionar(produto); 
	//	produto.adicionar(pedido);
	}
	
	public static void adicionarProdutoPedido(String telefone, int idProduto) throws  Exception {	

		Cliente cli = restaurante.localizarCliente(telefone);
		if(cli == null) 
			throw new Exception("inclusao no pedido - cliente nao cadastrado: " + telefone);
	
		Pedido pedido = cli.obterPedidoAberto();
		if(pedido == null) 
			throw new Exception("inclusao no pedido - nao existe pedido aberto do cliente: " + telefone);

		Produto produto = restaurante.localizarProduto(idProduto);
		if(produto == null)
			throw new Exception("inclusao no pedido - produto nao cadastrado: " + idProduto);
		pedido.setEntregador("Entregador Padrao");
		pedido.adicionar(produto); 
	//	produto.adicionar(pedido);
	}
	
	//-----------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------

	public static void removerProdutoPedido(String nome_cliente, String nome_produto) throws Exception{
		Cliente cli = restaurante.localizarClienteNome(nome_cliente);
		if(cli == null) 
			throw new Exception("inclusao no pedido - cliente nao cadastrado:" + nome_cliente);
	
		Pedido pedido = cli.obterPedidoAberto();
		if(pedido == null) 
			throw new Exception("inclusao no pedido - nao existe pedido aberto do cliente: " + nome_cliente);

		pedido.remover(nome_produto);
	}
	
	public static void removerProdutoPedido(String telefone, int idProduto) throws Exception{
		Cliente cli = restaurante.localizarCliente(telefone);
		if(cli == null) 
			throw new Exception("inclusao no pedido - cliente nao cadastrado: " + telefone);
	
		Pedido pedido = cli.obterPedidoAberto();
		if(pedido == null) 
			throw new Exception("inclusao no pedido - nao existe pedido aberto do cliente: " + telefone);

		pedido.remover(idProduto);
	}
	//-----------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------
	
	public static Pedido consultarPedido(String telefone) throws Exception {
		Cliente c = restaurante.localizarCliente(telefone);
		if(c == null) 
			throw new Exception("inclusao no pedido - cliente nao cadastrado.");
		Pedido p = c.obterPedidoAberto();
		
		return p;
	}
	
	//-----------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------
	
	public static void cancelarPedido(String telefone) throws Exception {
		Cliente c = restaurante.localizarCliente(telefone);
		if(c == null) 
			throw new Exception("inclusao no pedido - cliente nao cadastrado.");
		Pedido p = c.obterPedidoAberto();
		if(p == null){
			throw new Exception("Nao ha pedido aberto");
		}
		c.cancelarPedido(p);
		restaurante.remover(p);
	}
	
	//-----------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------
	
	public static void fecharPedido(String telefone, String nome_entregador) throws Exception {
		Cliente c = restaurante.localizarCliente(telefone);
		if(c == null) 
			throw new Exception("inclusao no pedido - cliente nao cadastrado.");
		Pedido p = c.obterPedidoAberto();
		if(p == null){
			throw new Exception("Nao ha pedido aberto");
		}
		p.setFechado(true);
	}
	
	public static void enviarPedidoEmail(String telefone) throws Exception {
		ArrayList<Pedido> p = new ArrayList<Pedido>();
		p = Fachada.listarPedidos(telefone);
		pdf.pdfCreate(p);
		JavaMail.sendEmail(p);
	}
	
	//-----------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------
		
	public static double calcularArrecadacao(LocalDate data) {
		double valorTotal = 0;
		ArrayList<Pedido> pedidos = restaurante.getPedidos();
		
		for(Pedido p : pedidos) {
			if(p.getData().getDayOfMonth() == data.getDayOfMonth()) {
				valorTotal += p.getTotal();
			}
		}
		return valorTotal;
	}
	
	public static double calcularArrecadacao(int dia) {
		double valorTotal = 0;
		ArrayList<Pedido> pedidos = restaurante.getPedidos();
		
		for(Pedido p : pedidos) {
			if(p.getData().getDayOfMonth() == dia) {
				valorTotal += p.getTotal();
			}
		}
		return valorTotal;
	}
	
	//-----------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------
	public static Combo criarCombo(String nome, List<Integer> ids) throws Exception {
		idproduto++;
		ArrayList<Produto> prods = new ArrayList<>();
		Produto p;
		double preco = 0.0;
		
		Produto aux = restaurante.localizarProduto(nome);
		if (aux!=null)
			throw new Exception("cadastrar produto: produto ja cadastrado: " + nome);
		
		for(int i : ids) {
			p = restaurante.localizarProduto(i);
			prods.add(p);
			preco += p.getPreco();
		}
	
		Combo c = new Combo(idproduto, nome, preco, prods);
		restaurante.adicionar(c);
		return c;
		
	}
	
	//-----------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------
	public static void excluirPedido(int idPedido) throws Exception{
		Pedido p = restaurante.localizarPedido(idPedido);
		
		if(p == null) throw new Exception("Pedido nao existe!");
		
		if(!p.isFechado()) throw new Exception("Pedido não fechado");
		
		Cliente c = restaurante.localizarClienteViaPedido(p);
		
		if(c == null) throw new Exception("Pedido nao possui clientes");
		
		p.setProdutos("cancelar");
		p.setCliente("cancelar");
		c.cancelarPedido(p);
		restaurante.remover(p);
		
		
	}
	
	
	

}//class
