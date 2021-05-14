package agenda;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Eventos extends Contato{
	private int duracao;
	private int horario;
	private int data;
	private String tema;
	private String descricao;
	
	Scanner leia = new Scanner(System.in);
	
	//Cria��o do m�todo construtor
	public Eventos(String nome, String endereco, int duracao, int horario) {
		super(nome, endereco);
	}
	
	
	
	@Override
	public void setContato() {
		//Cadastrar
		System.out.println("Informe os dados que deseja cadastrar:");
		System.out.println("Qual o nome do evento?");
		setNome(leia.nextLine());
		System.out.println("Informe uma breve descri��o do evento");
		this.setDescricao(leia.nextLine());
		System.out.println("Qual o endere�o do eventos?");
		setEndereco(leia.nextLine());
		System.out.println("Qual a dura��o, em horas, do eventos?");
		validarInt();
		System.out.println("Qual a data do evento? (ddmmaaaa)");
		this.setData(leia.nextInt());
		//this.setDuracao(leia.nextInt());
		System.out.println("Informe o hor�rio de in�cio do evento (hhmmss):");
		validarHora(leia.nextInt());
		leia.nextLine();
		System.out.println("Qual o tema do evento?");
		this.setTema(leia.nextLine());
	}
	
	@Override
	public void getContato() {
		//Visualizar
		/*System.out.printf("O evento %s acontecera em data, localizado na %s ", getNome(), getEndereco());
		System.out.printf("\no evento tem previs�o de in�cio para as %s com dura��o esperada de %d hora(s).", formatarHora(getHorario()), this.getDuracao());
		System.out.printf("\nLembre-se que '%s' e o tema %s", this.getDescricao(), validarTema(this.getTema()));*/

		System.out.printf("O evento %s acontecer� em %s, localizado na %s ", getNome(), formatarData(this.getData()), getEndereco());
		System.out.printf("\no evento tem previs�o de in�cio para as %s com dura��o esperada de %d hora(s).", formatarHora(getHorario()), this.getDuracao());
		System.out.printf("\nLembre-se que '%s' e %s", this.getDescricao(), validarTema(this.getTema()));

	}
	
	public String validarTema(String tema) {
		String msg;
		if(tema.isBlank() || tema.isEmpty()) msg = "n�o tem tema definido";
		else msg = "o tema � " + tema;
		return msg;
	}
	
	public void validarInt() {
		int i = -1;
		boolean erro = true;
		do
		{
			try
			{
				int numero = leia.nextInt();
				erro = false;
				i = numero;
				
			} catch(InputMismatchException inputMismatchException) {
				System.out.println("\nVoc� deve entrar com um valor do tipo inteiro.\n");
				leia.nextLine();
				
			}
		} while(erro);
		this.setDuracao(i);
	}
	
	public String formatarHora(int horas) {
		int hora, minuto, segundo;
		hora = horas / 10000;
		minuto = (horas % 10000) / 100;
		segundo = (horas % 10000) % 100;
		String horaFormatada = String.format("%02d:%02d:%02d", hora, minuto, segundo);
		return horaFormatada;
	}
	
	public void validarHora(int horas) {
		int temp = horas;
		int hora, minuto, segundo;
		hora = horas / 10000;
		minuto = (horas % 10000) / 100;
		segundo = (horas % 10000) % 100;
		if (hora > 24 || minuto >= 60 || segundo >= 60) {
			System.out.printf("Horario Invalido.\nInforme um horario valido (hh:mm:ss): ");
			validarHora(leia.nextInt());
		} else if (hora == 24 && (minuto > 0 || segundo > 0)) {
			System.out.printf("Horario Invalido.\nInforme um horario valido (hh:mm:ss): ");
			validarHora(leia.nextInt());
		} else {
			this.setHorario(temp);
		}
	}
	
	//M�todo para formatar a data. Como receberemos um inteiro, podemos utilizar o m�todo
	//abaixo para formatar e exibir a data em um formato específico.
	//O método pega o valor do atributo 'data' e atrav�s de algumas opera��es
	//atribumois, para cada variável (ano, m�s e dia) seu valor conforme a data que foi 
	//informada. Posteriormente, formatamos a data conforme padrão dd/mm/aaaa.
	public String formatarData(int d) {
		int dia, mes, ano;
		ano = d % 10000;
		mes = (d / 10000) % 10;
		dia = (d / 10000) / 100;
		String dataFormatada = String.format("%02d/%02d/%d", dia, mes, ano);
		return dataFormatada;
	}
	
	//Getters e Setters dos atributos da classe Evento
	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
