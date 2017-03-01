
public class Covered {
	private int SpaceNo;
	private double MonthlyRate;
	
	
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
	public Covered(int SpaceNo, double monthlyRate) {
		this.SpaceNo = SpaceNo;
		this.MonthlyRate = monthlyRate;
	}
	
	/**
	 * Returns the genre of the movie.
	 * @return genre
	 */
	public int getSpaceNo()
	{
		return SpaceNo;
	}
	
	public double getMonthlyRate(){
		return this.MonthlyRate;
	}
}
