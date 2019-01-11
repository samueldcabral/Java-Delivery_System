package aplicacao_console;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/


import java.util.ArrayList;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

public class Teste1 {
	public Teste1() throws Exception {
		cadastrar();
		listar();
	}

	public void cadastrar(){
		try {	
			Produto produto;
			Pedido pedido;
			Cliente cliente;
			
			produto = Fachada.cadastrarProduto("Sushi Salmao", 19.5);
			System.out.println("Produto Cadastrado: "+ produto.getNome());
			
			produto = Fachada.cadastrarProduto("Sushi Camarão", 20.5);
			produto = Fachada.cadastrarProduto("Sushi Kani", 19.0);
			produto = Fachada.cadastrarProduto("Temaki Salmao", 20.0);
			produto = Fachada.cadastrarProduto("Temaki Camarão", 21.0);
			
			cliente = Fachada.cadastrarCliente("Samuel", "9999-1234", "samuel@samuel.com", "Rua da Lua");
			System.out.println("Cliente Cadastrado: "+ cliente.getNome());
			
			cliente = Fachada.cadastrarCliente("Denise", "9999-4321", "denise@denise.com", "Rua da Alegria");
			cliente = Fachada.cadastrarCliente("Marcio", "9991-1234", "marcio@marcio.com", "Avenida Ferreira");
			cliente = Fachada.cadastrarCliente("Ana", "9991-4321", "ana@ana.com", "Avenida Poisson");

			pedido = Fachada.abrirPedido("9999-1234");
			System.out.println("Pedido Cadastrado para 1234: "+ pedido.getId());
			Fachada.fecharPedido("9999-1234", "Joao");
			pedido = Fachada.abrirPedido("9999-1234");
			System.out.println("Pedido Cadastrado para 1234: "+ pedido.getId());
			pedido = Fachada.abrirPedido("9991-1234");
			System.out.println("Pedido Cadastrado: "+ pedido.getId());

			pedido = Fachada.abrirPedido("9999-4321");	
			System.out.println("Pedido Cadastrado: "+ pedido.getId());

			Fachada.adicionarProdutoPedido("Samuel", "Sushi Salmao", "Joao");
			Fachada.adicionarProdutoPedido("Samuel", "Sushi Camarão", "Pedro");
			Fachada.adicionarProdutoPedido("Samuel", "Sushi Camarão", "Pedro");
			Fachada.adicionarProdutoPedido("Samuel", "Temaki Camarão", "Jane");
			
			Fachada.adicionarProdutoPedido("Denise", "Sushi Salmao", "Joao");
			Fachada.adicionarProdutoPedido("Marcio", "Sushi Camarão", "Pedro");
			
			//Remove
			Fachada.removerProdutoPedido("Samuel", "Sushi Camarão");
			
			System.out.println("\nCadastro Concluido\n");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public void listar() throws Exception{
		String texto;
		ArrayList<Produto> lista1 = Fachada.listarProdutos();
		texto = "\nListagem de produtos: \n\n";
		if (lista1.isEmpty())
			texto += "não tem produto cadastrado\n";
		else 	
			for(Produto p: lista1) 
				texto +=  p + "\n"; 
		System.out.println(texto);


		ArrayList<Pedido> lista2 = Fachada.listarPedidos();
		texto = "\nListagem de pedidos: \n\n";
		if (lista2.isEmpty())
			texto += "não tem pedido cadastrado\n";
		else 
			for(Pedido p: lista2) 
				texto +=  p + "\n"; 
		System.out.println(texto);
		
		ArrayList<Cliente> lista3 = Fachada.listarClientes();
		texto = "\nListagem de Clientes: \n\n";
		if(lista3.isEmpty())
			texto += "não tem cliente cadastrado\n";
		else
			for(Cliente c : lista3)
				texto += c + "\n";
		System.out.println(texto);
		
		ArrayList<Pedido> lista4 = Fachada.listarPedidos("9999-1234");
		texto = "\nListagem de Pedido por Cliente: \n\n";
		if(lista4.isEmpty())
			texto += "não tem Pedido cadastrado\n";
		else
			for(Pedido p : lista4)
				texto += p + "\n";
		System.out.println(texto);
				
	}




	//  ***********************************************
	public static void main (String[] args)   
	//  ***********************************************
	{
		try {
			new Teste1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
