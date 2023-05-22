package n3e1NewsSports;

import java.util.ArrayList;

public class Editor {
	
	{
		System.out.println("The editor is being created.");
	}
	
	
	
	protected String name;
	protected final int id;								//se asigna id al principio y no se cambia
	protected int salary;
	private ArrayList<News> newsList;					//un editor puede tener varios articulos
	
	public Editor(String name, int id) {
		this.name = name;
		this.id = id;
		this.salary = 1500;								//todos empiezan con 1500 como salario
		this.newsList = new ArrayList<News>();			//objeto de arrayslist de noticias para cada editor
	}

	public String getName() {
		return name;
	}
	
	public int getID() {
		return id;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public ArrayList<News> getNewsList(){
		return newsList;
	}
	
	public void setName(String name, int id) {
		this.name = name;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void setNewsList(ArrayList<News> news) {
		this.newsList = news;
	}
	
	public int searchNews(String headline) {		////buscar las noticias que tiene un editor por el titulo de la noticia 
		int counter = 0;
		int index = -1;
		while (!newsList.get(counter).getHeadline().equalsIgnoreCase(headline) && counter < newsList.size()) {
			counter++;
		} if (newsList.get(counter).getHeadline().equalsIgnoreCase(headline)) {
			index = counter;
		}
		return index;
	}
	
	public ArrayList<News> addNews(News news) {	///añadir articulo a lista de articulos	
		newsList.add(news);
		return newsList;
	}
	
	public void deleteNews(String headline) {							//busca la noticia para borrar, lo guarda para enseñarlo y luego lo quita del arraylist
		int index = searchNews(headline);
		if (index != -1) {
			String deletedHeadline = newsList.get(index).getHeadline();
			newsList.remove(index);
			System.out.println("The article " + deletedHeadline + " has been deleted.\r");
		} else {
			System.out.println("The news article wasn´t found in the registry.\r");
		}
	}
	
	public void printNewsList() {					////imprime todas las noticias que tiene un editor
		for (int index = 0; index < newsList.size(); index++) {
			System.out.println(newsList.get(index));
		}
	}
		
	public String toString() {
		return "The name of the editor is: " + name + ".\r"
				+ "Their id number is:" + id + ".\r"
				+ "Their salary is:" + salary + ".\r";
	}

}
