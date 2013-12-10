package springmvcdemo.model;

import java.util.List;

public class Student {
	private String id;
	private String address;
	private String name;  
    private List<String> books;
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getBooks() {
		return this.books;
	}
	public void setBooks(List<String> books) {
		this.books = books;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
	
    
}
