package agenda;

public class Eventos extends Contato {
	private int duracao;
	private int horario;
	private String tema;
	private String descricao;
	
	//Cria��o do m�todo construtor
	public Eventos(String nome, String endereco, String email, String telefone, String tipo, int duracao, int horario, String tema, String descricao) {
		super(nome,endereco, email, telefone, tipo);
		//Chamada dos atributos exclusivos da classe Evento
		this.duracao = duracao;
		this.horario = horario;
		this.tema = tema;
		this.descricao = descricao;
	}
	
	
	//M�todo para realizarmos o cadastro de um novo evento na agenda - Aguardando aula de Polimorfismo
	@Override
	public void setContato() {
		
	}
	
	//M�todo para exibi��o do evento cadastrado - Aguardando aula de Polimorfismo
	@Override
	public void getContato() {
		
	}
	
	//M�todo para formatar a data. Como receberemos um inteiro, podemos utilizar o m�todo
	//abaixo para formatar e exibir a data em um formato espec�fico.
	//O m�todo pega o valor do atributo 'data' e atrav�s de algumas opera��es
	//atribu�mos, para cada vari�vel (ano, m�s e dia) seu valor conforme a data que foi 
	//informada. Posteriormente, formatamos a data conforme padr�o dd/mm/aaaa.
	/*public String formatarData() {
		int dia, mes, ano;
		ano = data % 10000;
		mes = (data / 10000) % 10;
		dia = (data / 10000) / 100;
		String dataFormatada = String.format("%02d/%02d/%d", dia, mes, ano);
		return dataFormatada;
	}*/
	
	//Getters e Setters do atributos da classe Evento
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
