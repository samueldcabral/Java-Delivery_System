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
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class DeliveryApp {

	private JFrame frame;
	private JTextField txtFefe;
	private JTextField txt_cad_cli_nome;
	private JTextField txt_cad_cli_email;
	private JTextField txt_cad_cli_ender;
	private JTextField txt_cad_cli_telefone;
	private JTextField filtrar_prod;

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

		final JPanel panel_clientes = new JPanel();
		panel.add(panel_clientes, "name_8948486003038");
		panel_clientes.setLayout(null);
		
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
		
		JButton btnListar = new JButton("LISTAR");
		
		btnListar.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnListar.setFocusPainted(false);
		btnListar.setContentAreaFilled(false);
		btnListar.setBounds(118, 97, 148, 59);
		panel_pedidos.add(btnListar);
		
		JButton btnCadastrar = new JButton("ABRIR");
		btnCadastrar.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setBounds(359, 97, 148, 59);
		panel_pedidos.add(btnCadastrar);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnConsultar.setFocusPainted(false);
		btnConsultar.setContentAreaFilled(false);
		btnConsultar.setBounds(560, 97, 236, 59);
		panel_pedidos.add(btnConsultar);
		
		JPanel panel_pedidos_card = new JPanel();
		panel_pedidos_card.setBounds(32, 163, 850, 512);
		panel_pedidos_card.setBackground(new Color(239, 156, 166));
		panel_pedidos.add(panel_pedidos_card);
		panel_pedidos_card.setLayout(new CardLayout(0, 0));
		
		final JPanel panel_pedidos_defua = new JPanel();
		panel_pedidos_defua.setBackground(new Color(239, 156, 166));
		panel_pedidos_card.add(panel_pedidos_defua, "name_8505530037068");
		
		
		final JPanel panel_pedidos_listar = new JPanel();
		panel_pedidos_card.add(panel_pedidos_listar, "name_8209689044899");
		panel_pedidos_listar.setBackground(new Color(239, 156, 166));
		panel_pedidos_listar.setLayout(null);
		
		final JPanel panel_pedidos_abrir = new JPanel();
		panel_pedidos_abrir.setBackground(new Color(239, 156, 166));
		panel_pedidos_card.add(panel_pedidos_abrir, "name_8229821385041");
		
		JLabel lbl_pedidos_abrir = new JLabel("abrir");
		panel_pedidos_abrir.add(lbl_pedidos_abrir);
		
		final JPanel panel_pedidos_consultar = new JPanel();
		panel_pedidos_consultar.setBackground(new Color(239, 156, 166));
		panel_pedidos_card.add(panel_pedidos_consultar, "name_8241655800377");
		
		JLabel lbl_pedidos_consultar = new JLabel("consultar");
		
		panel_pedidos_consultar.add(lbl_pedidos_consultar);
		panel_pedidos_defua.setVisible(true);
		panel_pedidos_listar.setVisible(false);
		panel_pedidos_consultar.setVisible(false);
		panel_pedidos_abrir.setVisible(false);
		
		//////////////////////////////////// PANEL PEDIDOS LISTAR
		//panel_pedidos_listar
		
		panel_pedidos_listar.setBackground(new Color(239, 156, 166));
		JLabel lblPedidos_listar = new JLabel("Listar Pedido via Tel:");
		lblPedidos_listar.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lblPedidos_listar.setBounds(38, 49, 451, 35);
		panel_pedidos_listar.add(lblPedidos_listar);
		
		final JTextField filtrar_ped = new JTextField();
		filtrar_ped.setText("n");
		filtrar_ped.setFont(new Font("Tahoma", Font.PLAIN, 24));
		filtrar_ped.setEnabled(true);
		filtrar_ped.setColumns(10);
		filtrar_ped.setBounds(463, 51, 148, 35);
		panel_pedidos_listar.add(filtrar_ped);
			
		final JButton btn_filtrar_pedido_Ok = new JButton("OK");
		btn_filtrar_pedido_Ok.setBounds(623, 49, 74, 35);
		panel_pedidos_listar.add(btn_filtrar_pedido_Ok);
		
		final JTextArea txt_filtrar_ped = new JTextArea();
		txt_filtrar_ped.setBounds(124, 141, 614, 358);
		panel_pedidos_listar.add(txt_filtrar_ped);
		
		
		btn_filtrar_pedido_Ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tel = "";
				System.out.println(filtrar_ped.getText());
				if(filtrar_ped.getText() != "n") {
					System.out.println("hereehfuehfeu");
					tel  = filtrar_ped.getText();
				}else {
					System.out.println("era pra ta aqui");
					tel = "";
				}
				
				String result = "";
				ArrayList<Pedido> ped = new ArrayList<Pedido>();

				if(tel == "") {
					
					ped = Fachada.listarPedidos();
					for(Pedido p : ped) {
						result += p.getId() + ": " + p.getTotal() + ", " + p.getCliente() + "\n";
					}
					txt_filtrar_ped.setText(result);
				}else {
					System.out.println("here????????");
					try {
						ped = Fachada.listarPedidos(tel);
					} catch (Exception e) {
						e.printStackTrace();
					}
					for(Pedido p : ped) {
						result += p.getId() + ": " + p.getTotal() + ", " + p.getCliente() + "\n";
					}
					txt_filtrar_ped.setText(result);
				}
				
			}
		});
		
		
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_pedidos_defua.setVisible(false);
				panel_pedidos_listar.setVisible(true);
				panel_pedidos_consultar.setVisible(false);
				panel_pedidos_abrir.setVisible(false);
			}
		});
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_pedidos_defua.setVisible(false);
				panel_pedidos_listar.setVisible(false);
				panel_pedidos_consultar.setVisible(false);
				panel_pedidos_abrir.setVisible(true);
			}
		});
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_pedidos_defua.setVisible(false);
				panel_pedidos_listar.setVisible(false);
				panel_pedidos_consultar.setVisible(true);
				panel_pedidos_abrir.setVisible(false);
			}
		});
		
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
		txtFefe.setBounds(325, 100, 195, 40);
		panel_arrecadacao.add(txtFefe);
		txtFefe.setColumns(10);
		
		final JLabel lblMostrarTotal = new JLabel("New label");
		lblMostrarTotal.setBounds(363, 205, 179, 56);
		lblMostrarTotal.setFont(new Font("Verdana", Font.PLAIN, 25));
		lblMostrarTotal.setText(txtFefe.getText());
		panel_arrecadacao.add(lblMostrarTotal);
		
		JButton btnArrecadacaoOk = new JButton("OK");
		btnArrecadacaoOk.setBounds(523, 97, 72, 43);
		panel_arrecadacao.add(btnArrecadacaoOk);
		
		
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
			p = Fachada.listarPedidos();
			
			for(Pedido ped: p ) {
				if(!ped.isFechado()) {
					lblMostrarTotal.setText("Total: " + ped.getTotal());
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnArrecadacaoOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Pedido> p = new ArrayList<Pedido>();
				try {
					p = Fachada.listarPedidos();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				for(Pedido ped: p ) {
					if(!ped.isFechado()) {
						lblMostrarTotal.setText("Total: " + ped.getTotal());
					}
				}
			}
		});
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

		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		//CLIENTE
		//panel_clientes
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lblClientes.setBounds(363, 18, 220, 56);
		panel_clientes.add(lblClientes);
		panel_clientes.setBackground(new Color(239, 156, 166));
		
		final JCheckBox chckbxCadastrar_cliente = new JCheckBox("Cadastrar");
		chckbxCadastrar_cliente.setBounds(348, 91, 113, 25);
		chckbxCadastrar_cliente.setFocusPainted(false);
		chckbxCadastrar_cliente.setContentAreaFilled(false);
		
		panel_clientes.add(chckbxCadastrar_cliente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblNome.setBounds(110, 158, 76, 31);
		panel_clientes.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblEmail.setBounds(100, 224, 76, 31);
		panel_clientes.add(lblEmail);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblEndereo.setBounds(79, 301, 97, 31);
		panel_clientes.add(lblEndereo);
		
		JLabel lblTelefone = new JLabel("telefone:");
		lblTelefone.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblTelefone.setBounds(85, 377, 101, 31);
		panel_clientes.add(lblTelefone);
		
		txt_cad_cli_ender = new JTextField();
		txt_cad_cli_ender.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_cad_cli_ender.setEnabled(false);
		txt_cad_cli_ender.setColumns(10);
		txt_cad_cli_ender.setBounds(179, 301, 129, 35);
		panel_clientes.add(txt_cad_cli_ender);
		
		txt_cad_cli_telefone = new JTextField();
		txt_cad_cli_telefone.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_cad_cli_telefone.setEnabled(false);
		txt_cad_cli_telefone.setColumns(10);
		txt_cad_cli_telefone.setBounds(179, 377, 129, 35);
		panel_clientes.add(txt_cad_cli_telefone);
		
		txt_cad_cli_nome = new JTextField();
		txt_cad_cli_nome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_cad_cli_nome.setEnabled(false);
		txt_cad_cli_nome.setBounds(179, 154, 129, 35);
		panel_clientes.add(txt_cad_cli_nome);
		txt_cad_cli_nome.setColumns(10);
		
		txt_cad_cli_email = new JTextField();
		txt_cad_cli_email.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_cad_cli_email.setEnabled(false);
		txt_cad_cli_email.setColumns(10);
		txt_cad_cli_email.setBounds(179, 220, 129, 35);
		panel_clientes.add(txt_cad_cli_email);
		
		final JButton btn_cadastrar_cliente = new JButton("Cadastrar");
		btn_cadastrar_cliente.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		
		btn_cadastrar_cliente.setEnabled(false);
		btn_cadastrar_cliente.setBounds(179, 440, 129, 56);
		panel_clientes.add(btn_cadastrar_cliente);
		
		final JTextArea txtArea_cliente = new JTextArea();
		txtArea_cliente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtArea_cliente.setEditable(false);
		txtArea_cliente.setBounds(490, 158, 313, 338);
		panel_clientes.add(txtArea_cliente);
		
		final JCheckBox chckbxListar_cliente = new JCheckBox("Listar");
		chckbxListar_cliente.setFocusPainted(false);
		chckbxListar_cliente.setContentAreaFilled(false);
		chckbxListar_cliente.setBounds(445, 91, 113, 25);
		panel_clientes.add(chckbxListar_cliente);
		
		chckbxListar_cliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxListar_cliente.isSelected()) {
					String clien = "";
					ArrayList<Cliente> c = new ArrayList<Cliente>();
					c = Fachada.listarClientes();
					
					for(Cliente cli : c) {
						clien += cli.getNome() + " tem " + cli.getTotalPedidos() + " pedido(s)." + "\n";
					}
					txtArea_cliente.setText(clien);
				}else {
					txtArea_cliente.setText("");
				}
			}
		});
		
		chckbxCadastrar_cliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxCadastrar_cliente.isSelected()) {
					txt_cad_cli_nome.setEnabled(true);
					txt_cad_cli_telefone.setEnabled(true);
					txt_cad_cli_ender.setEnabled(true);
					txt_cad_cli_email.setEnabled(true);
					btn_cadastrar_cliente.setEnabled(true);
				}else {
					txt_cad_cli_nome.setEnabled(false);
					txt_cad_cli_telefone.setEnabled(false);
					txt_cad_cli_ender.setEnabled(false);
					txt_cad_cli_email.setEnabled(false);
					btn_cadastrar_cliente.setEnabled(false);
				}
			}
		});
		
		btn_cadastrar_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cadNome = txt_cad_cli_nome.getText();
				String cadEmail = txt_cad_cli_email.getText();
				String cadEndereco = txt_cad_cli_ender.getText();
				String cadTelefone = txt_cad_cli_telefone.getText();
				System.out.println("The values were: " + cadNome + " " + cadEmail + " " + cadTelefone + " " + cadEndereco);
				try {
					Cliente c = Fachada.cadastrarCliente(cadNome, cadTelefone, cadEmail, cadEndereco);
					txtArea_cliente.setText("O cliente " + c.getNome() + " foi criado com sucesso!");
				} catch (Exception e) {
					e.printStackTrace();
					txtArea_cliente.setText("Não foi possível cadastrar o cliente!");
				}
				
			}
		});
	
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		//PRODUTOS
		//panel_produtos
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lblProdutos.setBounds(363, 18, 220, 56);
		panel_produtos.add(lblProdutos);
		panel_produtos.setBackground(new Color(239, 156, 166));
		
		final JCheckBox chckbxCadastrar_produto = new JCheckBox("Cadastrar");
		chckbxCadastrar_produto.setBounds(348, 91, 113, 25);
		chckbxCadastrar_produto.setFocusPainted(false);
		chckbxCadastrar_produto.setContentAreaFilled(false);
		
		panel_produtos.add(chckbxCadastrar_produto);
		
		JLabel lblNomeProd = new JLabel("Nome:");
		lblNomeProd.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblNomeProd.setBounds(110, 158, 76, 31);
		panel_produtos.add(lblNomeProd);
		
		JLabel lblPrecoProd = new JLabel("Preço:");
		lblPrecoProd.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblPrecoProd.setBounds(100, 224, 76, 31);
		panel_produtos.add(lblPrecoProd);
		
		final JTextField txt_cad_prod_nome = new JTextField();
		txt_cad_prod_nome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_cad_prod_nome.setEnabled(false);
		txt_cad_prod_nome.setBounds(188, 153, 129, 35);
		panel_produtos.add(txt_cad_prod_nome);
		txt_cad_prod_nome.setColumns(10);
				
		final JTextField txt_cad_prod_preco = new JTextField();
		txt_cad_prod_preco.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_cad_prod_preco.setEnabled(false);
		txt_cad_prod_preco.setColumns(10);
		txt_cad_prod_preco.setBounds(188, 219, 129, 35);
		panel_produtos.add(txt_cad_prod_preco);
		
		final JButton btn_cadastrar_produto = new JButton("Cadastrar");
		btn_cadastrar_produto.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		
		btn_cadastrar_produto.setEnabled(false);
		btn_cadastrar_produto.setBounds(188, 290, 129, 56);
		panel_produtos.add(btn_cadastrar_produto);
		
		final JTextArea txtArea_produto = new JTextArea();
		txtArea_produto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtArea_produto.setEditable(false);
		txtArea_produto.setBounds(457, 188, 347, 338);
		panel_produtos.add(txtArea_produto);
		
		final JCheckBox chckbxListar_produto = new JCheckBox("Listar");
		chckbxListar_produto.setFocusPainted(false);
		chckbxListar_produto.setContentAreaFilled(false);
		chckbxListar_produto.setBounds(445, 91, 113, 25);
		panel_produtos.add(chckbxListar_produto);
		
		filtrar_prod = new JTextField();
		filtrar_prod.setFont(new Font("Tahoma", Font.PLAIN, 24));
		filtrar_prod.setEnabled(false);
		filtrar_prod.setColumns(10);
		filtrar_prod.setBounds(588, 140, 148, 35);
		panel_produtos.add(filtrar_prod);
		
		JLabel lblFiltrarPorNome = new JLabel("Filtrar nome:");
		lblFiltrarPorNome.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblFiltrarPorNome.setBounds(457, 145, 136, 31);
		panel_produtos.add(lblFiltrarPorNome);
		
		final JButton btn_filtrar_prod_Ok = new JButton("OK");
		btn_filtrar_prod_Ok.setBounds(741, 140, 69, 35);
		panel_produtos.add(btn_filtrar_prod_Ok);
		
		chckbxListar_produto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxListar_produto.isSelected()) {
					filtrar_prod.setEnabled(true);
					
					btn_filtrar_prod_Ok.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							String produ = "";
							String nomeProdu = filtrar_prod.getText();
							ArrayList<Produto> p = new ArrayList<Produto>();

							if(nomeProdu != "") {
								p = Fachada.listarProdutos(nomeProdu);
								if(p.size() == 0) {
									p = Fachada.listarProdutos();
								}
							}else {
								p = Fachada.listarProdutos();
							}
			
							for(Produto prd : p) {
								produ += prd.getNome() + " valor " + prd.getPreco() + "\n";
							}
							txtArea_produto.setText(produ);
						}
						});
					
				}else {
					txtArea_produto.setText("");
				}
			}
		});
		
		chckbxCadastrar_produto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxCadastrar_produto.isSelected()) {
					txt_cad_prod_preco.setEnabled(true);
					txt_cad_prod_nome.setEnabled(true);
					btn_cadastrar_produto.setEnabled(true);
				}else {
					txt_cad_prod_preco.setEnabled(false);
					txt_cad_prod_nome.setEnabled(false);
					btn_cadastrar_produto.setEnabled(false);
				}
			}
		});
		
		btn_cadastrar_produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cadNome = txt_cad_prod_nome.getText();
				double cadPreco = Double.parseDouble(txt_cad_prod_preco.getText());
				try {
					Produto p = Fachada.cadastrarProduto(cadNome, cadPreco);
					txtArea_produto.setText("O produto " + p.getNome() + " foi criado com sucesso!");
				} catch (Exception e) {
					e.printStackTrace();
					txtArea_produto.setText("Não foi possível cadastrar o produto!");
				}
				
			}
		});

	}
}
