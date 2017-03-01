
public class Uncovered {
	private int SpaceNo;
	
	
	/**
	 * Initialize the movie parameters.
	 * @param title
	 * @param year
	 * @param length
	 * @param genre
	 * @param studioName
	 * @throws IllegalArgumentException if title or genre or studio name are null or empty,
	 * length <= 0, year < 1920.
	 */
	public Uncovered(int SpaceNo) {
		this.SpaceNo = SpaceNo;
	}
	
	/**
	 * Returns the genre of the movie.
	 * @return genre
	 */
	public int getSpaceNo()
	{
		return SpaceNo;
	}
}
