package modelo;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/

public class Produto implements Comparable<Produto>{
		private int id;
		private String nome;
		private double preco;

		
		public Produto(int id, String nome,  double preco) {
			super();
			this.id = id;
			this.nome = nome;
			this.preco = preco;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public double getPreco() {
			return preco;
		}
		
		public void setPreco(double preco) {
			this.preco = preco;
		}		
		
		//---------------------------------------
		@Override
		public String toString() {
			return "Produto [" + (nome != null ? "nome=" + nome + ", " : "")
					+ "preco=" + preco + ", "
					+ "]";
		}

		@Override
		public int compareTo(Produto outro) {
			return this.getNome().compareTo(outro.getNome());
		}
		
	
}
