package n3e1NewsSports;

public abstract class News {
	
	protected String headline;
	protected String text;
	protected int rating;
	protected int price;
	protected String game;			//lo hereda football, basket y tennis
	protected String club;			//lo hereda football y basket
	protected String player;		//lo hereda football y tennis
	protected String team;			//lo hereda f1 y moto
	protected Editor editor;
	
	public News(String headline, int rating, int price) { //constructor parcial y los otros heredan lo mencionado arriba
		this.headline = headline;
		this.rating = rating;
		this.price = price;
	}
	
	public String getHeadline() {
		return headline;
	}
	public String getText() {
		return text;
	}
	public int getRating() {
		return rating;
	}
	public int getPrice() {
		return price;
	}
	public String getGame() {
		return game;
	}
	public String getClub() {
		return club;
	}
	public String getPlayer() {
		return player;
	}
	public String getTeam() {
		return team;
	}
	
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setGame(String game) {
		this.game = game;
	}
	
	public void setClub(String club) {
		this.club = club;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	public abstract void calculateNewsPrice();			//metodo que heredan otros
	
	public abstract void calculateRating();				//metodo que heredan otros
	
	public String toString() {
		return "The headline of the article is: " + headline + ".\r"
				+ "The text is: " + text +  ".\r"
				+ "The rating for the article is: " + rating +  ".\r"
				+ "The price for the article is: " + price +  ".\r";
				
	}

}
