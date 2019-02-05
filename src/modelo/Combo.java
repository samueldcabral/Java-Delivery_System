package modelo;

import java.util.ArrayList;

public class Combo extends Produto{
	private ArrayList<Produto> componentes = new ArrayList<Produto>();
	private double total;
	
	public Combo(int id, String nome, double preco) {
		super(id, nome, preco);
	}
	
//	public void adicionarComponente(ArrayList<Integer> ids){
//		for(Integer i : ids) {
//			
//		}
//	}
	
	public double getPreco() {
		total = 0.0;
		for(Produto p : componentes) {
			total += p.getPreco();
		}
		return total * 0.9;
	}
	
	public ArrayList<Produto> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Produto> componentes) {
		this.componentes = componentes;
	}

}
