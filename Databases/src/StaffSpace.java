/*
 * updateable
 */
public class StaffSpace {
	private int StaffNo;
	private int SpaceNo;
	
	
	/**
	 * Initialize the movie parameters.
	 * @param title
	 * @param StaffNo
	 * @param SpaceNo
	 * @param genre
	 * @param studioName
	 * @throws IllegalArgumentException if title or genre or studio name are null or empty,
	 * SpaceNo <= 0, StaffNo < 1920.
	 */
	public StaffSpace(int StaffNo, int SpaceNo) {
		setStaffNo(StaffNo);
		setSpaceNo(SpaceNo);
	}
	
	/**
	 * Returns the StaffNo the movie was made.
	 * @return StaffNo
	 */
	public int getStaffNo()
	{
		return StaffNo;
	}
	
	/**
	 * Sets the movie StaffNo.
	 * @param StaffNo
	 * @throws IllegalArgumentException if StaffNo is before 1920. 
	 */
	private void setStaffNo(int StaffNo)
	{
		this.StaffNo = StaffNo;
	}
	
	/**
	 * Returns the SpaceNo of the movie.
	 * @return SpaceNo
	 */
	public int getSpaceNo()
	{
		return SpaceNo;
	}
	
	private void setSpaceNo(int SpaceNo){
		this.SpaceNo = SpaceNo;
	}
}
