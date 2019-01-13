import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.itextpdf.awt.geom.AffineTransform;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;

public class DeliveryApp {

	private JFrame frame;
	private JTextField txtFefe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliveryApp window = new DeliveryApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeliveryApp() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		Produto produto;
		Pedido pedido;
		Cliente cliente;
		
		
		frame = new JFrame();
		frame.setBounds(300, 100, 1238, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBackground(new Color(119, 136, 153));
		panel_menu.setBounds(0, 0, 289, 688);
		frame.getContentPane().add(panel_menu);
		panel_menu.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setForeground(new Color(255, 255, 255));
		lblMenu.setFont(new Font("Ubuntu Mono", Font.BOLD, 66));
		lblMenu.setBounds(12, 13, 265, 76);
		panel_menu.add(lblMenu);
		
		JButton btnPedidos = new JButton("Pedidos");
		btnPedidos.setForeground(new Color(255, 255, 255));
		btnPedidos.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnPedidos.setBounds(54, 148, 192, 65);
		btnPedidos.setFocusPainted(false);
		btnPedidos.setContentAreaFilled(false);
		panel_menu.add(btnPedidos);
		
		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.setForeground(Color.WHITE);
		btnProdutos.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnProdutos.setFocusPainted(false);
		btnProdutos.setContentAreaFilled(false);
		btnProdutos.setBounds(54, 210, 192, 65);
		panel_menu.add(btnProdutos);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setForeground(Color.WHITE);
		btnClientes.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnClientes.setFocusPainted(false);
		btnClientes.setContentAreaFilled(false);
		btnClientes.setBounds(54, 266, 192, 65);
		panel_menu.add(btnClientes);
		
		JButton btnArrecadacao = new JButton("Arrecada\u00E7\u00E3o");
		btnArrecadacao.setForeground(Color.WHITE);
		btnArrecadacao.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnArrecadacao.setFocusPainted(false);
		btnArrecadacao.setContentAreaFilled(false);
		btnArrecadacao.setBounds(29, 329, 248, 65);
		panel_menu.add(btnArrecadacao);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 128, 128));
		panel.setBounds(289, 0, 931, 688);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		final JPanel panel_default = new JPanel();
		panel_default.setBackground(new Color(239, 156, 166));
		panel.add(panel_default, "name_6885174916658");
				
		BufferedImage myPicture = ImageIO.read(new File("img/motoboy3.png"));
		panel_default.setLayout(null);
		
		JLabel lblDelivery = new JLabel("Delivery");
		lblDelivery.setForeground(Color.WHITE);
		lblDelivery.setFont(new Font("Ubuntu Mono", Font.BOLD | Font.ITALIC, 60));
		lblDelivery.setBounds(535, 110, 275, 152);
		panel_default.add(lblDelivery);
		
		JLabel lblNewLabel = new JLabel("Javai");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Ubuntu Mono", Font.BOLD | Font.ITALIC, 56));
		lblNewLabel.setBounds(197, 122, 196, 152);
		panel_default.add(lblNewLabel);
		
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(-150, -43, 1200, 800);
		panel_default.add(picLabel);
		
		final JPanel panel_pedidos = new JPanel();
		panel.add(panel_pedidos, "name_6226951430488");
		panel_pedidos.setVisible(false);
		panel_pedidos.setLayout(null);
		
		
		

		final JPanel panel_produtos = new JPanel();
		panel.add(panel_produtos, "name_6258172538637");
		panel_produtos.setLayout(null);
		panel_produtos.setVisible(false);

		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setBounds(389, 52, 50, 16);
		panel_produtos.add(lblProdutos);
		
		final JPanel panel_clientes = new JPanel();
		panel.add(panel_clientes, "name_8948486003038");
		panel_clientes.setLayout(null);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(98, 250, 56, 16);
		panel_clientes.add(lblClientes);
		
		final JPanel panel_arrecadacao = new JPanel();
		panel.add(panel_arrecadacao, "name_8972650475629");
		panel_arrecadacao.setLayout(null);
				
		JButton btnVoltar1 = new JButton("<<");
		btnVoltar1.setForeground(Color.black);
		btnVoltar1.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnVoltar1.setFocusPainted(false);
		btnVoltar1.setBorderPainted(false);
		btnVoltar1.setContentAreaFilled(false);
		btnVoltar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_produtos.setVisible(false);
				panel_pedidos.setVisible(false);
				panel_default.setVisible(true);
				panel_clientes.setVisible(false);
				panel_arrecadacao.setVisible(false);
			}
		});
		btnVoltar1.setBounds(25, 34, 97, 25);
		panel_produtos.add(btnVoltar1);
		
		JButton btnVoltar2 = new JButton("<<");
		btnVoltar2.setForeground(Color.black);
		btnVoltar2.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnVoltar2.setFocusPainted(false);
		btnVoltar2.setBorderPainted(false);
		btnVoltar2.setContentAreaFilled(false);
		btnVoltar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_produtos.setVisible(false);
				panel_pedidos.setVisible(false);
				panel_default.setVisible(true);
				panel_clientes.setVisible(false);
				panel_arrecadacao.setVisible(false);
			}
		});
		btnVoltar2.setBounds(25, 34, 97, 25);
		panel_pedidos.add(btnVoltar2);
		
		JButton btnVoltar3 = new JButton("<<");
		btnVoltar3.setForeground(Color.black);
		btnVoltar3.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnVoltar3.setFocusPainted(false);
		btnVoltar3.setBorderPainted(false);
		btnVoltar3.setContentAreaFilled(false);
		btnVoltar3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_produtos.setVisible(false);
				panel_pedidos.setVisible(false);
				panel_default.setVisible(true);
				panel_clientes.setVisible(false);
				panel_arrecadacao.setVisible(false);
			}
		});
		btnVoltar3.setBounds(25, 34, 97, 25);
		panel_clientes.add(btnVoltar3);
		
		JButton btnVoltar4 = new JButton("<<");
		btnVoltar4.setForeground(Color.black);
		btnVoltar4.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnVoltar4.setFocusPainted(false);
		btnVoltar4.setBorderPainted(false);
		btnVoltar4.setContentAreaFilled(false);
		btnVoltar4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_produtos.setVisible(false);
				panel_pedidos.setVisible(false);
				panel_default.setVisible(true);
				panel_clientes.setVisible(false);
				panel_arrecadacao.setVisible(false);
			}
		});
		btnVoltar4.setBounds(25, 34, 97, 25);
		panel_arrecadacao.add(btnVoltar4);
		
		btnPedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_produtos.setVisible(false);
				panel_pedidos.setVisible(true);
				panel_default.setVisible(false);
				panel_clientes.setVisible(false);
				panel_arrecadacao.setVisible(false);
			}
		});
		
		btnProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_produtos.setVisible(true);
				panel_pedidos.setVisible(false);
				panel_default.setVisible(false);
				panel_clientes.setVisible(false);
				panel_arrecadacao.setVisible(false);
			}
		});
		
		btnClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_produtos.setVisible(false);
				panel_pedidos.setVisible(false);
				panel_default.setVisible(false);
				panel_clientes.setVisible(true);
				panel_arrecadacao.setVisible(false);
			}
		});
		
		btnArrecadacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_produtos.setVisible(false);
				panel_pedidos.setVisible(false);
				panel_default.setVisible(false);
				panel_clientes.setVisible(false);
				panel_arrecadacao.setVisible(true);
			}
		});
	
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		//PEDIDOS
		//panel_pedidos
		JLabel lblPedidos = new JLabel("Pedidos");
		lblPedidos.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lblPedidos.setBounds(399, 17, 140, 59);
		panel_pedidos.add(lblPedidos);
		panel_pedidos.setBackground(new Color(239, 156, 166));
	
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		//ARRECADAÇÃO
		//panel_arrecadacao
		
		JLabel lblArrecadacao = new JLabel("Arrecada\u00E7\u00E3o");
		lblArrecadacao.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lblArrecadacao.setBounds(363, 18, 220, 56);
		panel_arrecadacao.add(lblArrecadacao);
		panel_arrecadacao.setBackground(new Color(239, 156, 166));
		
		txtFefe = new JTextField();
		txtFefe.setHorizontalAlignment(SwingConstants.CENTER);
		txtFefe.setFont(new Font("Verdana", Font.PLAIN, 25));
		txtFefe.setBounds(363, 98, 195, 40);
		panel_arrecadacao.add(txtFefe);
		txtFefe.setColumns(10);
		
		JLabel lblMostrarTotal = new JLabel("New label");
		lblMostrarTotal.setBounds(363, 205, 179, 56);
		lblMostrarTotal.setFont(new Font("Verdana", Font.PLAIN, 25));
		lblMostrarTotal.setText(txtFefe.getText());
		panel_arrecadacao.add(lblMostrarTotal);
		
		
		try {
			produto = Fachada.cadastrarProduto("Sushi Salmao", 19.5);
			produto = Fachada.cadastrarProduto("Sushi Camarão", 20.5);
			produto = Fachada.cadastrarProduto("Sushi Kani", 19.0);
			produto = Fachada.cadastrarProduto("Temaki Salmao", 20.0);
			produto = Fachada.cadastrarProduto("Temaki Camarão", 21.0);
			cliente = Fachada.cadastrarCliente("Samuel", "9999-1234", "samuel@samuel.com", "Rua da Lua");
			pedido = Fachada.abrirPedido("9999-1234");
			Fachada.adicionarProdutoPedido("Samuel", "Sushi Salmao", "Joao");
			Fachada.adicionarProdutoPedido("Samuel", "Sushi Camarão", "Pedro");
			Fachada.adicionarProdutoPedido("Samuel", "Sushi Camarão", "Pedro");
			Fachada.adicionarProdutoPedido("Samuel", "Temaki Camarão", "Jane");
			
			ArrayList<Pedido> p = new ArrayList<Pedido>();
			p = Fachada.listarPedidos("9999-1234");
			
			for(Pedido ped: p ) {
				if(!ped.isFechado()) {
					lblMostrarTotal.setText("Total: " + ped.getTotal());
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("Produto Cadastrado: "+ produto.getNome());
//		
//		
//		
//		cliente = Fachada.cadastrarCliente("Samuel", "9999-1234", "samuel@samuel.com", "Rua da Lua");
//		System.out.println("Cliente Cadastrado: "+ cliente.getNome());
//		
//		cliente = Fachada.cadastrarCliente("Denise", "9999-4321", "denise@denise.com", "Rua da Alegria");
//		cliente = Fachada.cadastrarCliente("Marcio", "9991-1234", "marcio@marcio.com", "Avenida Ferreira");
//		cliente = Fachada.cadastrarCliente("Ana", "9991-4321", "ana@ana.com", "Avenida Poisson");
//
//		pedido = Fachada.abrirPedido("9999-1234");
//		System.out.println("Pedido Cadastrado para 1234: "+ pedido.getId());
//		Fachada.fecharPedido("9999-1234", "Joao");
//		pedido = Fachada.abrirPedido("9999-1234");
//		System.out.println("Pedido Cadastrado para 1234: "+ pedido.getId());
//		pedido = Fachada.abrirPedido("9991-1234");
//		System.out.println("Pedido Cadastrado: "+ pedido.getId());
//
//		pedido = Fachada.abrirPedido("9999-4321");	
//		System.out.println("Pedido Cadastrado: "+ pedido.getId());

	}
}
