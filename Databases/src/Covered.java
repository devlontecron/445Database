/**
 * A class that represents a covered space
 * @author Josiah Hopkins, Devin Durham
 */

public class Covered {
	private int SpaceNo;
	private double MonthlyRate;
	
	
	/**
	 * Initialize the covered space parameters.
	 * @param monthlyRate
	 * @param SpaceNo
	 * @throws IllegalArgumentException if montlyRate < 0, spaceNo < 1.
	 */
	public Covered(int SpaceNo, double monthlyRate) {
		this.SpaceNo = this.setSpaceNo(SpaceNo);;
		this.MonthlyRate = this.setMonthlyRate(monthlyRate);;
	}
	
	/**
	 * Returns the space number.
	 * @return genre
	 */
	public int getSpaceNo()
	{
		return SpaceNo;
	}
	
	public double getMonthlyRate(){
		return this.MonthlyRate;
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
	

	/**
	 * Sets the monthly rate.
	 * @param monthlyRate
	 * @throws IllegalArgumentException if SpaceNo is less than 0. 
	 */
	private void setMonthlyRate(int monthlyRate)
	{
		if(SpaceNo < 0){
			throw new IllegalArgumentException("Provide a valid number");
		}
		this.MonthlyRate = monthlyRate;
	}
}
