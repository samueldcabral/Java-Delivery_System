package modelo;

import java.util.ArrayList;

public class Combo extends Produto{
	private ArrayList<Produto> componentes = new ArrayList<Produto>();
	private double total;
	private String nomeCombo;
	private final double desconto = 0.9;
	
	public Combo(int id, String nome, double preco, ArrayList<Produto> prods) {
		super(id, nome, preco);
		this.setNomeCombo(nome);
		this.setComponentes(prods);
	}
	
	public double getPreco() {
		total = 0.0;
		for(Produto p : componentes) {
			total += p.getPreco();
		}
		return total * desconto;
	}
	
	@Override
	public String toString() {
		return "Combo [nomeCombo =" + nomeCombo +", Componentes = " + componentes + ", total com desconto = " + this.getPreco() + ", valor desconto = " + desconto*100 + "% ]";
	}

	public ArrayList<Produto> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Produto> componentes) {
		this.componentes = componentes;
	}

	public String getNomeCombo() {
		return nomeCombo;
	}

	public void setNomeCombo(String nomeCombo) {
		this.nomeCombo = nomeCombo;
	}

}
