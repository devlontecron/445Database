/*
 * updateable
 */
public class Space {
	private int SpaceNo;
	private String SpaceType;
	
	
	/**
	 * Initialize the movie parameters.
	 * @param SpaceType
	 * @param SpaceNo
	 * @param length
	 * @param genre
	 * @param studioName
	 * @throws IllegalArgumentException if SpaceType or genre or studio name are null or empty,
	 * length <= 0, SpaceNo < 1920.
	 */
	public Space(String SpaceType, int SpaceNo) {
		setSpaceType(SpaceType);
		setSpaceNo(SpaceNo);
	}

	/**
	 * Returns the SpaceType of the movie.
	 * @return movie SpaceType
	 */
	public String getSpaceType()
	{
		return SpaceType;
	}
	
	/**
	 * Modifies the SpaceType of the movie.
	 * @param SpaceType
	 * @throws IllegalArgumentException if SpaceType is null or empty.
	 */
	private void setSpaceType(String SpaceType)
	{
		if (SpaceType == null || SpaceType.length() == 0 )
			throw new IllegalArgumentException("Please supply a valid SpaceType.");
		this.SpaceType = SpaceType;
	}
	
	/**
	 * Returns the SpaceNo the movie was made.
	 * @return SpaceNo
	 */
	public int getSpaceNo()
	{
		return SpaceNo;
	}
	
	/**
	 * Sets the movie SpaceNo.
	 * @param SpaceNo
	 * @throws IllegalArgumentException if SpaceNo is before 1920. 
	 */
	private void setSpaceNo(int SpaceNo)
	{
		this.SpaceNo = SpaceNo;
	}
}
