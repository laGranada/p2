package loesungen;

/**
 * This song class represents a simple song
 * 
 * @author Stephi
 * @version 1.1
 * 
 * last modified: 15.4.2016
 *
 */
public class Song {

	private String title;
	private int seconds;
	
	/**
	 * This constructor creates an song object with a song title and a duration in seconds
	 * @param title is the name of the song.
	 * @param seconds is the duration of the song.
	 */
	public Song(String title, int seconds) {
		this.seconds = seconds;
		this.title = title;
	}
	
	

	/**
	 * This method returns the name of the song.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}



	/**
	 * This method returns the duration of the song.
	 * 
	 * @return the seconds
	 */
	public int getSeconds() {
		return seconds;
	}


	@Override
	public String toString() {
		return title + "(" + seconds + "s)";
	}
	
}
