package assets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

public class pdf {
	private static int idordem = 0;
	//public static void main(String[] args)f {
	public static void pdfCreate(ArrayList<Pedido> p) {
		
		Document document = new Document();
		try {
			
			
			for(Pedido pe : p) {
				if(!pe.isFechado()) {
					Cliente c = pe.getCliente();
					ArrayList<Produto> produtos = new ArrayList<Produto>();
					produtos = pe.getProdutos();
					idordem++;
					
					PdfWriter.getInstance(document, new FileOutputStream("pdf//"+c.getNome()+".pdf"));
					document.setPageSize(PageSize.A4);
					document.addSubject("Testando San criação de PDF em Java com api Itext");
					document.addKeywords("123"); //senha
					document.addCreator("iText");
					document.addAuthor("Joseph Adrian Almeida dos Santos");

					document.open();
					document.add(new Paragraph("The Javai Comida Hamburgueria"));
					document.add(new Paragraph("Avenida Rui Carneiro, 555"));
					document.add(new Paragraph("João Pessoa, PB 51525-432"));
					document.add(new Paragraph("83-9-9511-1234"));
					DateTimeFormatter formatador3 = DateTimeFormatter.ofPattern("dd/MM/yyyy ' - ' HH:mm:ss");
					
					document.add(new Paragraph(pe.getData().format(formatador3) + "\t \t \t \t Numero do pedido: " + idordem));
					document.add(new Paragraph("Quantidade" + " \t \t \t " + "Preço"));	
					document.add(new Paragraph("----------------------------------------------------------"));
					
					for(Produto prod : produtos) {
						document.add(new Paragraph(prod.getNome() + " \t \t R$" + prod.getPreco()));
						document.add(new Paragraph("----------------------------------------------------------"));
					}
					
					document.add(new Paragraph("Valor Total do Pedido: " + pe.getTotal()));
				}
			}

			//Para inserir uma imagem em um documento pdf, 
			//temos que utilizar getInstance na imagem que você deseja adicionar, 
			//passando como parâmetro o seu caminho (path) e depois adicionar no seu documento com o uso do método add(), 
			//como segue abaixo:


			//adcionando uma imagem ao arquivo
			//Image imagem = Image.getInstance("imagens_Itext//lobo.jpg");

			//Setando o tamanho da imagem
			//imagem.scaleToFit(300, 200);

			//Adicionando a imagem ao documento
			//document.add(imagem);

			//É possível também adicionar mais páginas para o nosso arquivo pdf, que até agora com possui somente uma página. 
			//Essa tarefa é bem simples, basta adicionar um newPage no nosso objeto PDF.
			//Criando uma nova página no arquivo PDF
			//document.newPage();

			//document.add(new Paragraph("OUTRA PÁGINA CRIADA COM SUCESSO"));
			//document.add(imagem);

			document.close();

			//Se arquivo for criado com sucesso, é exibida uma mensagem de confirmação
			System.out.println("PDF criado com sucesso!");
		}
		catch(DocumentException de) {         
			System.out.println(de.getMessage());
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		document.close();
	}   
}

