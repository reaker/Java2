package zad3;

/** Klasa encji reprezentująca książkę zgodnie z wymaganiami treści zadania.
 * 
 * @author Sebastian Wijas
 *
 */
public class Book {

	private String author;
	private String title;
	private double price;
	
	
	/** Konstruktor tworzący
	 * @param author autor
	 * @param title tutył książki
	 * @param price cena książki
	 */
	public Book(String author, String title, double price) {
		super();
		this.author = author;
		this.title = title;
		this.price = price;
	}
	
	public Book() {
		super();
		this.author="";
		this.title="";
		this.price=0;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}