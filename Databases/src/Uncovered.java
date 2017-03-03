/**
 * A class that represents an uncovered space
 * @author Josiah Hopkins, Devin Durham
 */

public class Uncovered {
	private int SpaceNo;
	
	
	/**
	 * Initialize the SpaceNo parameters.
	 * @param SpaceNo
	 * @throws IllegalArgumentException if spaceNo < 1
	 */
	public Uncovered(int SpaceNo) {
		this.SpaceNo = this.setSpaceNo(SpaceNo);
	}
	
	/**
	 * Returns the genre of the movie.
	 * @return genre
	 */
	public int getSpaceNo()
	{
		return SpaceNo;
	}
	
	/**
	 * Modifies the SpaceNo
	 * @param SpaceNo
	 * @throws IllegalArgumentException if SpaceNo < 1.
	 */
	private void setSpaceNo(int SpaceNo)
	{
		if(SpaceNo < 1){
			throw new IllegalArgumentException("SpaceNo can't be less than 1");
		}
		this.SpaceNo = SpaceNo;		
	}
}
