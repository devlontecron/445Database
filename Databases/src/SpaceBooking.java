import java.sql.Date;

public class SpaceBooking {
	private String VisitorLic;
	private int BookingId;
	private int SpaceNo;
	private int StaffNo;
	private Date DateOfVisit;
	
	
	/**
	 * Initialize the movie parameters.
	 * @param VisitorLic
	 * @param BookingId
	 * @param SpaceNo
	 * @param genre
	 * @param studioName
	 * @throws IllegalArgumentException if VisitorLic or genre or studio name are null or empty,
	 * SpaceNo <= 0, BookingId < 1920.
	 */
	public SpaceBooking(String VisitorLic, int BookingId, int SpaceNo, int StaffNo,
			Date DateOfVisit) {
		setVisitorLic(VisitorLic);
		setBookingId(BookingId);
		setSpaceNo(SpaceNo);
		setStaffNo(StaffNo);
		setDateOfVisit(DateOfVisit);
	}

	/**
	 * Returns the VisitorLic of the movie.
	 * @return movie VisitorLic
	 */
	public String getVisitorLic()
	{
		return VisitorLic;
	}
	
	/**
	 * Modifies the VisitorLic of the movie.
	 * @param VisitorLic
	 * @throws IllegalArgumentException if VisitorLic is null or empty.
	 */
	private void setVisitorLic(String VisitorLic)
	{
		if (VisitorLic == null || VisitorLic.length() == 0 )
			throw new IllegalArgumentException("Please supply a valid VisitorLic.");
		this.VisitorLic = VisitorLic;
	}
	
	/**
	 * Returns the BookingId the movie was made.
	 * @return BookingId
	 */
	public int getBookingId()
	{
		return BookingId;
	}
	
	/**
	 * Sets the movie BookingId.
	 * @param BookingId
	 * @throws IllegalArgumentException if BookingId is before 1920. 
	 */
	private void setBookingId(int BookingId)
	{
		if (BookingId < 1920)
			throw new IllegalArgumentException("Movie BookingId cannot be before 1920.");
		this.BookingId = BookingId;
	}
	
	/**
	 * Returns the SpaceNo of the movie.
	 * @return SpaceNo
	 */
	public int getSpaceNo()
	{
		return SpaceNo;
	}
	
	/**
	 * Modifies the SpaceNo of the movie.
	 * @param SpaceNo
	 * @throws IllegalArgumentException if SpaceNo is negative or 0.
	 */
	private void setSpaceNo(int SpaceNo)
	{
		if (SpaceNo <= 0)
			throw new IllegalArgumentException("Movie SpaceNo cannot be negative or 0.");
		
		this.SpaceNo = SpaceNo;
	}
	
	/**
	 * Returns the genre of the movie.
	 * @return genre
	 */
	public int getStaffNo()
	{
		return StaffNo;
	}
	
	/**
	 * Sets the genre of the movie.
	 * @param genre
	 * @throws IllegalArgumentException if genre is null or empty.
	 */
	private void setStaffNo(int StaffNo)
	{
		this.StaffNo = StaffNo;
	}
	
	/**
	 * Returns the name of the studio.
	 * @return studioName
	 */
	public Date getDateOfVisit()
	{
		return DateOfVisit;
	}
	
	/**
	 * Sets the name of the studio. 
	 * @param studioName
	 * @throws IllegalArgumentException if studio name is null or empty.
	 */
	private void setDateOfVisit(Date DateOfVisit)
	{
		if (DateOfVisit == null)
			throw new IllegalArgumentException("Please supply a valid date.");
		
		this.DateOfVisit = DateOfVisit;
	}
}
