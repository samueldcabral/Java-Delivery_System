package repositorio;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

public class Restaurante {
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

   //----------------------------------------------------------------------------
	
	public void adicionar(Produto p){
		produtos.add(p);
	}
	public void remover(Produto p){
		produtos.remove(p);
	}

	public Produto localizarProduto(String nome){
		for(Produto p : produtos){
			if(p.getNome().equals(nome))
				return p;
		}
		return null;
	}

	//----------------------------------------------------------------------------
	
	public void adicionar(Cliente c){
		clientes.add(c);
	}
	public void remover(Cliente c){
		clientes.remove(c);
	}

	public Cliente localizarCliente(String nome){
		for(Cliente c : clientes){
			if(c.getNome().equals(nome))
				return c;
		}
		return null;
	}
	
	//----------------------------------------------------------------------------
	public void adicionar(Pedido p){
		pedidos.add(p);
	}
	public void remover(Pedido p){
		pedidos.remove(p);
	}

	public Pedido localizarPedido(int id){
		for(Pedido p : pedidos){
			if(p.getId()==id)
				return p;
		}
		return null;
	}
	
	//----------------------------------------------------------------------------

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public ArrayList<Pedido> getPrateleiras() {
		return pedidos;
	}
	
	public ArrayList<Cliente> getClientes(){
		return clientes;
	}

	public int getTotalProdutos(){
		return produtos.size();
	}
	public int getTotalPrateleiras(){
		return pedidos.size();
	}
	public int getTotalClientes() {
		return clientes.size();
	}



}

