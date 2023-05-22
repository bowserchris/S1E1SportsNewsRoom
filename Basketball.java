package n3e1NewsSports;

public class Basketball extends News {
	
	{
		System.out.println("The news article for basketball is being created.");		// avisa que crea un objeto noticias
	}
	
	private String category;
	
	public Basketball(String headline, String game, String club) {
		super(headline, 4, 250);
		this.game = game;
		this.club = club;
		this.category = "basketball";
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void calculateNewsPrice() {						//metodo que calcula precio
		int newsPrice = price;
		String league = "euro league";
		String basketballClub1 = "barca";
		String basketballClub2 = "madrid";
		
		if (league.equalsIgnoreCase(game)) {
			newsPrice += 75;
		}
		
		if (basketballClub1.equalsIgnoreCase(club) || basketballClub2.equalsIgnoreCase(club)) {
			newsPrice += 75;
		}
		
		System.out.println("The price for the article is " + newsPrice + "€.\r");
	}
	
	public void calculateRating() {						//metodo que calcula rating
		int totalRating = rating;
		String league1 = "acb";
		String league2= "euro league";
		String basketballClub1 = "barca";
		String basketballClub2 = "madrid";
		
		if (league1.equalsIgnoreCase(game)) {
			totalRating += 2;
		}
		
		if (league2.equalsIgnoreCase(game)) {
			totalRating += 3;
		}
		
		if (basketballClub1.equalsIgnoreCase(club) || basketballClub2.equalsIgnoreCase(club)) {
			totalRating += 1;
		}
		
		System.out.println("The rating for the article is " + totalRating + ".\r");
		
	}
	
	public String toString() {
		return super.toString() + "The game being covered in this article is" + game + ".\r"
				+ "The basketball club in this article is " + club + ".\r"
				+ "The category of the news for the article is: " + category;
	}

}
