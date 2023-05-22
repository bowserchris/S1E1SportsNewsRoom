package n3e1NewsSports;

public class Football extends News {

	{
		System.out.println("The news article for football is being created.");		// avisa que crea un objeto noticias
	}
	
	private String category;
	
	public Football(String headline, String game, String club, String player) {
		super(headline, 5, 300);
		this.game = game;
		this.club = club;
		this.player = player;
		this.category = "football";
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void calculateNewsPrice() {						//metodo que calcula precio
		int newsPrice = price;
		String league = "champions";
		String footballClub1 = "barca";
		String footballClub2 = "madrid";
		String footballPlayer1 = "ferran torres";
		String footballPlayer2 = "benzema";
		if (league.equalsIgnoreCase(game)) {
			newsPrice += 100;
		}
		
		if (footballClub1.equalsIgnoreCase(club) || footballClub2.equalsIgnoreCase(club)) {
			newsPrice += 100;
		}
		
		if (footballPlayer1.equalsIgnoreCase(player) || footballPlayer2.equalsIgnoreCase(player)) {
			newsPrice += 50;
		}
		System.out.println("The price for the article is " + newsPrice + "€.\r");
	}
	
	public void calculateRating() {					//metodo que calcula rating
		int totalRating = rating;
		String league1 = "champions";
		String league2= "league";
		String footballClub1 = "barca";
		String footballClub2 = "madrid";
		String footballPlayer1 = "ferran torres";
		String footballPlayer2 = "benzema";
		
		if (league1.equalsIgnoreCase(game)) {
			totalRating += 3;
		}
		
		if (league2.equalsIgnoreCase(game)) {
			totalRating += 2;
		}
		
		if (footballClub1.equalsIgnoreCase(club) || footballClub2.equalsIgnoreCase(club)) {
			totalRating += 1;
		}
		
		if (footballPlayer1.equalsIgnoreCase(player) || footballPlayer2.equalsIgnoreCase(player)) {
			totalRating += 1;
		}
		System.out.println("The rating for the article is " + totalRating + ".\r");
	}
	
	public String toString() {
		return super.toString() + "The game being covered in this article is " + game + ".\r"
				+ "The football club in this article is " + club + ".\r"
				+ "The player mentioned in this article is " + player + ".\r"
				+ "The category of the news for the article is: " + category;
	}
}
