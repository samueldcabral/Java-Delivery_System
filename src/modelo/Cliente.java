package modelo;
import java.util.ArrayList;

public class Cliente {
	private String telefone;
	private String nome;
	private String email;
	private String endereco;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Cliente(String nome, String telefone, String email, String endereco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}
	
	public void cadastrarPedido(Pedido p) {
		pedidos.add(p);
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [nome = " + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ ", pedidos=" + pedidos + "]";
	}
	
	
}
