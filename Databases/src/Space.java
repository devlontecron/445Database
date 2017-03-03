/**
 * A class that represents a space
 * @author Josiah Hopkins, Devin Durham
 */

public class Space {
	private int SpaceNo;
	private String SpaceType;
	
	
	/**
	 * Initialize the space parameters.
	 * @param SpaceType
	 * @param SpaceNo
	 * @throws IllegalArgumentException if SpaceType is null or empty or SpaceNo < 1.
	 */
	public Space(String SpaceType, int SpaceNo) {
		setSpaceType(SpaceType);
		setSpaceNo(SpaceNo);
	}

	/**
	 * Returns the SpaceType.
	 * @return SpaceType
	 */
	public String getSpaceType()
	{
		return SpaceType;
	}
	
	/**
	 * Modifies the SpaceType of the space.
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
	 * Returns the SpaceNo.
	 * @return SpaceNo
	 */
	public int getSpaceNo()
	{
		return SpaceNo;
	}

	/**
	 * Sets the SpaceNo.
	 * @param SpaceNo
	 * @throws IllegalArgumentException if SpaceNo is less than 1. 
	 */
	private void setSpaceNo(int SpaceNo)
	{
		if(SpaceNo < 1){
			throw new IllegalArgumentException("Provide a valid number");
		}
		this.SpaceNo = SpaceNo;
	}
}
