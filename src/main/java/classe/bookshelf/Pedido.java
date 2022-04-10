package classe.bookshelf;

public class Pedido {
	private int id;
	private String nome;
	private String end;
	private String book;
	
	public Pedido(int id, String nome, String end, String book) {
		this.setId(id);
		this.setNome(nome);
		this.setEnd(end);
		this.setBook(book);
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

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

}
