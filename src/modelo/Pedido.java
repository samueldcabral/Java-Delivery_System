package modelo;
import java.time.LocalDateTime;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/
import java.util.ArrayList;


public class Pedido {
	private int id;
	private LocalDateTime data = LocalDateTime.now();
	private double total;
	private String entregador;
	private boolean fechado;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private Cliente cliente;
	
	public Pedido(int id) {
		super();
		this.id = id;
	}
	
	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public void adicionar(Produto p){
		produtos.add(p);
	}
	
	public void remover(Produto p){
		produtos.remove(p);
	}
	
	public void remover(String nome_produto) {
		int index=0;
		for(Produto p : produtos) {
			if(p.getNome() == nome_produto) {
				System.out.println("if");
				index = p.getId();
			}
		}
		produtos.remove(index);
	}

	public Produto localizar(String nome){
		for(Produto p : produtos){
			if(p.getNome().equals(nome))
				return p;
		}
		return null;
	}
	

	public int getTotalProdutos(){
		return produtos.size();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	

	public double getTotal() {
		for(Produto p : produtos) {
			total += p.getPreco();
		}
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getEntregador() {
		return entregador;
	}

	public void setEntregador(String entregador) {
		this.entregador = entregador;
	}

	public boolean isFechado() {
		return fechado;
	}

	public void setFechado(boolean fechado) {
		this.fechado = fechado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Cliente getCliente(Cliente c) {
		if(cliente == c)
			return cliente;
		else
			return null;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		String texto = "Pedido [id=" + id  ;
		texto += ", produtos:";
		if (produtos.isEmpty())
			texto += " vazia";
		else 	
			for(Produto p: produtos) 
				texto += " - " + p.getNome() ;
		texto += ", Status:";
		if(fechado)
			texto += "Fechado";
		else
			texto += "Aberto";
		return texto + "]";
	}


}
	


