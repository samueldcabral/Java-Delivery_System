import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

public class Teste2 {
	
	public static void main (String[] args) {
		parte1();
		parte2();
		erros();
	}
	
	public static void parte1 () {		
		
		try {
			//CLIENTES
			//-----------------------
			Cliente joao = Fachada.cadastrarCliente("joao", "98745-0643", "joao@gmail.com",
					"Rua dos Tronos, 3");
			System.out.println("cadastrou cliente="+joao.getNome());
			Cliente maria = Fachada.cadastrarCliente("maria", "98820-0222", "maria@gmail.com",
					"Rua da Justica, 12");			
			System.out.println("cadastrou cliente="+maria.getNome());
			System.out.println(Fachada.listarClientes());
			
			//PRODUTOS
			//-----------------------
			//Mudar o nome de getDescricao para getNome, produto nao tem descri��o
			Produto pizza = Fachada.cadastrarProduto("Pizza", 30);
			System.out.println("cadastrou produto="+pizza.getNome());
			Produto sushi = Fachada.cadastrarProduto("Sushi", 40);
			System.out.println("cadastrou produto="+sushi.getNome());
			Produto cocaCola = Fachada.cadastrarProduto("Coca-cola", 10);
			System.out.println("cadastrou produto="+cocaCola.getNome());
			Produto guarana = Fachada.cadastrarProduto("Guarana", 5);	
			System.out.println("cadastrou produto="+guarana.getNome());	
			
			//COMBOS
			//-----------------------
			List<Integer> listaid = new ArrayList<>();
			listaid.add(pizza.getId());
			listaid.add(cocaCola.getId());
			Produto combo1 = Fachada.criarCombo("Combo1", listaid);	
			System.out.println("criou combo="+combo1);	
			
			listaid.clear();
			listaid.add(sushi.getId());
			listaid.add(guarana.getId());
			Produto combo2 = Fachada.criarCombo("Combo2", listaid);	
			System.out.println("criou combo="+combo2);
			System.out.println(Fachada.listarProdutos());
					
			//PEDIDOS
			//------------------
			System.out.println("\nAbrir pedidos");			
			Pedido pedido1 = Fachada.abrirPedido("98745-0643");
			System.out.println("abrir pedido = "+pedido1.getId());
			Pedido pedido2 = Fachada.abrirPedido("98820-0222");
			System.out.println("abrir pedido = "+pedido2.getId());
			
			System.out.println("\nconsultar pedido = "+ Fachada.consultarPedido("98745-0643"));
			System.out.println("\nconsultar pedido = "+ Fachada.consultarPedido("98820-0222"));
			
			System.out.println("\n adicao dos produtos ao Pedido");			
			Fachada.adicionarProdutoPedido("98745-0643", 1);
			Fachada.adicionarProdutoPedido("98745-0643", 1);
			Fachada.adicionarProdutoPedido("98745-0643", 3);			
			Fachada.adicionarProdutoPedido("98820-0222", 2);	
			Fachada.adicionarProdutoPedido("98820-0222", 4);
			System.out.println("consultar pedido = "+ Fachada.consultarPedido("98820-0222"));
			Fachada.removerProdutoPedido("98820-0222", 4);	

			System.out.println("consultar pedido = "+ Fachada.consultarPedido("98745-0643"));
			System.out.println("consultar pedido = "+ Fachada.consultarPedido("98820-0222"));
	
			System.out.println("\n Fechando pedidos");				
			Fachada.fecharPedido("98745-0643", "entregadorX");
			Fachada.fecharPedido("98820-0222", "entregadorX");
			//Fachada.enviarPedido("98745-0643", "senha");
			//Fachada.enviarPedido("98820-0222", "senha");

			System.out.println("consultar pedido ="+ Fachada.consultarPedido("98745-0643"));
			System.out.println("consultar pedido ="+ Fachada.consultarPedido("98820-0222"));
			
			System.out.println("\nAbrir novo pedido");			
			Pedido pedido3 = Fachada.abrirPedido("98745-0643");
			System.out.println("abrir pedido ="+pedido3.getId());
			System.out.println("consultar pedido ="+ Fachada.consultarPedido("98745-0643"));

			System.out.println("\nCancelar pedido:");
			Fachada.cancelarPedido("98745-0643");
			System.out.println("consultar pedido ="+ Fachada.consultarPedido("98745-0643"));
		
			
			System.out.println("\nArrecadacao diaria");
			System.out.println(Fachada.calcularArrecadacao(LocalDate.now().getDayOfMonth()));
			
					
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void parte2 () {
		System.out.println("\n\n\n\n------------------------------------------------------------");
		System.out.println("\n-------------------------------------------------------------------");
		System.out.println("Clientes cadastrados: ");
		TreeMap<String, Cliente> clientes = Fachada.listarClientes();
		if (!clientes.isEmpty())
			System.out.println(clientes);
		else
			System.out.println("Nao existem clientes cadastrados.");
		
		System.out.println("Produtos cadastrados: ");		
		ArrayList<Produto> produtos = Fachada.listarProdutos("");
		if (!produtos.isEmpty())
			System.out.println(produtos);
		else
			System.out.println("Nao existem produtos cadastrados.");			
		
		System.out.println("Filtragem de Produtos: ");		
		String filtro = "co";
		ArrayList<Produto> produtosFiltrados = Fachada.listarProdutos(filtro);
		if (!produtosFiltrados.isEmpty())
			System.out.println(produtosFiltrados);
		else
			System.out.println("Nao existe produto que contenha '" + filtro + "'em seu nome");

		System.out.println("Pedidos cadastrados: ");			
		ArrayList<Pedido> pedidos = Fachada.listarPedidos();
		if (!pedidos.isEmpty())
			System.out.println(pedidos);
		else
			System.out.println("Nao existem pedidos cadastrados.");


		System.out.println("Pedidos cadastrados de um cliente: ");			
		ArrayList<Pedido> pedidosPorCliente = null;
		try {
			pedidosPorCliente = Fachada.listarPedidos("98745-0643");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!pedidosPorCliente.isEmpty())
			System.out.println(pedidosPorCliente);
		else
			System.out.println("Nao existem pedidos deste cliente.");
		
		
		
		System.out.println("\nExcluir pedido 1");
		
//		TODO create this method
		try {
			Fachada.excluirPedido(1);
			System.out.println("SAM SAM SAM SAM SAM");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pedidos);
		
	}
	
	
	public static void erros() {
		System.out.println("\n-------ERROS--------");

		try {
			Fachada.cadastrarProduto("Guarana", 2);
			System.out.println("*************FALHA1: produto ja cadastrado"); 
		}catch (Exception e) {System.out.println("1--->"+e.getMessage());}
		try {
			Cliente c = Fachada.cadastrarCliente("98820-0222", "maria", "maria@gmail.com",
					"Rua da Justiça, 12");			
			System.out.println("*************FALHA2: cliente ja cadastrado"); 
		}catch (Exception e) {System.out.println("2--->"+e.getMessage());}
		try {
			Pedido p = Fachada.abrirPedido("98820-0000");
			System.out.println("*************FALHA3: nao pode abrir pedido de cliente inexistente"); 
		}catch (Exception e) {System.out.println("3--->"+e.getMessage());}
		try {
			Pedido p = Fachada.abrirPedido("98820-0222");	//ok
			Fachada.adicionarProdutoPedido("98820-0222",99);	
			System.out.println("*************FALHA4: nao pode adicionar produto inexistente"); 
		}catch (Exception e) {System.out.println("4--->"+e.getMessage());}
		try {
			Fachada.adicionarProdutoPedido("98820-0222",2);	//ok
			Pedido p = Fachada.abrirPedido("98820-0222");
			System.out.println("*************FALHA5: nao pode abrir pedido ja aberto"); 
		}catch (Exception e) {System.out.println("5--->"+e.getMessage());}
		try {
//			TODO create this method
//			Fachada.fecharPedido("98820-0222");	//ok
			Fachada.cancelarPedido("98820-0222");
			System.out.println("*************FALHA6: nao pode cancelar pedido fechado"); 
		}catch (Exception e) {System.out.println("6--->"+e.getMessage());}
	}

}