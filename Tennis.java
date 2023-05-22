package n3e1NewsSports;

public class Tennis extends News{
	
	{
		System.out.println("The news article for tennis is being created.");		// avisa que crea un objeto noticias
	}
	
	private String category;
	
	public Tennis(String headline, String game, String player) {
		super(headline, 4, 150);
		this.game = game;
		this.player = player;
		this.category = "tennis";
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void calculateNewsPrice() {									//metodo que calcula precio
		int newsPrice = price;
		String player1 = "federer";
		String player2 = "nadal";
		String player3 = "djokovic";
		
		if (player1.equalsIgnoreCase(player) || player2.equalsIgnoreCase(player) || player3.equalsIgnoreCase(player)) {
			newsPrice += 100;
		}
		
		System.out.println("The price for the article is " + newsPrice + "€.\r");
	}
	
	public void calculateRating() {									//metodo que calcula rating
		int totalRating = rating;
		String player1 = "federer";
		String player2 = "nadal";
		String player3 = "djokovic";
		
		if (player1.equalsIgnoreCase(player) || player2.equalsIgnoreCase(player) || player3.equalsIgnoreCase(player)) {
			totalRating += 3;
		}
		
		System.out.println("The rating for the article is " + totalRating + ".\r");
		
	}
	
	public String toString() {
		return super.toString() + "The game being covered in this article is" + game + ".\r"
				+ "The player mentioned in this article is " + player + ".\r"
				+ "The category of the news for the article is: " + category;
	}

}
