/**
 * A class that represents a lot
 * @author Josiah Hopkins, Devin Durham
 */

public class Lot {
	private int Floors;
	private int Capacity;
	private String LotName, Location;
	
	
	/**
	 * Initialize the lot parameters.
	 * @param lotname
	 * @param location
	 * @param floors
	 * @param capacity
	 * @throws IllegalArgumentException if location or lot name are null or empty,
	 * floors < 1, capacity < 1.
	 */
	public Lot(String LotName, String Location, int floors, int capacity) 
	{
		this.LotName = this.setLotName(lotName);
		this.Location = this.setLocation(location);
		this.Floors = this.setFloors(floors);
		this.Capacity = this.setCapacity(capacity);
	}

	/**
	 * Returns the number of floors.
	 * @return movie title
	 */
	public int getFloors()
	{
		return Floors;
	}
	
	/**
	 * Returns the capacity.
	 * @return year
	 */
	public int getCapacity()
	{
		return Capacity;
	}
	
	/**
	 * Returns the location.
	 * @return length
	 */
	public String getLocation()
	{
		return Location;
	}
	
	/**
	 * Returns the lot name.
	 * @return genre
	 */
	public String getLotName()
	{
		return LotName;
	}
	

	
	/**
	 * Sets the number of floors.
	 * @param floors
	 * @throws IllegalArgumentException if floors < 1. 
	 */
	private void setFloors(int floors)
	{
		if (floors < 1){
			throw new IllegalArgumentException("Floors cannot be less than 1.");
		}
		this.floors = floors;
	}
	
	/**
	 * Modifies the capacity.
	 * @param SpaceNo
	 * @throws IllegalArgumentException if SpaceNo is negative or 0.
	 */
	private void setCapacity(int capacity)
	{
		if (capacity < 1)
			throw new IllegalArgumentException("Capacity can't be less than 1.");
		
		this.capacity = capacity;
	}
	
	/**
	 * sets the location
	 * @param location
	 * @throws IllegalArgumentException if location is null or empty.
	 */
	private void setLocation(String location)
	{
		if (location == null || location.length() == 0){
			throw new IllegalArgumentException("Please supply a valid location.");
		}
		this.location = location;
	}
	
	/**
	 * Sets the name of the lot. 
	 * @param lotName
	 * @throws IllegalArgumentException if lot name is null or empty.
	 */
	private void setLotName(String lotName)
	{
		if (lotName == null || lotName.length() == 0){
			throw new IllegalArgumentException("Please supply a valid name.");
		}
		this.lotName = lotName;
	}
	
}
