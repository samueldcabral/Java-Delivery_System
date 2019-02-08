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
import modelo.Combo;
import modelo.Pedido;
import modelo.Produto;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DeliveryApp {

	private JFrame frame;
	private JTextField txtArrecadacao;
	private JTextField txt_cad_cli_nome;
	private JTextField txt_cad_cli_email;
	private JTextField txt_cad_cli_ender;
	private JTextField txt_cad_cli_telefone;
	private JTextField filtrar_prod;
	private JTextField txt_abrir_adc_tel;
	private JTextField txt_abrir_rm_tel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() throws IOException {
//		Produto produto;
//		Pedido pedido;
//		Cliente cliente;
//		
		
		frame = new JFrame();
		frame.setBounds(200, 45, 1450, 918);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBorder(new MatteBorder(0, 0, 0, 2, (Color) SystemColor.windowBorder));
		panel_menu.setBackground(new Color(65, 111, 148));
		panel_menu.setBounds(0, 0, 289, 943);
		frame.getContentPane().add(panel_menu);
		panel_menu.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setForeground(new Color(255, 255, 255));
		lblMenu.setFont(new Font("Ubuntu Mono", Font.BOLD, 66));
		lblMenu.setBounds(12, 59, 265, 76);
		panel_menu.add(lblMenu);
		
		JButton btnPedidos = new JButton("Pedidos");
		btnPedidos.setForeground(new Color(255, 255, 255));
		btnPedidos.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnPedidos.setBounds(54, 186, 192, 65);
		btnPedidos.setFocusPainted(false);
		btnPedidos.setContentAreaFilled(false);
		panel_menu.add(btnPedidos);
		
		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.setForeground(Color.WHITE);
		btnProdutos.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnProdutos.setFocusPainted(false);
		btnProdutos.setContentAreaFilled(false);
		btnProdutos.setBounds(54, 276, 192, 65);
		panel_menu.add(btnProdutos);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setForeground(Color.WHITE);
		btnClientes.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnClientes.setFocusPainted(false);
		btnClientes.setContentAreaFilled(false);
		btnClientes.setBounds(54, 376, 192, 65);
		panel_menu.add(btnClientes);
		
		JButton btnArrecadacao = new JButton("Arrecada\u00E7\u00E3o");
		btnArrecadacao.setForeground(Color.WHITE);
		btnArrecadacao.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnArrecadacao.setFocusPainted(false);
		btnArrecadacao.setContentAreaFilled(false);
		btnArrecadacao.setBounds(29, 473, 248, 65);
		panel_menu.add(btnArrecadacao);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 128, 128));
		panel.setBounds(289, 0, 1167, 943);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		final JPanel panel_default = new JPanel();
		panel_default.setBackground(new Color(239, 156, 166));
		panel.add(panel_default, "name_6885174916658");
				
		BufferedImage myPicture = ImageIO.read(new File("img/motoboy3.png"));
		panel_default.setLayout(null);
		
		JLabel lblDelivery = new JLabel("Delivery");
		lblDelivery.setForeground(Color.WHITE);
		lblDelivery.setFont(new Font("Ubuntu Mono", Font.BOLD | Font.ITALIC, 66));
		lblDelivery.setBounds(647, 207, 400, 152);
		panel_default.add(lblDelivery);
		
		JLabel lblNewLabel = new JLabel("Javai");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Ubuntu Mono", Font.BOLD | Font.ITALIC, 62));
		lblNewLabel.setBounds(269, 208, 196, 152);
		panel_default.add(lblNewLabel);
		
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(-154, -61, 1391, 1011);
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
		
		lblMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_produtos.setVisible(false);
				panel_pedidos.setVisible(false);
				panel_default.setVisible(true);
				panel_clientes.setVisible(false);
				panel_arrecadacao.setVisible(false);
			}
		});
		
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
		
		///////////////////////////////////////////////////////////////////////////////////
		//PRE CADASTRAR
		
		try {
			Produto sushiSalmao = Fachada.cadastrarProduto("Sushi Salmao", 19.5);
			Produto sushiCamarao = Fachada.cadastrarProduto("Sushi Camarão", 20.5);
			Produto sushiKani = Fachada.cadastrarProduto("Sushi Kani", 19.0);
			Produto temakiSalmao = Fachada.cadastrarProduto("Temaki Salmao", 20.0);
			Produto temakiCamarao = Fachada.cadastrarProduto("Temaki Camarão", 21.0);
			Fachada.cadastrarCliente("Samuel", "9999-1234", "samuel@samuel.com", "Rua da Lua");
			Fachada.cadastrarCliente("Marianna Leite", "9999-4321", "marianna@m.com", "Rua do Pão");
			Fachada.abrirPedido("9999-1234");
			List<Integer> idCombo = new ArrayList<>();
			idCombo.add(sushiSalmao.getId());
			idCombo.add(temakiSalmao.getId());
			Fachada.criarCombo("Combo Salmão", idCombo);
			
			idCombo.clear();
			idCombo.add(sushiCamarao.getId());
			idCombo.add(temakiCamarao.getId());
			Fachada.criarCombo("Combo Camarão", idCombo);
			
			idCombo.clear();
			idCombo.add(sushiCamarao.getId());
			idCombo.add(sushiKani.getId());
			idCombo.add(sushiSalmao.getId());
			
			Fachada.criarCombo("Combo Sushis", idCombo);
			
			Fachada.adicionarProdutoPedido("Samuel", "Sushi Salmao", "Joao");
			Fachada.adicionarProdutoPedido("Samuel", "Sushi Camarão", "Pedro");
			Fachada.adicionarProdutoPedido("Samuel", "Sushi Camarão", "Pedro");
			Fachada.adicionarProdutoPedido("Samuel", "Temaki Camarão", "Jane");
			
			
		   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		//PEDIDOS
		//panel_pedidos
		JLabel lblPedidos = new JLabel("Pedidos");
		lblPedidos.setFont(new Font("Ubuntu Mono", Font.PLAIN, 54));
		lblPedidos.setBounds(469, 28, 429, 56);
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
		btnCadastrar.setBounds(485, 97, 148, 59);
		panel_pedidos.add(btnCadastrar);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnConsultar.setFocusPainted(false);
		btnConsultar.setContentAreaFilled(false);
		btnConsultar.setBounds(844, 97, 236, 59);
		panel_pedidos.add(btnConsultar);
		
		JPanel panel_pedidos_card = new JPanel();
		panel_pedidos_card.setBounds(32, 163, 1085, 694);
		panel_pedidos_card.setBackground(new Color(255, 0, 0));
		panel_pedidos.add(panel_pedidos_card);
		panel_pedidos_card.setLayout(new CardLayout(0, 0));
		
		final JPanel panel_pedidos_defua = new JPanel();
		panel_pedidos_defua.setBackground(new Color(239, 156, 166));
		panel_pedidos_card.add(panel_pedidos_defua, "name_8505530037068");
		
		final JPanel panel_pedidos_listar = new JPanel();
		panel_pedidos_card.add(panel_pedidos_listar, "name_8209689044899");
		panel_pedidos_listar.setBackground(new Color(0, 250, 154));
		panel_pedidos_listar.setLayout(null);
		
		final JPanel panel_pedidos_abrir = new JPanel();
		panel_pedidos_abrir.setBackground(new Color(239, 156, 166));
		panel_pedidos_card.add(panel_pedidos_abrir, "name_8229821385041");
		
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
		lblPedidos_listar.setBounds(359, 13, 451, 35);
		panel_pedidos_listar.add(lblPedidos_listar);
		
		final JTextField filtrar_ped = new JTextField();
		filtrar_ped.setText("");
		filtrar_ped.setFont(new Font("Tahoma", Font.PLAIN, 24));
		filtrar_ped.setEnabled(true);
		filtrar_ped.setColumns(10);
		filtrar_ped.setBounds(359, 75, 317, 35);
		panel_pedidos_listar.add(filtrar_ped);
			
		final JButton btn_filtrar_pedido_Ok = new JButton("OK");
		btn_filtrar_pedido_Ok.setBounds(704, 75, 74, 35);
		panel_pedidos_listar.add(btn_filtrar_pedido_Ok);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(138, 134, 826, 425);
		panel_pedidos_listar.add(scrollPane_1);
		
		final JTextArea txt_filtrar_ped = new JTextArea();
		scrollPane_1.setViewportView(txt_filtrar_ped);
		txt_filtrar_ped.setRows(60);
		txt_filtrar_ped.setColumns(3);
		txt_filtrar_ped.setFont(new Font("Monospaced", Font.BOLD, 20));
		
			
		JLabel lblTelxxxxxxxx = new JLabel("Tel (xxxx-xxxx):");
		lblTelxxxxxxxx.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTelxxxxxxxx.setBounds(216, 75, 131, 37);
		panel_pedidos_listar.add(lblTelxxxxxxxx);
		
		JLabel lblDigiteIdDo = new JLabel("Digite Id do pedido fechado para cancelar:");
		lblDigiteIdDo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDigiteIdDo.setBounds(189, 574, 460, 37);
		panel_pedidos_listar.add(lblDigiteIdDo);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_2.setEnabled(true);
		textField_2.setColumns(10);
		textField_2.setBounds(189, 624, 317, 35);
		panel_pedidos_listar.add(textField_2);
		
		JButton button_1 = new JButton("OK");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int retirar = Integer.parseInt(textField_2.getText());
				try {
					Fachada.excluirPedido(retirar);
					txt_filtrar_ped.setText("Pedido cancelado com sucesso!");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					txt_filtrar_ped.setText(e.getMessage());
				}
			}
		});
		button_1.setBounds(518, 624, 74, 35);
		panel_pedidos_listar.add(button_1);
		
		
		btn_filtrar_pedido_Ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tel = "";
		
				if(filtrar_ped.getText().length() == 0) {
					tel  = "";
				}else {
					tel = filtrar_ped.getText();
				}
				
				String result = "";
				ArrayList<Pedido> ped = new ArrayList<Pedido>();

				if(tel == "") {
					
					ped = Fachada.listarPedidos();
					for(Pedido p : ped) {
						result += p.getId() + ": total: " + p.getTotal() + "\ncliente: " + p.getCliente().getNome() + "\nTelefone:" + p.getCliente().getTelefone() + p + "\n";
					}
					txt_filtrar_ped.setText(result);
					
				}else {
					try {
						ped = Fachada.listarPedidos(tel);
					} catch (Exception e) {
						e.printStackTrace();
						txt_filtrar_ped.setText(e.getMessage());
					}
					
					for(Pedido p : ped) {
						result += p.getId() + ": The total: " + p.getTotal() + "\ncliente: " + p.getCliente().getNome() + "\nTelefone:" + p.getCliente().getTelefone() + "\nPedidos:" + p.getCliente().getPedidos()  + "\n";
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
		
		////////////////////////////////////PANEL PEDIDOS ABRIR
		//panel_pedidos_abrir
		
		panel_pedidos_abrir.setBackground(new Color(239, 156, 166));
		panel_pedidos_abrir.setLayout(null);
		JLabel lblPedidos_abrir = new JLabel("Digite o tel:");
		lblPedidos_abrir.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lblPedidos_abrir.setBounds(124, 112, 234, 35);
		panel_pedidos_abrir.add(lblPedidos_abrir);
		
		final JTextField abrir_ped = new JTextField();
		abrir_ped.setText("");
		abrir_ped.setFont(new Font("Tahoma", Font.PLAIN, 24));
		abrir_ped.setEnabled(true);
		abrir_ped.setColumns(10);
		abrir_ped.setBounds(433, 114, 243, 35);
		panel_pedidos_abrir.add(abrir_ped);
		
		final JButton btn_abrir_pedido_Ok = new JButton("OK");
		
		btn_abrir_pedido_Ok.setBounds(688, 112, 83, 37);
		panel_pedidos_abrir.add(btn_abrir_pedido_Ok);
		
		JLabel lbl_abrir_abrir = new JLabel("ABRIR");
		lbl_abrir_abrir.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lbl_abrir_abrir.setBounds(124, 51, 234, 35);
		panel_pedidos_abrir.add(lbl_abrir_abrir);
		
		JLabel lbl_abrir_adc = new JLabel("ADICIONAR PRODUTO");
		lbl_abrir_adc.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lbl_abrir_adc.setBounds(124, 238, 324, 35);
		panel_pedidos_abrir.add(lbl_abrir_adc);
		
		JLabel lbl_abrir_adc_tel = new JLabel("Digite o tel:");
		lbl_abrir_adc_tel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lbl_abrir_adc_tel.setBounds(124, 299, 292, 35);
		panel_pedidos_abrir.add(lbl_abrir_adc_tel);
		
		txt_abrir_adc_tel = new JTextField();
		txt_abrir_adc_tel.setText("");
		txt_abrir_adc_tel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_abrir_adc_tel.setEnabled(true);
		txt_abrir_adc_tel.setColumns(10);
		txt_abrir_adc_tel.setBounds(428, 301, 248, 35);
		panel_pedidos_abrir.add(txt_abrir_adc_tel);
		
		JButton btn_abrir_adc_tel = new JButton("OK");
		btn_abrir_adc_tel.setBounds(688, 299, 83, 86);
		panel_pedidos_abrir.add(btn_abrir_adc_tel);
		
		JLabel lbl_abrir_rm = new JLabel("REMOVER PRODUTO");
		lbl_abrir_rm.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lbl_abrir_rm.setBounds(124, 501, 324, 35);
		panel_pedidos_abrir.add(lbl_abrir_rm);
		
		JLabel lbl_abrir_rm_tel = new JLabel("Digite o tel:");
		lbl_abrir_rm_tel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lbl_abrir_rm_tel.setBounds(124, 562, 279, 35);
		panel_pedidos_abrir.add(lbl_abrir_rm_tel);
		
		txt_abrir_rm_tel = new JTextField();
		txt_abrir_rm_tel.setText("");
		txt_abrir_rm_tel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_abrir_rm_tel.setEnabled(true);
		txt_abrir_rm_tel.setColumns(10);
		txt_abrir_rm_tel.setBounds(428, 564, 248, 35);
		panel_pedidos_abrir.add(txt_abrir_rm_tel);
		
		JButton btn_abrir_rm_tel = new JButton("OK");
		btn_abrir_rm_tel.setBounds(688, 562, 83, 86);
		panel_pedidos_abrir.add(btn_abrir_rm_tel);
		
		final JLabel lbl_abrir_status = new JLabel("STATUS: ");
		lbl_abrir_status.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lbl_abrir_status.setBounds(537, 51, 536, 35);
		panel_pedidos_abrir.add(lbl_abrir_status);
		
		final JLabel lbl_adc_status = new JLabel("STATUS: ");
		lbl_adc_status.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lbl_adc_status.setBounds(537, 238, 536, 35);
		panel_pedidos_abrir.add(lbl_adc_status);
		
		final JLabel lbl_rm_status = new JLabel("STATUS: ");
		lbl_rm_status.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lbl_rm_status.setBounds(528, 501, 545, 35);
		panel_pedidos_abrir.add(lbl_rm_status);
	    
	    final JComboBox comboBox_1 = new JComboBox();
	    comboBox_1.setBounds(428, 349, 248, 36);
	    panel_pedidos_abrir.add(comboBox_1);
	    
	    JLabel lblEscolha = new JLabel("Escolha:");
	    lblEscolha.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
	    lblEscolha.setBounds(124, 347, 292, 35);
	    panel_pedidos_abrir.add(lblEscolha);
	    
	    JLabel label = new JLabel("Escolha:");
	    label.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
	    label.setBounds(124, 599, 292, 35);
	    panel_pedidos_abrir.add(label);
	    
	    final JComboBox comboBox = new JComboBox();
	    comboBox.setBounds(428, 601, 248, 36);
	    panel_pedidos_abrir.add(comboBox);
	    
		btn_abrir_pedido_Ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				String telefone = abrir_ped.getText();
				Pedido p = null;
				try {
					p = Fachada.abrirPedido(telefone);
					
					ArrayList<Produto> prods = new ArrayList<Produto>();
		    		prods = Fachada.listarProdutos();
		   
		    		Vector comboBoxItems=new Vector();
		    		for(Produto pa : prods) {
		    			comboBoxItems.add(pa.getNome());
		    		}
		    	    comboBox_1.setModel(new DefaultComboBoxModel(comboBoxItems));
		    	    
				} catch (Exception e) {
					e.printStackTrace();
					lbl_abrir_status.setText(e.getMessage());
				}
				
				lbl_abrir_status.setText("STATUS: " + "ID: " + p.getId());
			}
		});
		
		btn_abrir_adc_tel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome_entregador = "Joao";
				String tel = txt_abrir_adc_tel.getText();
				String produtoSelected = (String) comboBox_1.getSelectedItem();
				
				try {
					Cliente cli = Fachada.localizarCliente(tel);
					Fachada.adicionarProdutoPedido(cli.getNome(), produtoSelected, nome_entregador);
					lbl_adc_status.setText("STATUS: Adicionado!");
					
					ArrayList<Produto> prods = new ArrayList<Produto>();
					Pedido ped = Fachada.abrirPedido(tel);
					
		    		prods = ped.getProdutos();
		   
		    		Vector comboBoxItems=new Vector();
		    		for(Produto pa : prods) {
		    			comboBoxItems.add(pa.getNome());
		    		}
		    	    comboBox.setModel(new DefaultComboBoxModel(comboBoxItems));
		    	    
				} catch (Exception e) {
					e.printStackTrace();
					lbl_adc_status.setText(e.getMessage());
				}
			}
		});
		
		btn_abrir_rm_tel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tel = txt_abrir_rm_tel.getText();
				String produtoSelected = (String) comboBox.getSelectedItem();
				
				try {
					Cliente cli = Fachada.localizarCliente(tel);
					Fachada.removerProdutoPedido(cli.getNome(), produtoSelected);
					lbl_rm_status.setText("STATUS: Removido!");
					
				} catch (Exception e) {
					e.printStackTrace();
					lbl_rm_status.setText(e.getMessage());
					
				}
			}
		});
		
		////////////////////////////////////PANEL PEDIDOS CONSULTAR
		//panel_pedidos_consultar
		
		panel_pedidos_consultar.setBackground(new Color(239, 156, 166));
		panel_pedidos_consultar.setLayout(null);
		JLabel lblPedidos_consultar = new JLabel("Digite o tel:");
		lblPedidos_consultar.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lblPedidos_consultar.setBounds(247, 81, 234, 35);
		panel_pedidos_consultar.add(lblPedidos_consultar);
		
		final JTextField txtPedidos_consultar = new JTextField();
		txtPedidos_consultar.setText("");
		txtPedidos_consultar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtPedidos_consultar.setEnabled(true);
		txtPedidos_consultar.setColumns(10);
		txtPedidos_consultar.setBounds(493, 83, 245, 35);
		panel_pedidos_consultar.add(txtPedidos_consultar);
		
		JLabel lbl_consultar = new JLabel("CONSULTAR");
		lbl_consultar.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		lbl_consultar.setBounds(453, 27, 234, 35);
		panel_pedidos_consultar.add(lbl_consultar);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(187, 138, 714, 285);
		panel_pedidos_consultar.add(scrollPane_2);
		
		final JTextArea consultar_txt_field = new JTextArea();
		scrollPane_2.setViewportView(consultar_txt_field);
		consultar_txt_field.setFont(new Font("Monospaced", Font.BOLD, 20));
		
		final JButton btnFechar = new JButton("FECHAR");
		btnFechar.setBounds(187, 478, 132, 37);
		panel_pedidos_consultar.add(btnFechar);
		
		final JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(465, 482, 138, 37);
		panel_pedidos_consultar.add(btnCancelar);
		
		final JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(776, 482, 125, 37);
		panel_pedidos_consultar.add(btnEnviar);
		
		JButton btnOk = new JButton("OK");
		
		btnOk.setBounds(750, 81, 107, 37);
		panel_pedidos_consultar.add(btnOk);
		
		final JLabel lblStatus = new JLabel("STATUS: ");
		lblStatus.setFont(new Font("Ubuntu Mono", Font.PLAIN, 24));
		lblStatus.setBounds(197, 436, 567, 29);
		panel_pedidos_consultar.add(lblStatus);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String telefone = txtPedidos_consultar.getText();
				Cliente c = null;
				Pedido p = null;
				
				try {
					c = Fachada.localizarCliente(telefone);
					p = Fachada.consultarPedido(telefone);
										
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					consultar_txt_field.setText(e.getMessage());
				}
				String texto = "Nome: " + c.getNome() + "\nPedido: " + p;
				final int idPedido = p.getId();
				consultar_txt_field.setText(texto);
				
				btnFechar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String entregador = "joao";
						String telefone = txtPedidos_consultar.getText();
						
						try {
							Fachada.fecharPedido(telefone, entregador);
							lblStatus.setText("STATUS: Pedido " + idPedido + " Fechado!");
						} catch (Exception e) {
							e.printStackTrace();
							lblStatus.setText(e.getMessage());
						}
					}
				});
				
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String telefone = txtPedidos_consultar.getText();
						
						try {
							Fachada.cancelarPedido(telefone);
							lblStatus.setText("STATUS: Pedido " + idPedido + " Cancelado!");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							lblStatus.setText(e.getMessage());
						}
					}
				});
				
				btnEnviar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String telefone = txtPedidos_consultar.getText();
						
						try {
							Fachada.enviarPedidoEmail(telefone);
							lblStatus.setText("STATUS: Pedido " + idPedido + " Enviado por Email!!");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							lblStatus.setText(e.getMessage());
						}
					}
				});
				
			}
		});
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		//ARRECADAÇÃO
		//panel_arrecadacao
		
		JLabel lblArrecadacao = new JLabel("Arrecada\u00E7\u00E3o");
		lblArrecadacao.setFont(new Font("Ubuntu Mono", Font.PLAIN, 54));
		lblArrecadacao.setBounds(425, 31, 429, 56);
		panel_arrecadacao.add(lblArrecadacao);
		panel_arrecadacao.setBackground(new Color(239, 156, 166));
		
		txtArrecadacao = new JTextField();
		txtArrecadacao.setHorizontalAlignment(SwingConstants.CENTER);
		txtArrecadacao.setFont(new Font("Verdana", Font.PLAIN, 25));
		txtArrecadacao.setBounds(403, 276, 269, 40);
		panel_arrecadacao.add(txtArrecadacao);
		txtArrecadacao.setColumns(10);
		
		final JLabel lblMostrarTotal = new JLabel("New label");
		lblMostrarTotal.setBounds(403, 338, 350, 56);
		lblMostrarTotal.setFont(new Font("Verdana", Font.PLAIN, 25));
		lblMostrarTotal.setText("O valor total \u00E9: ");
		panel_arrecadacao.add(lblMostrarTotal);
		
		JButton btnArrecadacaoOk = new JButton("OK");
		btnArrecadacaoOk.setBounds(681, 276, 72, 43);
		panel_arrecadacao.add(btnArrecadacaoOk);
		
		JLabel lblDigiteAData = new JLabel("Digite a data para gerar a Arrecada\u00E7ao:");
		lblDigiteAData.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDigiteAData.setBounds(403, 126, 350, 39);
		panel_arrecadacao.add(lblDigiteAData);
		
		JLabel lblFormatoDdmmaaaa = new JLabel("(formato: aaaa/mm/dd)");
		lblFormatoDdmmaaaa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFormatoDdmmaaaa.setBounds(460, 163, 350, 39);
		panel_arrecadacao.add(lblFormatoDdmmaaaa);
		
		final JCheckBox chckbxHoje = new JCheckBox("Hoje?");
		
		chckbxHoje.setFont(new Font("Tahoma", Font.BOLD, 18));
		chckbxHoje.setBackground(new Color(239, 156, 166));
		chckbxHoje.setBounds(503, 211, 119, 40);
		panel_arrecadacao.add(chckbxHoje);
		
		chckbxHoje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(chckbxHoje.isSelected()) {
					LocalDate hoje = LocalDate.now();
					txtArrecadacao.setText(hoje.getDayOfMonth() + "/" + hoje.getMonthValue() + "/" + hoje.getYear());
				}
			}
		});
		
		btnArrecadacaoOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data = txtArrecadacao.getText();
				String dataArr[] = data.split("/");
				LocalDate dataPesquisa = LocalDate.of(Integer.parseInt(dataArr[2]), Integer.parseInt(dataArr[1]), Integer.parseInt(dataArr[0]));
				double valor = Fachada.calcularArrecadacao(dataPesquisa);
				lblMostrarTotal.setText("O valor total é: R$" + valor);
			}
		});

		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		//CLIENTE
		//panel_clientes
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Ubuntu Mono", Font.PLAIN, 54));
		lblClientes.setBounds(425, 31, 429, 56);
		panel_clientes.add(lblClientes);
		panel_clientes.setBackground(new Color(239, 156, 166));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblNome.setBounds(102, 242, 76, 31);
		panel_clientes.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblEmail.setBounds(90, 342, 76, 31);
		panel_clientes.add(lblEmail);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblEndereo.setBounds(69, 441, 97, 31);
		panel_clientes.add(lblEndereo);
		
		JLabel lblTelefone = new JLabel("telefone:");
		lblTelefone.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblTelefone.setBounds(75, 548, 101, 31);
		panel_clientes.add(lblTelefone);
		
		txt_cad_cli_ender = new JTextField();
		txt_cad_cli_ender.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_cad_cli_ender.setEnabled(false);
		txt_cad_cli_ender.setColumns(10);
		txt_cad_cli_ender.setBounds(169, 441, 282, 35);
		panel_clientes.add(txt_cad_cli_ender);
		
		txt_cad_cli_telefone = new JTextField();
		txt_cad_cli_telefone.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_cad_cli_telefone.setEnabled(false);
		txt_cad_cli_telefone.setColumns(10);
		txt_cad_cli_telefone.setBounds(169, 548, 282, 35);
		panel_clientes.add(txt_cad_cli_telefone);
		
		txt_cad_cli_nome = new JTextField();
		txt_cad_cli_nome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_cad_cli_nome.setEnabled(false);
		txt_cad_cli_nome.setBounds(171, 238, 282, 35);
		panel_clientes.add(txt_cad_cli_nome);
		txt_cad_cli_nome.setColumns(10);
		
		txt_cad_cli_email = new JTextField();
		txt_cad_cli_email.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_cad_cli_email.setEnabled(false);
		txt_cad_cli_email.setColumns(10);
		txt_cad_cli_email.setBounds(169, 338, 282, 35);
		panel_clientes.add(txt_cad_cli_email);
		
		final JButton btn_cadastrar_cliente = new JButton("Salvar");
		btn_cadastrar_cliente.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		
		btn_cadastrar_cliente.setEnabled(false);
		btn_cadastrar_cliente.setBounds(175, 637, 276, 56);
		panel_clientes.add(btn_cadastrar_cliente);
		
		final JTextArea txtArea_cliente = new JTextArea();
		txtArea_cliente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtArea_cliente.setEditable(false);
		txtArea_cliente.setBounds(534, 238, 487, 592);
		panel_clientes.add(txtArea_cliente);
		
		JButton btn_clientes_cadastrar = new JButton("Cadastrar");
		
		btn_clientes_cadastrar.setForeground(Color.BLACK);
		btn_clientes_cadastrar.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btn_clientes_cadastrar.setFocusPainted(false);
		btn_clientes_cadastrar.setContentAreaFilled(false);
		btn_clientes_cadastrar.setBounds(169, 105, 259, 65);
		panel_clientes.add(btn_clientes_cadastrar);
		
		JButton btnListar_1 = new JButton("Listar");
		
		btnListar_1.setForeground(Color.BLACK);
		btnListar_1.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnListar_1.setContentAreaFilled(false);
		btnListar_1.setBounds(666, 105, 259, 65);
		panel_clientes.add(btnListar_1);
		
		btn_clientes_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_cad_cli_nome.setEnabled(true);
				txt_cad_cli_telefone.setEnabled(true);
				txt_cad_cli_ender.setEnabled(true);
				txt_cad_cli_email.setEnabled(true);
				btn_cadastrar_cliente.setEnabled(true);
			}
		});
		
		btnListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clien = "";
				TreeMap<String, Cliente> c = new TreeMap<String,Cliente>();
				c = Fachada.listarClientes();
				
				for(Cliente cli : c.values()) {
					clien += cli.getNome() + " tem " + cli.getTotalPedidos() + " pedido(s)." + "\n";
				}
				txtArea_cliente.setText(clien);
			}
		});
		
		btn_cadastrar_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cadNome = txt_cad_cli_nome.getText();
				String cadEmail = txt_cad_cli_email.getText();
				String cadEndereco = txt_cad_cli_ender.getText();
				String cadTelefone = txt_cad_cli_telefone.getText();
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
		lblProdutos.setFont(new Font("Ubuntu Mono", Font.PLAIN, 54));
		lblProdutos.setBounds(425, 31, 429, 56);
		panel_produtos.add(lblProdutos);
		panel_produtos.setBackground(new Color(239, 156, 166));
		
		JLabel lblNomeProd = new JLabel("Nome:");
		lblNomeProd.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblNomeProd.setBounds(135, 204, 76, 31);
		panel_produtos.add(lblNomeProd);
		
		JLabel lblPrecoProd = new JLabel("Preço:");
		lblPrecoProd.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblPrecoProd.setBounds(125, 270, 76, 31);
		panel_produtos.add(lblPrecoProd);
		
		final JTextField txt_cad_prod_nome = new JTextField();
		txt_cad_prod_nome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_cad_prod_nome.setEnabled(false);
		txt_cad_prod_nome.setBounds(213, 199, 241, 35);
		panel_produtos.add(txt_cad_prod_nome);
		txt_cad_prod_nome.setColumns(10);
				
		final JTextField txt_cad_prod_preco = new JTextField();
		txt_cad_prod_preco.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt_cad_prod_preco.setEnabled(false);
		txt_cad_prod_preco.setColumns(10);
		txt_cad_prod_preco.setBounds(213, 265, 241, 35);
		panel_produtos.add(txt_cad_prod_preco);
		
		final JButton btn_cadastrar_produto = new JButton("Salvar");
		btn_cadastrar_produto.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		
		btn_cadastrar_produto.setEnabled(false);
		btn_cadastrar_produto.setBounds(213, 336, 241, 56);
		panel_produtos.add(btn_cadastrar_produto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(526, 231, 522, 563);
		panel_produtos.add(scrollPane);
		
		final JTextArea txtArea_produto = new JTextArea();
		scrollPane.setViewportView(txtArea_produto);
		txtArea_produto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtArea_produto.setEditable(false);
		
		filtrar_prod = new JTextField();
		filtrar_prod.setFont(new Font("Tahoma", Font.PLAIN, 24));
		filtrar_prod.setEnabled(false);
		filtrar_prod.setColumns(10);
		filtrar_prod.setBounds(674, 183, 280, 35);
		panel_produtos.add(filtrar_prod);
		
		JLabel lblFiltrarPorNome = new JLabel("Filtrar nome:");
		lblFiltrarPorNome.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblFiltrarPorNome.setBounds(526, 188, 136, 31);
		panel_produtos.add(lblFiltrarPorNome);
		
		final JButton btn_filtrar_prod_Ok = new JButton("OK");
		btn_filtrar_prod_Ok.setBounds(966, 183, 69, 35);
		panel_produtos.add(btn_filtrar_prod_Ok);
		
		JButton btn_prod_cad = new JButton("Cadastrar");
		
		btn_prod_cad.setForeground(Color.BLACK);
		btn_prod_cad.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btn_prod_cad.setFocusPainted(false);
		btn_prod_cad.setContentAreaFilled(false);
		btn_prod_cad.setBounds(169, 105, 259, 65);
		panel_produtos.add(btn_prod_cad);
		
		JButton btn_prod_list = new JButton("Listar");
		
		btn_prod_list.setForeground(Color.BLACK);
		btn_prod_list.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btn_prod_list.setContentAreaFilled(false);
		btn_prod_list.setBounds(666, 105, 259, 65);
		panel_produtos.add(btn_prod_list);
		
		JButton btnCadastrarCombo = new JButton("Cadastrar Combo:");
		btnCadastrarCombo.setForeground(Color.BLACK);
		btnCadastrarCombo.setFont(new Font("Ubuntu Mono", Font.PLAIN, 35));
		btnCadastrarCombo.setFocusPainted(false);
		btnCadastrarCombo.setContentAreaFilled(false);
		btnCadastrarCombo.setBounds(85, 429, 429, 65);
		panel_produtos.add(btnCadastrarCombo);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		label_1.setBounds(135, 506, 76, 31);
		panel_produtos.add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(213, 501, 241, 35);
		panel_produtos.add(textField);
		
		JLabel lblIdsDosProdutos = new JLabel("Ids dos produtos:");
		lblIdsDosProdutos.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblIdsDosProdutos.setBounds(25, 570, 186, 31);
		panel_produtos.add(lblIdsDosProdutos);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(213, 565, 241, 35);
		panel_produtos.add(textField_1);
		
		JLabel lblInserirCadaId = new JLabel("Inserir cada ID separado por virgula");
		lblInserirCadaId.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		lblInserirCadaId.setBounds(25, 597, 403, 31);
		panel_produtos.add(lblInserirCadaId);
		
		final JButton button = new JButton("Salvar");
		button.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		button.setEnabled(false);
		button.setBounds(213, 641, 241, 56);
		panel_produtos.add(button);
		
		btn_prod_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrar_prod.setEnabled(true);
				
				btn_filtrar_prod_Ok.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String produ = "";
						String nomeProdu = filtrar_prod.getText();
						ArrayList<Produto> p = new ArrayList<Produto>();
						
						if(!nomeProdu.equals("")) {
							p = Fachada.listarProdutos(nomeProdu);
							if(p.size() == 0) {
								p = Fachada.listarProdutos();
							}
						}else {
							p = Fachada.listarProdutos();
						}
						
						DecimalFormat numberFormat = new DecimalFormat("#.00"); 
						for(Produto prd : p) {
							if(prd instanceof Combo) {
								produ += prd.getId() + ":" + prd + " valor " + numberFormat.format(prd.getPreco()) + "\n";
							}else {
								produ += prd.getId() + ":" + prd.getNome() + " valor " + prd.getPreco() + "\n";
							}
						}
						txtArea_produto.setText(produ);
					}
					});
			}
		});
		
		btn_prod_cad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_cad_prod_preco.setEnabled(true);
				txt_cad_prod_nome.setEnabled(true);
				btn_cadastrar_produto.setEnabled(true);
			}
		});
		
		btnCadastrarCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
				textField_1.setEnabled(true);
				button.setEnabled(true);
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
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cadNome = textField.getText();
				String[] ids = textField_1.getText().split(",");
				List<Integer> idArr = new ArrayList<>();
				
				for(String i : ids) {
					idArr.add(Integer.parseInt(i));
				}
				
				try {
					Produto c = Fachada.criarCombo(cadNome, idArr);
					txtArea_produto.setText("Combo Criado com Sucesso: " + c.getId() + " " + c.getNome());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					txtArea_produto.setText(e.getMessage());
				}
				
			}
		});

	}
}
