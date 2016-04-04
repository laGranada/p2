package loesungen;

public class Song {

	private String title;
	private int seconds;
	
	public Song(String title, int seconds) {
		this.seconds = seconds;
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	public int getSeconds() {
		return seconds;
	}
	

	@Override
	public String toString() {

		return title + "(" + seconds + "s)";
	}
	
}
