/**
 * A class that represents a staff
 * @author Josiah Hopkins, Devin Durham
 */

public class Staff {
	private String LicPlateNo;
	private int StaffNo;
	private int PhoneExt;
	
	
	/**
	 * Initialize the staff parameters.
	 * @param LicPlateNo
	 * @param StaffNo
	 * @param PhoneExt
	 * @throws IllegalArgumentException if License number is null or empty,
	 * PhoneExt < 1, StaffNo < 1.
	 */
	public Staff(String LicPlateNo, int PhoneExt, int StaffNo) {
		setLicPlateNo(LicPlateNo);
		setStaffNo(StaffNo);
		setPhoneExt(PhoneExt);
	}

	/**
	 * Returns the LicensePlate.
	 * @return license plate
	 */
	public String getLicPlateNo()
	{
		return LicPlateNo;
	}
	
	/**
	 * Modifies the license plate.
	 * @param title
	 * @throws IllegalArgumentException if title is null or empty.
	 */
	public void setLicPlateNo(String LicPlateNo)
	{
		if (LicPlateNo == null || LicPlateNo.length() == 0 )
			throw new IllegalArgumentException("Please supply a valid license plate.");
		this.LicPlateNo = LicPlateNo;
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
	 * Sets the movie StaffNo.
	 * @param StaffNo
	 * @throws IllegalArgumentException if StaffNo < 1. 
	 */
	private void setStaffNo(int StaffNo)
	{
		if (StaffNo < 1)
			throw new IllegalArgumentException("StaffNo Can't be < 1");
		this.StaffNo = StaffNo;
	}
	
	/**
	 * Returns the PhoneExt.
	 * @return PhoneExt
	 */
	public int getPhoneExt()
	{
		return PhoneExt;
	}
	
	/**
	 * Modifies the PhoneExt of the movie.
	 * @param PhoneExt
	 * @throws IllegalArgumentException if PhoneExt is negative or 0.
	 */
	public void setPhoneExt(int PhoneExt)
	{
		if (PhoneExt < 1)
			throw new IllegalArgumentException(" PhoneExt cannot be < 1.");
		
		this.PhoneExt = PhoneExt;
	}
}
