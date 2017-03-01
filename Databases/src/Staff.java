/*
 * updateable
 */
public class Staff {
	private String LicPlateNo;
	private int StaffNo;
	private int PhoneExt;
	
	
	/**
	 * Initialize the movie parameters.
	 * @param title
	 * @param StaffNo
	 * @param PhoneExt
	 * @param genre
	 * @param studioName
	 * @throws IllegalArgumentException if title or genre or studio name are null or empty,
	 * PhoneExt <= 0, StaffNo < 1920.
	 */
	public Staff(String LicPlateNo, int PhoneExt, int StaffNo) {
		setLicPlateNo(LicPlateNo);
		setStaffNo(StaffNo);
		setPhoneExt(PhoneExt);
	}

	/**
	 * Returns the title of the movie.
	 * @return movie title
	 */
	public String getLicPlateNo()
	{
		return LicPlateNo;
	}
	
	/**
	 * Modifies the title of the movie.
	 * @param title
	 * @throws IllegalArgumentException if title is null or empty.
	 */
	public void setLicPlateNo(String LicPlateNo)
	{
		if (LicPlateNo == null || LicPlateNo.length() == 0 )
			throw new IllegalArgumentException("Please supply a valid title.");
		this.LicPlateNo = LicPlateNo;
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
		if (StaffNo < 1920)
			throw new IllegalArgumentException("Movie StaffNo cannot be before 1920.");
		this.StaffNo = StaffNo;
	}
	
	/**
	 * Returns the PhoneExt of the movie.
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
		if (PhoneExt <= 0)
			throw new IllegalArgumentException("Movie PhoneExt cannot be negative or 0.");
		
		this.PhoneExt = PhoneExt;
	}
}
