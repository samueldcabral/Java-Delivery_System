package modelo;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/

public class Produto {
		private int id;
		private String nome;
		private double preco;

		
		public Produto(int id, String nome,  double preco) {
			super();
			this.id = id;
			this.nome = nome;
			this.preco = preco;
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
		
	
}
