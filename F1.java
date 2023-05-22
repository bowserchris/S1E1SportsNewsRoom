package n3e1NewsSports;

public class F1 extends News {
	
	{
		System.out.println("The news article for F1 is being created.");				// avisa que crea un objeto moto noticias
	}
	
	private String category;
	
	public F1(String headline, String team) {
		super(headline, 4, 100);
		this.team = team;
		this.category = "f1";
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void calculateNewsPrice() {											//metodo que calcula precio
		int newsPrice = price;
		String team1 = "ferrari";
		String team2 = "mercedes";
		
		if (team1.equalsIgnoreCase(team) || team2.equalsIgnoreCase(team)) {
			newsPrice += 50;
		}
		
		System.out.println("The price for the article is " + newsPrice + "€.\r");
	}
	
	public void calculateRating() {										//metodo que calcula rating
		int totalRating = rating;
		String team1 = "ferrari";
		String team2 = "mercedes";
		
		if (team1.equalsIgnoreCase(team) || team2.equalsIgnoreCase(team)) {
			totalRating += 2;
		}
		
		System.out.println("The rating for the article is " + totalRating + ".\r");
		
	}
	
	public String toString() {
		return super.toString() + "The team being covered in this article is" + team + ".\r"
				+ "The category of the news for the article is: " + category;
	}

}
