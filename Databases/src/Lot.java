/*
 * updateable
 */
public class Lot {
	private int Floors;
	private int Capacity;
	private String LotName, Location;
	
	
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
	public Lot(String LotName, String Location, int floors, int capacity) 
	{
		this.LotName = LotName;
		this.Location = Location;
		this.Floors = floors;
		this.Capacity = capacity;
	}

	/**
	 * Returns the title of the movie.
	 * @return movie title
	 */
	public int getFloors()
	{
		return Floors;
	}
	
	/**
	 * Returns the year the movie was made.
	 * @return year
	 */
	public int getCapacity()
	{
		return Capacity;
	}
	
	/**
	 * Returns the length of the movie.
	 * @return length
	 */
	public String getLocation()
	{
		return Location;
	}
	
	/**
	 * Returns the genre of the movie.
	 * @return genre
	 */
	public String getLotName()
	{
		return LotName;
	}
	
}
