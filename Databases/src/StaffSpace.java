/**
 * A class that represents a staff space
 * @author Josiah Hopkins, Devin Durham
 */

public class StaffSpace {
	private int StaffNo;
	private int SpaceNo;
	
	
	/**
	 * Initialize the staff space parameters.
	 * @param StaffNo
	 * @param SpaceNo
	 * SpaceNo, StaffNo < 1.
	 */
	public StaffSpace(int StaffNo, int SpaceNo) {
		setStaffNo(StaffNo);
		setSpaceNo(SpaceNo);
	}
	
	/**
	 * Returns the StaffNo.
	 * @return StaffNo
	 */
	public int getStaffNo()
	{
		return StaffNo;
	}

	/**
	 * Sets the StaffNo.
	 * @param StaffNo
	 * @throws IllegalArgumentException if StaffNo is  < 1. 
	 */
	private void setStaffNo(int StaffNo)
	{

		if (StaffNo < 1)
			throw new IllegalArgumentException("StaffNo Can't be < 1");
		this.StaffNo = StaffNo;
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
	 * @throws IllegalArgumentException if SpaceNo is  < 1. 
	 */
	private void setSpaceNo(int SpaceNo){

		if (SpaceNo < 1)
			throw new IllegalArgumentException("SpaceNo Can't be < 1");
		this.SpaceNo = SpaceNo;
	}
}
