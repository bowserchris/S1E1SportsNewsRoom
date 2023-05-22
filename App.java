package n3e1NewsSports;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
	
	public static ArrayList<Editor> editorList = new ArrayList<Editor>();
	
	////////////////////statics para crear objetos
	
	static ArrayList<Editor> createEditor(String name, int id) { 			//crea objeto editor y lo añade al arraylist
		editorList.add(new Editor(name, id));
		return editorList;
	}
	
	static Football createFootball(String headline, String game, String club, String player) {		//crea objeto
		Football football = new Football(headline, game, club, player);
		return football;
	}
	
	static Basketball createBasketball(String headline, String game, String club) {		//crea objeto
		Basketball basketball = new Basketball(headline, game, club);
		return basketball;
	}
	
	static Tennis createTennis(String headline, String game, String player) {		//crea objeto
		Tennis tennis = new Tennis(headline, game, player);
		return tennis;
	}
	
	static F1 createF1(String headline, String team) {		//crea objeto
		F1 f1 = new F1(headline, team);
		return f1;
	}
	
	static Motorcycle createMotorcycle(String headline, String team) {		//crea objeto
		Motorcycle motorcycle = new Motorcycle(headline, team);
		return motorcycle;
	}
	
	
	////////////////empieza el main con menu

	public static void main(String[] args) {
		
		System.out.println("Welcome to Cibernarium Sports News Registry\u2122.\r");
		String userInput;
		boolean exitProgram = false;
				
		do { 
			
			userInput = inputString("What would you like to do next?:\r"		//el menu con las opciones
					+ "1.) Create an Editor\r"
					+ "2.) Delete an existing Editor\r"
					+ "3.) Create a news article by an editor\r"
					+ "4.) Delete a news article\r"
					+ "5.) Show all news article made by an Editor\r"
					+ "6.) Calculate the ratings of the news article\r"
					+ "7.) Calculate the price of the news article\r"
					+ "8.) Exit the program");
			
			switch (userInput) {		//el switch de menu dependiendo del input
			case "1", "create editor": 	// crea un editor y lo añade a la arraylist de editores
				createEditor(inputString("What´s the name of the Editor?"), 
							inputNumber("What´s the ID to be assigned to them?"));			
				break;
			case "2", "delete editor": // busca un editor y lo borra del arraylist
				deleteEditor(inputString("What´s the first name of the editor you wish to remove?")); 
				break;
			case "3", "create news": 	 //busca un editor, pregunta que tipo de noticia y luego crea un articulo y lo añade al arraylist de noticias del editor
				editorList.get(searchEditor(inputString("What´s the name of the editor writing the article?")))
				.addNews(createNews(inputString("What category of news article will you be creating?\r "
						+ "e.g. football, basketball, tennis, F1 or motorcycle?")));
				break;
			case "4", "delete news":	/// verifica que existe un editor y luego busca el titulo en su arraylist de noticias
				verifyEditor(inputString("What´s the name of the editor of the article you wish to delete?")); 
				break;
			case "5", "show news":		//busca un editor y imprime los titulos de los articulos relacionados a el
				editorList.get(searchEditor(inputString("What´s the name of the editor of the articles you´d like to see?"))).printNewsList(); 
				break;
			case "6", "ratings":
				/*para entender la logica lo hice en etapas aqui para ver los pasos y no perder el hilo. 
				 * para llegar a calcular precio, intentare ponerlo todo en una linea (caja dentro de caja dentro de otra caja)
				///1.) editorIndex para buscar el editor y tener su indice
				 * 2.) editorNewsIndex es el indice de la noticia dentro del editor y guardarlo a una variable
				 * 3.) de ahi directamente de la lista array de editores con su indice busco el editor y luego con el indice de la noticia la busco ahi
				 * 4.) y finalmente adjunto el metodo .calculateRating();	*/
				int editorRatingIndex = searchEditor(inputString("What´s the name of the editor for the rating of the article you´d like to see?"));
				int editorRatingNewsIndex = editorList.get(editorRatingIndex).searchNews(inputString("What´s the title of the news article you wish to see the rating for?"));
				editorList.get(editorRatingIndex).getNewsList().get(editorRatingNewsIndex).calculateRating();
				break;
			case "7", "price":	///no me salia todo en uno, asi que volvi a hacerlo como arriba. 
				int editorPriceIndex = searchEditor(inputString("What´s the name of the editor for the rating of the article you´d like to see?"));
				int editorPriceNewsIndex = editorList.get(editorPriceIndex).searchNews(inputString("What´s the title of the news article you wish to see the rating for?"));
				editorList.get(editorPriceIndex).getNewsList().get(editorPriceNewsIndex).calculateNewsPrice();
				//abajo lo intente todo en una linea pero no me funcionaba
				/*editorList.get(searchEditor(inputString("What´s the name of the editor for the price of the article you´d like to see?")))
				.getNewsList().get(editorList.get(searchEditor(inputString("What´s the title of the news article for the price you´d like to see?")))
				.searchNews(inputString("What´s the title of the news article you wish to see the price for?"))).calculateNewsPrice();*/
				break;
			case "8", "exit":	//si no quiere hacer nada mas introduce esto y el programa cierra
				exitProgram = true;
				break;
			default:
				System.out.println("Sorry. That´s not one of the options. Try again.\r");
			}
			
			
		} while (exitProgram == false);		//cuando 8 o exit es selecionado ira aqui y saldra del programa
		
		System.out.println("Thank you for using Cibernarium Sports News Registry\u2122 Services.\r"
				+ "Have a nice day.");
		
	}
		
		
		
		///////////////////// metodos abajo
		
	
	static int inputNumber(String message) {				//request a number input
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		return input.nextInt();
	}
	
	static String inputString(String message) {				//request a string input
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		return input.nextLine();
	}
	
	static int searchEditor(String name) {	 				//buscar a un editor por su nombre y devuelve indice en array
		int counter = 0;
		int index = -1;
		while (!editorList.get(counter).getName().equalsIgnoreCase(name) && counter < editorList.size()) {
			counter++;
		} if (editorList.get(counter).getName().equalsIgnoreCase(name)) {
			index = counter;
		}
		return index;
	}
	
	static void deleteEditor(String name) {							//busca la noticia para borrar, lo guarda para enseñarlo y luego lo quita del arraylist
		int index = searchEditor(name);
		if (index != -1) {
			String deletedEditor = editorList.get(index).getName();
			editorList.remove(index);
			System.out.println("The editor " + deletedEditor + " has been removed from the registry.\r");
		} else {
			System.out.println("The editor wasn´t found in the registry.\r");
		}
	}
		
	static void verifyEditor(String name) {						//verifica si el editor existe y luego borra la noticia del arraylist de noticias del editor
		boolean editorExist = false;
		int index = 0;
		while (index < editorList.size() && editorExist == false) {
			if (editorList.get(index).getName().equalsIgnoreCase(name)) {
				editorExist = true;
				break;
			}
			index++;
		}
		if (editorExist) {
			editorList.get(index).deleteNews(inputString("What´s the headline of the article you wish to delete?"));
		} else {
			System.out.println("The editor doesn´t exist in the registry.\r");
		}
				
	}
	
	static News createNews(String type) {						////metodo menu switch donde pregunta por que tipo para crear cada objeto distinto y lo devuelve para añadirlo al arraylist de noticias que tiene el editor
		News news = null;		//me quejaba que posiblemente no se inicializaba, por eso le di valor de null
		boolean exitProgram = false;
		
		do { 
			switch(type) {		//con el string parametro ira al caso correcto y crear un subobjeto de noticias dependiendo de la categoria
			case "football": 																
				news = createFootball(inputString("What´s the title of the article?"), 
							inputString("What league is being covered in the article?"),
							inputString("Which club is being covered in the article?"),
							inputString("What player is being covered in the article?"));
				exitProgram = true;
				break;
			case "basketball":
				news = createBasketball(inputString("What´s the title of the article?"), 
						inputString("What league is being covered in the article?"),
						inputString("Which club is being covered in the article?"));
				exitProgram = true;
				break;
			case "tennis":
				news = createTennis(inputString("What´s the title of the article?"), 
						inputString("What game is being covered in the article?"),
						inputString("Which player is being covered in the article?"));
				exitProgram = true;
				break;
			case "f1":
				news = createF1(inputString("What´s the title of the article?"), 
						inputString("Which team is being covered in the article?"));
				exitProgram = true;
				break;
			case "motorcycle":
				news = createMotorcycle(inputString("What´s the title of the article?"), 
						inputString("Which team is being covered in the article?"));
				exitProgram = true;
				break;
			default:
				System.out.println("That is not one of the options. Try again.");
				break;
			}
		} while (exitProgram == false);
		
		return news;
	}	
	
	static ArrayList<Editor> increaseSalary(int increase) { //// coje el listado de editores, saca cada uno su salario y suma el parametro a ello y lo devuelve al listado
		for (int index = 0; index <= editorList.size(); index++) {
			editorList.get(index).setSalary(editorList.get(index).getSalary() + increase);
		}
		return editorList;
	}

}

/*
In a sports newsroom they have the news classified
 by sports: football, basketball, tennis, F1 and motorcycling.

The newsroom can have more than one editor, and we want to 
know the name, ID and salary of each of them. Once an ID has
 been assigned, it can never be changed. All editors have the
  same salary, and if in the future the company can increase
   it, it will do so to everyone equally. At the moment the 
   current salary is €1500.

Each editor can work on more than one news item. News items 
must have a headline, text, rating and price. At the time of
 creation, the text must be empty.

In addition, from the football news you must know which competition
 it refers to (String), which club (String) and which player (String).

From the basketball news, you must indicate which competition 
it refers to (String) and which club (String).

From the tennis news you have to know which competition(String) 
they are talking about and which tennis players(String).

From the F1 news we need to know which team(String) they refer to.

From the motorcycling news, you must indicate which team (String) they are from.

News is sold to different media. To know the price of each news 
item we must implement a method called calculateNewsPrice().

Here is how to calculate the price of each piece of news:

Football news:

    Initial price: €300

    Champions League: €100

    Barça or Madrid: €100

    Ferran Torres or Benzema: €50
    
Exemple: Una notícia que parla d’un gol de Ferran Torres 
del Barça a la Lliga de Campions, té un preu de 550 €.

Notícies de bàsquet:

    Preu inicial: 250 €

    Eurolliga: 75 €

    Barça o Madrid: 75 €


Notícies de tenis:

    Preu inicial: 150 € 

    Federer, Nadal o Djokovic: 100 €


Notícies d'F1:

    Preu inicial: 100 €

    Ferrari o Mercedes: 50 €


Notícies de motociclisme:

    Preu inicial: 100 €

    Honda o Yamaha: 50 €


Per calcular les puntuacions de les notícies se segueixen els següents criteris:

Notícies de futbol:

    5 Punts.

    Lliga de Campions: 3 punts

    Lliga: 2 punts

    Barça o Madrid: 1 punt

    Ferran Torres o Benzema: 1 punt

Basketball News:

    4 points

    Euroleague: 3 points

    ACB: 2 points

    Barça or Madrid: 1 point


Tennis News:

    4 points

    Federer, Nadal or Djokovic: 3 points


F1 news:

    4 points

    Ferrari or Mercedes: 2 points


Motorcycling News:

    3 points

    Honda or Yamaha: 3 points


In the main class, a menu must be made with the following options:

1.- Enter editor.

2.- Remove editor.

3.- Introduce news to an editor.

4.- Delete news (must request editor and title of the news).

5.- Show all the news by editor.

6.- Calculate the score of the news.

7.- Calculate price-news




*/